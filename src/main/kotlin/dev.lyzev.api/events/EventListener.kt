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

package dev.lyzev.api.events

interface EventListener {
    /**
     * Determine whether this listener should handle events or not
     */
    val shouldHandleEvents: Boolean
}

/**
 * Registers an event listener for the specified event class.
 *
 * @param priority The priority of the listener (higher priority listeners are executed first).
 * @param block The function to execute when the event is triggered.
 */
inline fun <reified E : Event> EventListener.on(priority: Event.Priority = Event.Priority.MID, noinline block: (E) -> Unit) =
    EventManager.on(this, priority, block)