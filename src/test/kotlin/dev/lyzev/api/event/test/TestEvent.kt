/*
 * Copyright (c) 2023. Events
 * All rights reserved.
 */

package dev.lyzev.api.event.test

import dev.lyzev.api.events.CancellableEvent

class TestEvent(val a: Int) : CancellableEvent()