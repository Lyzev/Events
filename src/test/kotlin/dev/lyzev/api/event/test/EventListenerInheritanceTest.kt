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
 * You should have received a copy of the GNU General Public License along with Piko. If not, see https://www.gnu.org/licenses/agpl-3.0.en.html.
 */

package dev.lyzev.api.event.test

import dev.lyzev.api.event.CancellableEvent
import dev.lyzev.api.event.EventListener
import dev.lyzev.api.event.EventManager
import dev.lyzev.api.event.on
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EventListenerInheritanceTest {

    private var parentEventHandled = false
    private var childEventHandled = false

    @BeforeEach
    fun setUp() {
        parentEventHandled = false
        childEventHandled = false
    }

    @Test
    fun testParentEventListenerHandlesChildEvent() {
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