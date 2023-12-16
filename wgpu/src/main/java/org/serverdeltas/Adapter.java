package org.serverdeltas;

import jnr.ffi.Pointer;
import org.serverdeltas.wgpu_native.RustCString;
import org.serverdeltas.wgpu_native.WgpuNative;
import org.serverdeltas.wgpu_native.WgpuStruct;

public class Adapter {
    private final Pointer adapter;

    Adapter(final Pointer adapter) {
        this.adapter = adapter;
    }

    public Device requestDevice() {
        var options = WgpuStruct.createDirect(new WgpuNative.WGPUDeviceDescriptor());

        class DevicePointer extends WgpuStruct {
            public final Pointer device = new Pointer();
        }

        var callback = new WgpuNative.WGPURequestDeviceCallback() {
            @Override
            public void callback(WgpuNative.WGPURequestDeviceStatus status, Pointer device, Pointer message, Pointer userdata) {
                if (status == WgpuNative.WGPURequestDeviceStatus.Success) {
                    var devicePointer = new DevicePointer();
                    devicePointer.useMemory(userdata);

                    devicePointer.device.set(device);
                } else {
                    var messageStr = RustCString.fromPointer(message);
                    throw new RuntimeException("Error requesting adapter! " + messageStr);
                }
            }
        };

        var device = WgpuStruct.createDirect(new DevicePointer());

        Wgpu.wgpuNative.wgpuAdapterRequestDevice(adapter, Wgpu.nullptr(), callback, device.getPointerTo());

        Wgpu.assertValid(device.device.getMemory());
        return new Device(device.device.getMemory());
    }

    public Pointer getRaw() { return this.adapter; }
}
