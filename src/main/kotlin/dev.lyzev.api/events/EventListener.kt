/*
 * Copyright (c) 2023. Events
 * All rights reserved.
 */

package dev.lyzev.api.events

interface EventListener {
    /**
     * Determine whether this listener should handle events or not
     */
    fun shouldHandleEvents(): Boolean
}

/**
 * Registers an event listener for the specified event class.
 *
 * @param priority The priority of the listener (higher priority listeners are executed first).
 * @param block The function to execute when the event is triggered.
 */
inline fun <reified E : Event> EventListener.on(priority: Int = 0, noinline block: (E) -> Unit) =
    EventManager.on(this, priority, block)