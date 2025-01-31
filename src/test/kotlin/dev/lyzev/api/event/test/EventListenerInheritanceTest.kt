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
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EventListenerInheritanceTest {

    @Test
    fun testParentEventListenerHandlesChildEvent() {
        var parentEventHandled = false
        var childEventHandled = false

        object : EventListener {
            init {
                on<CancellableEvent> {
                    parentEventHandled = true
                }
                on<TestEvent> {
                    childEventHandled = true
                }
            }

            override val shouldHandleEvents: Boolean
                get() = true
        }

        TestEvent(5).fire()

        assertFalse(parentEventHandled, "Parent event listener should not handle child event")
        assertTrue(childEventHandled, "Child event listener should handle child event")
    }
}