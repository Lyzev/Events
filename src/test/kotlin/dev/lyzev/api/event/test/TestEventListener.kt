/*
 * Copyright (c) 2023. Events
 * All rights reserved.
 */

package dev.lyzev.api.event.test

import dev.lyzev.api.events.Event
import dev.lyzev.api.events.EventListener
import dev.lyzev.api.events.on

class TestEventListener : EventListener {

    var handle = true

    init {
        on<TestEvent>(Event.Priority.HIGH) { event ->
            if (event.a == 5)
                event.isCancelled = true
            println("TestEvent: ${event.a}")
        }
    }

    override val shouldHandleEvents
        get() = handle
}