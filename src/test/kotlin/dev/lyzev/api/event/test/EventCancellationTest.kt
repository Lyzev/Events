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

import dev.lyzev.api.event.*
import dev.lyzev.api.event.Event
import dev.lyzev.api.event.EventListener
import dev.lyzev.api.event.on
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EventCancellationTest {

    @Test
    fun testEventCancellation() {
        var highPriorityHandled = false
        var lowPriorityHandled = false

        object : EventListener {
            init {
                on<TestEvent>(Event.Priority.HIGH) { event ->
                    highPriorityHandled = true
                    event.isCancelled = true
                }
                on<TestEvent>(Event.Priority.LOW) {
                    lowPriorityHandled = true
                }
            }

            override val shouldHandleEvents: Boolean
                get() = true
        }

        TestEvent(1).fire()

        assertTrue(highPriorityHandled, "High priority listener should handle the event")
        assertFalse(lowPriorityHandled, "Low priority listener should not handle the event because it was cancelled")
    }
}