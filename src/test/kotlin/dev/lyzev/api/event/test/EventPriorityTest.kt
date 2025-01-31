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
import kotlin.test.Test
import kotlin.test.assertEquals

class EventPriorityTest {

    @Test
    fun testEventPriority() {
        val eventOrder = mutableListOf<Event.Priority>()

        object : EventListener {
            init {
                on<TestEvent>(Event.Priority.LOW) {
                    eventOrder.add(Event.Priority.LOW)
                }
                on<TestEvent>(Event.Priority.HIGH) {
                    eventOrder.add(Event.Priority.HIGH)
                }
                on<TestEvent>(Event.Priority.MID) {
                    eventOrder.add(Event.Priority.MID)
                }
            }

            override val shouldHandleEvents: Boolean
                get() = true
        }

        TestEvent(1).fire()

        println(eventOrder)
        assertEquals(listOf(Event.Priority.HIGH, Event.Priority.MID, Event.Priority.LOW), eventOrder, "Event listeners should be called in priority order")
    }
}