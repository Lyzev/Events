/*
 * This file is part of https://github.com/SchizoidDevelopment/piko.
 *
 * Copyright (c) 2025. Lyzev
 *
 * Piko is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License, or
 * (at your option) any later version.
 *
 * Piko is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Piko. If not, see <https://www.gnu.org/licenses/>.
 */

package dev.lyzev.api.event.test

import dev.lyzev.api.event.Event
import dev.lyzev.api.event.EventListener
import dev.lyzev.api.event.EventManager
import dev.lyzev.api.event.on
import kotlin.system.measureNanoTime
import kotlin.test.Test

class EventManagerBenchmarkTest {

    @Test
    fun benchmarkEventTriggering() {
        object : EventListener {
            init {
                val event = TestEvent(5)

                on<TestEvent>(Event.Priority.HIGH) { event ->
                    if (event.a == 5) event.isCancelled = true
                }

                val time = measureNanoTime {
                    for (i in 1..10000) {
                        EventManager(event)
                    }
                }

                println("Each event took ${time / 10000}ns")
                println("Total time: $time ns")
            }

            override val shouldHandleEvents: Boolean
                get() = true
        }
    }
}