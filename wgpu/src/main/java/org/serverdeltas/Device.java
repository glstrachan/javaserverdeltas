package org.serverdeltas;

import jnr.ffi.Pointer;

public class Device {
    private final Pointer device;

    public Device(final Pointer device) {
        this.device = device;
    }

    public Queue getQueue() {
        var queue = Wgpu.wgpuNative.wgpuDeviceGetQueue(device);
        Wgpu.assertValid(queue);

        return new Queue(queue);
    }

    public Pointer getRaw() {
        return device;
    }
}
