/*
 * Copyright (c) 2023. Events
 * All rights reserved.
 */

package dev.lyzev.api.event.test

fun main() {
    TestEventListener()
    TestEvent(5).fire()
    TestEvent(8).fire()
}