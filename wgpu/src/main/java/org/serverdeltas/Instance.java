package org.serverdeltas;

import jnr.ffi.Pointer;
import jnr.ffi.provider.IntPointer;
import org.serverdeltas.wgpu_native.RustCString;
import org.serverdeltas.wgpu_native.WgpuNative;
import org.serverdeltas.wgpu_native.WgpuStruct;

public class Instance {
    private final Pointer instance;

    public Instance(final Pointer instance) {
        this.instance = instance;
    }

    public Surface createSurface(long hwnd) {
        var surfaceDescriptorHwnd = WgpuStruct.createDirect(new WgpuNative.WGPUSurfaceDescriptorFromWindowsHWND());
        surfaceDescriptorHwnd.setHwnd(Pointer.wrap(org.serverdeltas.wgpu_native.Wgpu.getRuntime(), hwnd));

        surfaceDescriptorHwnd.getChain().setNext(Wgpu.nullptr());
        surfaceDescriptorHwnd.getChain().setSType(WgpuNative.WGPUSType.SurfaceDescriptorFromWindowsHWND);

        var surfaceDescriptor = WgpuStruct.createDirect(new WgpuNative.WGPUSurfaceDescriptor());
        surfaceDescriptor.setNextInChain(surfaceDescriptorHwnd.getPointerTo());
        surfaceDescriptor.setLabel("HelloSurface");

        var rawSurface = Wgpu.wgpuNative.wgpuInstanceCreateSurface(instance, surfaceDescriptor.getPointerTo());
        Wgpu.assertValid(rawSurface);

        return new Surface(rawSurface);
    }

    public Adapter requestAdapter(Surface surface) {
        var options = WgpuStruct.createDirect(new WgpuNative.WGPURequestAdapterOptions());
        options.setCompatibleSurface(surface.getRawSurface());
        options.setBackendType(WgpuNative.WGPUBackendType.Vulkan);

        class AdapterPointer extends WgpuStruct {
            public final Pointer adapter = new Pointer();
        }

        var callback = new WgpuNative.WGPURequestAdapterCallback() {
            @Override
            public void callback(WgpuNative.WGPURequestAdapterStatus status, Pointer adapter, Pointer message, Pointer userdata) {
                if (status == WgpuNative.WGPURequestAdapterStatus.Success) {
                    var adapterPtr = new AdapterPointer();
                    adapterPtr.useMemory(userdata);

                    adapterPtr.adapter.set(adapter);
                    System.out.println(message);
                } else {
                    var messageStr = RustCString.fromPointer(message);
                    throw new RuntimeException("Error requesting adapter! " + messageStr);
                }
            }
        };

        var adapter = WgpuStruct.createDirect(new AdapterPointer());

        Wgpu.wgpuNative.wgpuInstanceRequestAdapter(instance, options.getPointerTo(), callback, adapter.getPointerTo());

        Wgpu.assertValid(adapter.adapter.get());
        return new Adapter(adapter.adapter.get());
    }
}
