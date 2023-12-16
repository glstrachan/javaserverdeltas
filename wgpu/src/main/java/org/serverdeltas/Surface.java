package org.serverdeltas;

import jnr.ffi.Pointer;
import jnr.ffi.Struct;
import org.serverdeltas.wgpu_native.WgpuNative;
import org.serverdeltas.wgpu_native.WgpuStruct;

public class Surface {
    private final Pointer surface;

    public Surface(final Pointer surface) {
        this.surface = surface;
    }

    public void configure(Configuration configuration) {
        var configurationRaw = WgpuStruct.createDirect(new WgpuNative.WGPUSurfaceConfiguration());

        configurationRaw.setDevice(configuration.device.getRaw());
        configurationRaw.setWidth(configuration.width);
        configurationRaw.setHeight(configuration.height);
        configurationRaw.setAlphaMode(configuration.alphaMode);
        configurationRaw.setUsage(configuration.usage);
        configurationRaw.setFormat(configuration.format);
        configurationRaw.setViewFormatCount(configuration.viewFormats.length);
        configurationRaw.setViewFormats(org.serverdeltas.wgpu_native.Wgpu.createEnumArrayPointer(configuration.viewFormats));

        Wgpu.wgpuNative.wgpuSurfaceConfigure(surface, configurationRaw.getPointerTo());
    }

    public WgpuNative.WGPUSurfaceCapabilities getCapabilities(Adapter adapter) {
        var capabilities = new WgpuNative.WGPUSurfaceCapabilities();
        Wgpu.wgpuNative.wgpuSurfaceGetCapabilities(surface, adapter.getRaw(), capabilities.getPointerTo());

        return capabilities;
    }


    public Pointer getRawSurface() {
        return this.surface;
    }

    @Override
    public String toString() {
        return "Raw: " + surface.toString();
    }

    public static final class Configuration {
        public Device device;
        public WgpuNative.WGPUTextureFormat format;
        public long usage = 0;
        public WgpuNative.WGPUTextureFormat[] viewFormats = new WgpuNative.WGPUTextureFormat[0];
        public WgpuNative.WGPUCompositeAlphaMode alphaMode = WgpuNative.WGPUCompositeAlphaMode.Auto;
        public WgpuNative.WGPUPresentMode presentMode = WgpuNative.WGPUPresentMode.Fifo;
        public int width;
        public int height;

        public Configuration(Device device, int width, int height) {
            this.device = device;
            this.width = width;
            this.height = height;
        }

        public Configuration withUsage(long usage) {
            this.usage = usage;
            return this;
        }

        public Configuration withAlphaMode(WgpuNative.WGPUCompositeAlphaMode alphaMode) {
            this.alphaMode = alphaMode;
            return this;
        }

        public Configuration withViewFormat(WgpuNative.WGPUTextureFormat[] viewFormats) {
            this.viewFormats = viewFormats;
            return this;
        }

        public Configuration withFormat(WgpuNative.WGPUTextureFormat format) {
            this.format = format;
            return this;
        }

        private Configuration() {}
    }

    public static class Descriptor {

    }
}
