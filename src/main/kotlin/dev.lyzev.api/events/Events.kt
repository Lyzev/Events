/*
 * Copyright (c) 2023. Events
 * All rights reserved.
 */

package dev.lyzev.api.events

interface Event {
    /**
     * Trigger this event by invoking the EventManager with this instance
     */
    fun fire() = EventManager(this)
}

abstract class CancellableEvent : Event {
    // Flag indicating whether this event has been cancelled or not
    var isCancelled: Boolean = false
}