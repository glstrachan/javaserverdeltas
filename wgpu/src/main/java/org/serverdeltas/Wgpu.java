package org.serverdeltas;

import jnr.ffi.Pointer;
import org.serverdeltas.wgpu_native.RustCString;
import org.serverdeltas.wgpu_native.SharedLibraryLoader;
import org.serverdeltas.wgpu_native.WgpuNative;

import java.io.File;

public class Wgpu {
    private static final File file = new SharedLibraryLoader().load("wgpu_native");
    static WgpuNative.WgpuNativeJNI wgpuNative;

    /**
     * Loads the wgpu-native library from the classpath
     * and calls {@link org.serverdeltas.wgpu_native.Wgpu#init(File)}
     */
    public static void loadWgpuNative() {
        org.serverdeltas.wgpu_native.Wgpu.init(file);
        wgpuNative = org.serverdeltas.wgpu_native.Wgpu.wgpuNative;
    }

    public static void assertValid(Pointer ptr) {
        if (ptr.address() == 0) {
            throw new NullPointerException();
        }
    }

    public static Pointer nullptr() {
        return org.serverdeltas.wgpu_native.Wgpu.createNullPointer();
    }

    public static Instance createInstance() {
        wgpuNative.wgpuSetLogLevel(WgpuNative.WGPULogLevel.Warn);

        wgpuNative.wgpuSetLogCallback(new WgpuNative.WGPULogCallback() {
            @Override
            public void callback(WgpuNative.WGPULogLevel level, Pointer message, Pointer userdata) {
                var messageStr = RustCString.fromPointer(message);
                var ll = switch (level) {
                    case Off -> "Off";
                    case Error -> "Error";
                    case Warn -> "Warn";
                    case Info -> "Info";
                    case Debug -> "Debug";
                    case Trace -> "Trace";
                    case Force32 -> "Force32";
                };
                System.out.println("Log[" + ll + "]: " + messageStr);
            }
        }, nullptr());

        var instance = wgpuNative.wgpuCreateInstance(nullptr());
        Wgpu.assertValid(instance);

        return new Instance(instance);
    }
}
