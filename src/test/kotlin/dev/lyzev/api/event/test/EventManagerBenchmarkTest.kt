/*
 * This file is part of https://github.com/Lyzev/Events.
 *
 * Copyright (c) 2025. Lyzev
 *
 * Events is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License, or
 * (at your option) any later version.
 *
 * Events is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Events. If not, see <https://www.gnu.org/licenses/>.
 */

package dev.lyzev.api.event.test

import dev.lyzev.api.events.*
import kotlin.system.measureTimeMillis
import kotlin.reflect.KClass
import kotlin.system.measureNanoTime
import kotlin.test.Test
import kotlin.test.assertTrue

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