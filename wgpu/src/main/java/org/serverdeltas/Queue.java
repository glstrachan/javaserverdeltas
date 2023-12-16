package org.serverdeltas;

import jnr.ffi.Pointer;

public class Queue {
    private final Pointer queue;

    public Queue(final Pointer queue) {
        this.queue = queue;
    }
}
