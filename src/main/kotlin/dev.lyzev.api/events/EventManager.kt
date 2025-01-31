/*
 * This file is part of https://github.com/Lyzev/Events.
 *
 * Copyright (c) 2023-2025. Lyzev
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

import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

object EventManager {

    /**
     * Create a map of event classes to a list of event listeners, their priority and their handling function
     */
    private val listeners = mutableMapOf<KClass<*>, MutableList<Triple<EventListener, Event.Priority, (Event) -> Unit>>>()

    /**
     * Registers an event listener for the specified event class.
     *
     * @param eventListener The listener to register.
     * @param clazz The class of the event to listen for.
     * @param priority The priority of the listener (higher priority listeners are executed first).
     * @param block The function to execute when the event is triggered.
     */
    fun on(eventListener: EventListener, clazz: KClass<*>, priority: Event.Priority, block: (Event) -> Unit) =
        listeners.getOrPut(clazz) { mutableListOf() }.add(Triple(eventListener, priority, block))

    /**
     * Register an event listener for a specific type of event with a given priority and handling function, using reified type parameter
     *
     * @param eventListener The event listener to register
     * @param priority The priority of this listener, higher priority listeners are invoked first
     * @param block The handling function for this listener
     */
    @Suppress("UNCHECKED_CAST")
    inline fun <reified E : Event> on(eventListener: EventListener, priority: Event.Priority, noinline block: (E) -> Unit) =
        on(eventListener, E::class, priority, block as (Event) -> Unit)

    /**
     * Triggers an event, executing all registered event listeners for the event class or its superclasses.
     *
     * @param event The event to trigger.
     */
    operator fun <E : Event> invoke(event: E) {
        // Filter the listeners to only those interested in the given event or its superclass, sorted by priority
        for (listener in listeners.filter { (key, _) -> key == event::class }.values.flatten()
            .filter { it.first.shouldHandleEvents }.sortedBy { -it.second.value }.map { it.third }) {
            // Attempt to run the listener's handling function and catch any exceptions
            runCatching {
                listener(event)
            }.onFailure {
                it.printStackTrace()
            }
            // If the event is cancellable and has been cancelled, stop processing further listeners
            if (event is CancellableEvent && event.isCancelled) break
        }
    }
}

interface Event {
    /**
     * Trigger this event by invoking the EventManager with this instance
     */
    fun fire() = EventManager(this)

    /**
     * The priority of an event listener
     *
     * @property value The value of the priority
     */
    enum class Priority(val value: Int) {
        LOWEST(-2),
        LOW(-1),
        MID(0),
        HIGH(1),
        HIGHEST(2)
    }
}

abstract class CancellableEvent : Event {
    /**
     * Flag indicating whether this event has been cancelled or not
     */
    var isCancelled: Boolean = false

    override fun fire() {
        isCancelled = false
        super.fire()
    }
}
