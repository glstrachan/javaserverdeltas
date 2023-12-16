package org.serverdeltas.wgpu_native;

import jnr.ffi.*;
import jnr.ffi.Runtime;
import jnr.ffi.annotations.Delegate;
import jnr.ffi.Pointer;
import jnr.ffi.types.int64_t;
import jnr.ffi.types.u_int32_t;
import jnr.ffi.types.int32_t;
import jnr.ffi.types.u_int64_t;

public class WgpuNative {
    public enum WGPUAdapterType {
        DiscreteGPU,
        IntegratedGPU,
        CPU,
        Unknown,
        Force32,
    }
    public enum WGPUAddressMode {
        Repeat,
        MirrorRepeat,
        ClampToEdge,
        Force32,
    }
    public enum WGPUBackendType {
        Undefined,
        Null,
        WebGPU,
        D3D11,
        D3D12,
        Metal,
        Vulkan,
        OpenGL,
        OpenGLES,
        Force32,
    }
    public enum WGPUBlendFactor {
        Zero,
        One,
        Src,
        OneMinusSrc,
        SrcAlpha,
        OneMinusSrcAlpha,
        Dst,
        OneMinusDst,
        DstAlpha,
        OneMinusDstAlpha,
        SrcAlphaSaturated,
        Constant,
        OneMinusConstant,
        Force32,
    }
    public enum WGPUBlendOperation {
        Add,
        Subtract,
        ReverseSubtract,
        Min,
        Max,
        Force32,
    }
    public enum WGPUBufferBindingType {
        Undefined,
        Uniform,
        Storage,
        ReadOnlyStorage,
        Force32,
    }
    public enum WGPUBufferMapAsyncStatus {
        Success,
        ValidationError,
        Unknown,
        DeviceLost,
        DestroyedBeforeCallback,
        UnmappedBeforeCallback,
        MappingAlreadyPending,
        OffsetOutOfRange,
        SizeOutOfRange,
        Force32,
    }
    public enum WGPUBufferMapState {
        Unmapped,
        Pending,
        Mapped,
        Force32,
    }
    public enum WGPUCompareFunction {
        Undefined,
        Never,
        Less,
        LessEqual,
        Greater,
        GreaterEqual,
        Equal,
        NotEqual,
        Always,
        Force32,
    }
    public enum WGPUCompilationInfoRequestStatus {
        Success,
        Error,
        DeviceLost,
        Unknown,
        Force32,
    }
    public enum WGPUCompilationMessageType {
        Error,
        Warning,
        Info,
        Force32,
    }
    public enum WGPUCompositeAlphaMode {
        Auto,
        Opaque,
        Premultiplied,
        Unpremultiplied,
        Inherit,
        Force32,
    }
    public enum WGPUCreatePipelineAsyncStatus {
        Success,
        ValidationError,
        InternalError,
        DeviceLost,
        DeviceDestroyed,
        Unknown,
        Force32,
    }
    public enum WGPUCullMode {
        None,
        Front,
        Back,
        Force32,
    }
    public enum WGPUDeviceLostReason {
        Undefined,
        Destroyed,
        Force32,
    }
    public enum WGPUErrorFilter {
        Validation,
        OutOfMemory,
        Internal,
        Force32,
    }
    public enum WGPUErrorType {
        NoError,
        Validation,
        OutOfMemory,
        Internal,
        Unknown,
        DeviceLost,
        Force32,
    }
    public enum WGPUFeatureName {
        Undefined,
        DepthClipControl,
        Depth32FloatStencil8,
        TimestampQuery,
        TextureCompressionBC,
        TextureCompressionETC2,
        TextureCompressionASTC,
        IndirectFirstInstance,
        ShaderF16,
        RG11B10UfloatRenderable,
        BGRA8UnormStorage,
        Float32Filterable,
        Force32,
    }
    public enum WGPUFilterMode {
        Nearest,
        Linear,
        Force32,
    }
    public enum WGPUFrontFace {
        CCW,
        CW,
        Force32,
    }
    public enum WGPUIndexFormat {
        Undefined,
        Uint16,
        Uint32,
        Force32,
    }
    public enum WGPULoadOp {
        Undefined,
        Clear,
        Load,
        Force32,
    }
    public enum WGPUMipmapFilterMode {
        Nearest,
        Linear,
        Force32,
    }
    public enum WGPUPowerPreference {
        Undefined,
        LowPower,
        HighPerformance,
        Force32,
    }
    public enum WGPUPresentMode {
        Fifo,
        FifoRelaxed,
        Immediate,
        Mailbox,
        Force32,
    }
    public enum WGPUPrimitiveTopology {
        PointList,
        LineList,
        LineStrip,
        TriangleList,
        TriangleStrip,
        Force32,
    }
    public enum WGPUQueryType {
        Occlusion,
        Timestamp,
        Force32,
    }
    public enum WGPUQueueWorkDoneStatus {
        Success,
        Error,
        Unknown,
        DeviceLost,
        Force32,
    }
    public enum WGPURequestAdapterStatus {
        Success,
        Unavailable,
        Error,
        Unknown,
        Force32,
    }
    public enum WGPURequestDeviceStatus {
        Success,
        Error,
        Unknown,
        Force32,
    }
    public enum WGPUSType {
        Invalid,
        SurfaceDescriptorFromMetalLayer,
        SurfaceDescriptorFromWindowsHWND,
        SurfaceDescriptorFromXlibWindow,
        SurfaceDescriptorFromCanvasHTMLSelector,
        ShaderModuleSPIRVDescriptor,
        ShaderModuleWGSLDescriptor,
        PrimitiveDepthClipControl,
        SurfaceDescriptorFromWaylandSurface,
        SurfaceDescriptorFromAndroidNativeWindow,
        SurfaceDescriptorFromXcbWindow,
        RenderPassDescriptorMaxDrawCount,
        Force32,
    }
    public enum WGPUSamplerBindingType {
        Undefined,
        Filtering,
        NonFiltering,
        Comparison,
        Force32,
    }
    public enum WGPUStencilOperation {
        Keep,
        Zero,
        Replace,
        Invert,
        IncrementClamp,
        DecrementClamp,
        IncrementWrap,
        DecrementWrap,
        Force32,
    }
    public enum WGPUStorageTextureAccess {
        Undefined,
        WriteOnly,
        ReadOnly,
        ReadWrite,
        Force32,
    }
    public enum WGPUStoreOp {
        Undefined,
        Store,
        Discard,
        Force32,
    }
    public enum WGPUSurfaceGetCurrentTextureStatus {
        Success,
        Timeout,
        Outdated,
        Lost,
        OutOfMemory,
        DeviceLost,
        Force32,
    }
    public enum WGPUTextureAspect {
        All,
        StencilOnly,
        DepthOnly,
        Force32,
    }
    public enum WGPUTextureDimension {
        WGPUTextureDimension_1D,
        WGPUTextureDimension_2D,
        WGPUTextureDimension_3D,
        Force32,
    }
    public enum WGPUTextureFormat {
        Undefined,
        R8Unorm,
        R8Snorm,
        R8Uint,
        R8Sint,
        R16Uint,
        R16Sint,
        R16Float,
        RG8Unorm,
        RG8Snorm,
        RG8Uint,
        RG8Sint,
        R32Float,
        R32Uint,
        R32Sint,
        RG16Uint,
        RG16Sint,
        RG16Float,
        RGBA8Unorm,
        RGBA8UnormSrgb,
        RGBA8Snorm,
        RGBA8Uint,
        RGBA8Sint,
        BGRA8Unorm,
        BGRA8UnormSrgb,
        RGB10A2Uint,
        RGB10A2Unorm,
        RG11B10Ufloat,
        RGB9E5Ufloat,
        RG32Float,
        RG32Uint,
        RG32Sint,
        RGBA16Uint,
        RGBA16Sint,
        RGBA16Float,
        RGBA32Float,
        RGBA32Uint,
        RGBA32Sint,
        Stencil8,
        Depth16Unorm,
        Depth24Plus,
        Depth24PlusStencil8,
        Depth32Float,
        Depth32FloatStencil8,
        BC1RGBAUnorm,
        BC1RGBAUnormSrgb,
        BC2RGBAUnorm,
        BC2RGBAUnormSrgb,
        BC3RGBAUnorm,
        BC3RGBAUnormSrgb,
        BC4RUnorm,
        BC4RSnorm,
        BC5RGUnorm,
        BC5RGSnorm,
        BC6HRGBUfloat,
        BC6HRGBFloat,
        BC7RGBAUnorm,
        BC7RGBAUnormSrgb,
        ETC2RGB8Unorm,
        ETC2RGB8UnormSrgb,
        ETC2RGB8A1Unorm,
        ETC2RGB8A1UnormSrgb,
        ETC2RGBA8Unorm,
        ETC2RGBA8UnormSrgb,
        EACR11Unorm,
        EACR11Snorm,
        EACRG11Unorm,
        EACRG11Snorm,
        ASTC4x4Unorm,
        ASTC4x4UnormSrgb,
        ASTC5x4Unorm,
        ASTC5x4UnormSrgb,
        ASTC5x5Unorm,
        ASTC5x5UnormSrgb,
        ASTC6x5Unorm,
        ASTC6x5UnormSrgb,
        ASTC6x6Unorm,
        ASTC6x6UnormSrgb,
        ASTC8x5Unorm,
        ASTC8x5UnormSrgb,
        ASTC8x6Unorm,
        ASTC8x6UnormSrgb,
        ASTC8x8Unorm,
        ASTC8x8UnormSrgb,
        ASTC10x5Unorm,
        ASTC10x5UnormSrgb,
        ASTC10x6Unorm,
        ASTC10x6UnormSrgb,
        ASTC10x8Unorm,
        ASTC10x8UnormSrgb,
        ASTC10x10Unorm,
        ASTC10x10UnormSrgb,
        ASTC12x10Unorm,
        ASTC12x10UnormSrgb,
        ASTC12x12Unorm,
        ASTC12x12UnormSrgb,
        Force32,
    }
    public enum WGPUTextureSampleType {
        Undefined,
        Float,
        UnfilterableFloat,
        Depth,
        Sint,
        Uint,
        Force32,
    }
    public enum WGPUTextureViewDimension {
        Undefined,
        WGPUTextureViewDimension_1D,
        WGPUTextureViewDimension_2D,
        WGPUTextureViewDimension_2DArray,
        Cube,
        CubeArray,
        WGPUTextureViewDimension_3D,
        Force32,
    }
    public enum WGPUVertexFormat {
        Undefined,
        Uint8x2,
        Uint8x4,
        Sint8x2,
        Sint8x4,
        Unorm8x2,
        Unorm8x4,
        Snorm8x2,
        Snorm8x4,
        Uint16x2,
        Uint16x4,
        Sint16x2,
        Sint16x4,
        Unorm16x2,
        Unorm16x4,
        Snorm16x2,
        Snorm16x4,
        Float16x2,
        Float16x4,
        Float32,
        Float32x2,
        Float32x3,
        Float32x4,
        Uint32,
        Uint32x2,
        Uint32x3,
        Uint32x4,
        Sint32,
        Sint32x2,
        Sint32x3,
        Sint32x4,
        Force32,
    }
    public enum WGPUVertexStepMode {
        Vertex,
        Instance,
        VertexBufferNotUsed,
        Force32,
    }
    public enum WGPUBufferUsage {
        None,
        MapRead,
        MapWrite,
        CopySrc,
        CopyDst,
        Index,
        Vertex,
        Uniform,
        Storage,
        Indirect,
        QueryResolve,
        Force32,
    }
    public enum WGPUColorWriteMask {
        None,
        Red,
        Green,
        Blue,
        Alpha,
        All,
        Force32,
    }
    public enum WGPUMapMode {
        None,
        Read,
        Write,
        Force32,
    }
    public enum WGPUShaderStage {
        None,
        Vertex,
        Fragment,
        Compute,
        Force32,
    }
    public enum WGPUTextureUsage {
        None,
        CopySrc,
        CopyDst,
        TextureBinding,
        StorageBinding,
        RenderAttachment,
        Force32,
    }
    public interface WGPUBufferMapCallback {
        @Delegate
        void callback(WGPUBufferMapAsyncStatus status, Pointer userdata);
    }
    public interface WGPUCompilationInfoCallback {
        @Delegate
        void callback(WGPUCompilationInfoRequestStatus status, Pointer compilationInfo, Pointer userdata);
    }
    public interface WGPUCreateComputePipelineAsyncCallback {
        @Delegate
        void callback(WGPUCreatePipelineAsyncStatus status, Pointer pipeline, Pointer message, Pointer userdata);
    }
    public interface WGPUCreateRenderPipelineAsyncCallback {
        @Delegate
        void callback(WGPUCreatePipelineAsyncStatus status, Pointer pipeline, Pointer message, Pointer userdata);
    }
    public interface WGPUDeviceLostCallback {
        @Delegate
        void callback(WGPUDeviceLostReason reason, Pointer message, Pointer userdata);
    }
    public interface WGPUErrorCallback {
        @Delegate
        void callback(WGPUErrorType type, Pointer message, Pointer userdata);
    }
    public interface WGPUProc {
        @Delegate
        void callback();
    }
    public interface WGPUQueueWorkDoneCallback {
        @Delegate
        void callback(WGPUQueueWorkDoneStatus status, Pointer userdata);
    }
    public interface WGPURequestAdapterCallback {
        @Delegate
        void callback(WGPURequestAdapterStatus status, Pointer adapter, Pointer message, Pointer userdata);
    }
    public interface WGPURequestDeviceCallback {
        @Delegate
        void callback(WGPURequestDeviceStatus status, Pointer device, Pointer message, Pointer userdata);
    }
    public static class WGPUChainedStruct extends WgpuStruct {
        private final Struct.Pointer next = new Struct.Pointer();
        private final Struct.Enum<WGPUSType> sType = new Struct.Enum<>(WGPUSType.class);
        public WGPUChainedStruct() {}

        public WGPUChainedStruct(Runtime runtime) { super(runtime); }

        public static WGPUChainedStruct create() { return new WGPUChainedStruct(); }

        public jnr.ffi.Pointer getNext() { return this.next.get(); }
        public WGPUChainedStruct setNext(jnr.ffi.Pointer value) { this.next.set(value); return this; }
        public WGPUSType getSType() { return this.sType.get(); }
        public WGPUChainedStruct setSType(WGPUSType value) { this.sType.set(value); return this; }
    }
    public static class WGPUChainedStructOut extends WgpuStruct {
        private final Struct.Pointer next = new Struct.Pointer();
        private final Struct.Enum<WGPUSType> sType = new Struct.Enum<>(WGPUSType.class);
        public WGPUChainedStructOut() {}

        public WGPUChainedStructOut(Runtime runtime) { super(runtime); }

        public static WGPUChainedStructOut create() { return new WGPUChainedStructOut(); }

        public jnr.ffi.Pointer getNext() { return this.next.get(); }
        public WGPUChainedStructOut setNext(jnr.ffi.Pointer value) { this.next.set(value); return this; }
        public WGPUSType getSType() { return this.sType.get(); }
        public WGPUChainedStructOut setSType(WGPUSType value) { this.sType.set(value); return this; }
    }
    public static class WGPUAdapterProperties extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Unsigned32 vendorID = new Struct.Unsigned32();
        private final @CStrPointer Struct.Pointer vendorName = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer architecture = new Struct.Pointer();
        private final Struct.Unsigned32 deviceID = new Struct.Unsigned32();
        private final @CStrPointer Struct.Pointer name = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer driverDescription = new Struct.Pointer();
        private final Struct.Enum<WGPUAdapterType> adapterType = new Struct.Enum<>(WGPUAdapterType.class);
        private final Struct.Enum<WGPUBackendType> backendType = new Struct.Enum<>(WGPUBackendType.class);
        public WGPUAdapterProperties() {}

        public WGPUAdapterProperties(Runtime runtime) { super(runtime); }

        public static WGPUAdapterProperties create() { return new WGPUAdapterProperties(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUAdapterProperties setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public long getVendorID() { return this.vendorID.get(); }
        public WGPUAdapterProperties setVendorID(long value) { this.vendorID.set(value); return this; }
        public java.lang.String getVendorName() { return RustCString.fromPointer(this.vendorName.get()); }
        public WGPUAdapterProperties setVendorName(java.lang.String value) { this.vendorName.set(RustCString.toPointer(value)); return this; }
        public java.lang.String getArchitecture() { return RustCString.fromPointer(this.architecture.get()); }
        public WGPUAdapterProperties setArchitecture(java.lang.String value) { this.architecture.set(RustCString.toPointer(value)); return this; }
        public long getDeviceID() { return this.deviceID.get(); }
        public WGPUAdapterProperties setDeviceID(long value) { this.deviceID.set(value); return this; }
        public java.lang.String getName() { return RustCString.fromPointer(this.name.get()); }
        public WGPUAdapterProperties setName(java.lang.String value) { this.name.set(RustCString.toPointer(value)); return this; }
        public java.lang.String getDriverDescription() { return RustCString.fromPointer(this.driverDescription.get()); }
        public WGPUAdapterProperties setDriverDescription(java.lang.String value) { this.driverDescription.set(RustCString.toPointer(value)); return this; }
        public WGPUAdapterType getAdapterType() { return this.adapterType.get(); }
        public WGPUAdapterProperties setAdapterType(WGPUAdapterType value) { this.adapterType.set(value); return this; }
        public WGPUBackendType getBackendType() { return this.backendType.get(); }
        public WGPUAdapterProperties setBackendType(WGPUBackendType value) { this.backendType.set(value); return this; }
    }
    public static class WGPUBindGroupEntry extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Unsigned32 binding = new Struct.Unsigned32();
        private final Struct.Pointer buffer = new Struct.Pointer();
        private final Struct.UnsignedLong offset = new Struct.UnsignedLong();
        private final Struct.UnsignedLong size = new Struct.UnsignedLong();
        private final Struct.Pointer sampler = new Struct.Pointer();
        private final Struct.Pointer textureView = new Struct.Pointer();
        public WGPUBindGroupEntry() {}

        public WGPUBindGroupEntry(Runtime runtime) { super(runtime); }

        public static WGPUBindGroupEntry create() { return new WGPUBindGroupEntry(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUBindGroupEntry setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public long getBinding() { return this.binding.get(); }
        public WGPUBindGroupEntry setBinding(long value) { this.binding.set(value); return this; }
        public jnr.ffi.Pointer getBuffer() { return this.buffer.get(); }
        public WGPUBindGroupEntry setBuffer(jnr.ffi.Pointer value) { this.buffer.set(value); return this; }
        public long getOffset() { return this.offset.get(); }
        public WGPUBindGroupEntry setOffset(long value) { this.offset.set(value); return this; }
        public long getSize() { return this.size.get(); }
        public WGPUBindGroupEntry setSize(long value) { this.size.set(value); return this; }
        public jnr.ffi.Pointer getSampler() { return this.sampler.get(); }
        public WGPUBindGroupEntry setSampler(jnr.ffi.Pointer value) { this.sampler.set(value); return this; }
        public jnr.ffi.Pointer getTextureView() { return this.textureView.get(); }
        public WGPUBindGroupEntry setTextureView(jnr.ffi.Pointer value) { this.textureView.set(value); return this; }
    }
    public static class WGPUBlendComponent extends WgpuStruct {
        private final Struct.Enum<WGPUBlendOperation> operation = new Struct.Enum<>(WGPUBlendOperation.class);
        private final Struct.Enum<WGPUBlendFactor> srcFactor = new Struct.Enum<>(WGPUBlendFactor.class);
        private final Struct.Enum<WGPUBlendFactor> dstFactor = new Struct.Enum<>(WGPUBlendFactor.class);
        public WGPUBlendComponent() {}

        public WGPUBlendComponent(Runtime runtime) { super(runtime); }

        public static WGPUBlendComponent create() { return new WGPUBlendComponent(); }

        public WGPUBlendOperation getOperation() { return this.operation.get(); }
        public WGPUBlendComponent setOperation(WGPUBlendOperation value) { this.operation.set(value); return this; }
        public WGPUBlendFactor getSrcFactor() { return this.srcFactor.get(); }
        public WGPUBlendComponent setSrcFactor(WGPUBlendFactor value) { this.srcFactor.set(value); return this; }
        public WGPUBlendFactor getDstFactor() { return this.dstFactor.get(); }
        public WGPUBlendComponent setDstFactor(WGPUBlendFactor value) { this.dstFactor.set(value); return this; }
    }
    public static class WGPUBufferBindingLayout extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Enum<WGPUBufferBindingType> type = new Struct.Enum<>(WGPUBufferBindingType.class);
        private final Struct.Unsigned32 hasDynamicOffset = new Struct.Unsigned32();
        private final Struct.UnsignedLong minBindingSize = new Struct.UnsignedLong();
        public WGPUBufferBindingLayout() {}

        public WGPUBufferBindingLayout(Runtime runtime) { super(runtime); }

        public static WGPUBufferBindingLayout create() { return new WGPUBufferBindingLayout(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUBufferBindingLayout setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPUBufferBindingType getType() { return this.type.get(); }
        public WGPUBufferBindingLayout setType(WGPUBufferBindingType value) { this.type.set(value); return this; }
        public long getHasDynamicOffset() { return this.hasDynamicOffset.get(); }
        public WGPUBufferBindingLayout setHasDynamicOffset(long value) { this.hasDynamicOffset.set(value); return this; }
        public long getMinBindingSize() { return this.minBindingSize.get(); }
        public WGPUBufferBindingLayout setMinBindingSize(long value) { this.minBindingSize.set(value); return this; }
    }
    public static class WGPUBufferDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Unsigned32 usage = new Struct.Unsigned32();
        private final Struct.UnsignedLong size = new Struct.UnsignedLong();
        private final Struct.Unsigned32 mappedAtCreation = new Struct.Unsigned32();
        public WGPUBufferDescriptor() {}

        public WGPUBufferDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUBufferDescriptor create() { return new WGPUBufferDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUBufferDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUBufferDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public long getUsage() { return this.usage.get(); }
        public WGPUBufferDescriptor setUsage(long value) { this.usage.set(value); return this; }
        public long getSize() { return this.size.get(); }
        public WGPUBufferDescriptor setSize(long value) { this.size.set(value); return this; }
        public long getMappedAtCreation() { return this.mappedAtCreation.get(); }
        public WGPUBufferDescriptor setMappedAtCreation(long value) { this.mappedAtCreation.set(value); return this; }
    }
    public static class WGPUColor extends WgpuStruct {
        private final Struct.Double r = new Struct.Double();
        private final Struct.Double g = new Struct.Double();
        private final Struct.Double b = new Struct.Double();
        private final Struct.Double a = new Struct.Double();
        public WGPUColor() {}

        public WGPUColor(Runtime runtime) { super(runtime); }

        public static WGPUColor create() { return new WGPUColor(); }

        public double getR() { return this.r.get(); }
        public WGPUColor setR(double value) { this.r.set(value); return this; }
        public double getG() { return this.g.get(); }
        public WGPUColor setG(double value) { this.g.set(value); return this; }
        public double getB() { return this.b.get(); }
        public WGPUColor setB(double value) { this.b.set(value); return this; }
        public double getA() { return this.a.get(); }
        public WGPUColor setA(double value) { this.a.set(value); return this; }
    }
    public static class WGPUCommandBufferDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        public WGPUCommandBufferDescriptor() {}

        public WGPUCommandBufferDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUCommandBufferDescriptor create() { return new WGPUCommandBufferDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUCommandBufferDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUCommandBufferDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPUCommandEncoderDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        public WGPUCommandEncoderDescriptor() {}

        public WGPUCommandEncoderDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUCommandEncoderDescriptor create() { return new WGPUCommandEncoderDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUCommandEncoderDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUCommandEncoderDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPUCompilationMessage extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer message = new Struct.Pointer();
        private final Struct.Enum<WGPUCompilationMessageType> type = new Struct.Enum<>(WGPUCompilationMessageType.class);
        private final Struct.UnsignedLong lineNum = new Struct.UnsignedLong();
        private final Struct.UnsignedLong linePos = new Struct.UnsignedLong();
        private final Struct.UnsignedLong offset = new Struct.UnsignedLong();
        private final Struct.UnsignedLong length = new Struct.UnsignedLong();
        private final Struct.UnsignedLong utf16LinePos = new Struct.UnsignedLong();
        private final Struct.UnsignedLong utf16Offset = new Struct.UnsignedLong();
        private final Struct.UnsignedLong utf16Length = new Struct.UnsignedLong();
        public WGPUCompilationMessage() {}

        public WGPUCompilationMessage(Runtime runtime) { super(runtime); }

        public static WGPUCompilationMessage create() { return new WGPUCompilationMessage(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUCompilationMessage setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getMessage() { return RustCString.fromPointer(this.message.get()); }
        public WGPUCompilationMessage setMessage(java.lang.String value) { this.message.set(RustCString.toPointer(value)); return this; }
        public WGPUCompilationMessageType getType() { return this.type.get(); }
        public WGPUCompilationMessage setType(WGPUCompilationMessageType value) { this.type.set(value); return this; }
        public long getLineNum() { return this.lineNum.get(); }
        public WGPUCompilationMessage setLineNum(long value) { this.lineNum.set(value); return this; }
        public long getLinePos() { return this.linePos.get(); }
        public WGPUCompilationMessage setLinePos(long value) { this.linePos.set(value); return this; }
        public long getOffset() { return this.offset.get(); }
        public WGPUCompilationMessage setOffset(long value) { this.offset.set(value); return this; }
        public long getLength() { return this.length.get(); }
        public WGPUCompilationMessage setLength(long value) { this.length.set(value); return this; }
        public long getUtf16LinePos() { return this.utf16LinePos.get(); }
        public WGPUCompilationMessage setUtf16LinePos(long value) { this.utf16LinePos.set(value); return this; }
        public long getUtf16Offset() { return this.utf16Offset.get(); }
        public WGPUCompilationMessage setUtf16Offset(long value) { this.utf16Offset.set(value); return this; }
        public long getUtf16Length() { return this.utf16Length.get(); }
        public WGPUCompilationMessage setUtf16Length(long value) { this.utf16Length.set(value); return this; }
    }
    public static class WGPUComputePassTimestampWrites extends WgpuStruct {
        private final Struct.Pointer querySet = new Struct.Pointer();
        private final Struct.Unsigned32 beginningOfPassWriteIndex = new Struct.Unsigned32();
        private final Struct.Unsigned32 endOfPassWriteIndex = new Struct.Unsigned32();
        public WGPUComputePassTimestampWrites() {}

        public WGPUComputePassTimestampWrites(Runtime runtime) { super(runtime); }

        public static WGPUComputePassTimestampWrites create() { return new WGPUComputePassTimestampWrites(); }

        public jnr.ffi.Pointer getQuerySet() { return this.querySet.get(); }
        public WGPUComputePassTimestampWrites setQuerySet(jnr.ffi.Pointer value) { this.querySet.set(value); return this; }
        public long getBeginningOfPassWriteIndex() { return this.beginningOfPassWriteIndex.get(); }
        public WGPUComputePassTimestampWrites setBeginningOfPassWriteIndex(long value) { this.beginningOfPassWriteIndex.set(value); return this; }
        public long getEndOfPassWriteIndex() { return this.endOfPassWriteIndex.get(); }
        public WGPUComputePassTimestampWrites setEndOfPassWriteIndex(long value) { this.endOfPassWriteIndex.set(value); return this; }
    }
    public static class WGPUConstantEntry extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer key = new Struct.Pointer();
        private final Struct.Double value = new Struct.Double();
        public WGPUConstantEntry() {}

        public WGPUConstantEntry(Runtime runtime) { super(runtime); }

        public static WGPUConstantEntry create() { return new WGPUConstantEntry(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUConstantEntry setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getKey() { return RustCString.fromPointer(this.key.get()); }
        public WGPUConstantEntry setKey(java.lang.String value) { this.key.set(RustCString.toPointer(value)); return this; }
        public double getValue() { return this.value.get(); }
        public WGPUConstantEntry setValue(double value) { this.value.set(value); return this; }
    }
    public static class WGPUExtent3D extends WgpuStruct {
        private final Struct.Unsigned32 width = new Struct.Unsigned32();
        private final Struct.Unsigned32 height = new Struct.Unsigned32();
        private final Struct.Unsigned32 depthOrArrayLayers = new Struct.Unsigned32();
        public WGPUExtent3D() {}

        public WGPUExtent3D(Runtime runtime) { super(runtime); }

        public static WGPUExtent3D create() { return new WGPUExtent3D(); }

        public long getWidth() { return this.width.get(); }
        public WGPUExtent3D setWidth(long value) { this.width.set(value); return this; }
        public long getHeight() { return this.height.get(); }
        public WGPUExtent3D setHeight(long value) { this.height.set(value); return this; }
        public long getDepthOrArrayLayers() { return this.depthOrArrayLayers.get(); }
        public WGPUExtent3D setDepthOrArrayLayers(long value) { this.depthOrArrayLayers.set(value); return this; }
    }
    public static class WGPUInstanceDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        public WGPUInstanceDescriptor() {}

        public WGPUInstanceDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUInstanceDescriptor create() { return new WGPUInstanceDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUInstanceDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
    }
    public static class WGPULimits extends WgpuStruct {
        private final Struct.Unsigned32 maxTextureDimension1D = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxTextureDimension2D = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxTextureDimension3D = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxTextureArrayLayers = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxBindGroups = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxBindGroupsPlusVertexBuffers = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxBindingsPerBindGroup = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxDynamicUniformBuffersPerPipelineLayout = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxDynamicStorageBuffersPerPipelineLayout = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxSampledTexturesPerShaderStage = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxSamplersPerShaderStage = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxStorageBuffersPerShaderStage = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxStorageTexturesPerShaderStage = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxUniformBuffersPerShaderStage = new Struct.Unsigned32();
        private final Struct.UnsignedLong maxUniformBufferBindingSize = new Struct.UnsignedLong();
        private final Struct.UnsignedLong maxStorageBufferBindingSize = new Struct.UnsignedLong();
        private final Struct.Unsigned32 minUniformBufferOffsetAlignment = new Struct.Unsigned32();
        private final Struct.Unsigned32 minStorageBufferOffsetAlignment = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxVertexBuffers = new Struct.Unsigned32();
        private final Struct.UnsignedLong maxBufferSize = new Struct.UnsignedLong();
        private final Struct.Unsigned32 maxVertexAttributes = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxVertexBufferArrayStride = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxInterStageShaderComponents = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxInterStageShaderVariables = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxColorAttachments = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxColorAttachmentBytesPerSample = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxComputeWorkgroupStorageSize = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxComputeInvocationsPerWorkgroup = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxComputeWorkgroupSizeX = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxComputeWorkgroupSizeY = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxComputeWorkgroupSizeZ = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxComputeWorkgroupsPerDimension = new Struct.Unsigned32();
        public WGPULimits() {}

        public WGPULimits(Runtime runtime) { super(runtime); }

        public static WGPULimits create() { return new WGPULimits(); }

        public long getMaxTextureDimension1D() { return this.maxTextureDimension1D.get(); }
        public WGPULimits setMaxTextureDimension1D(long value) { this.maxTextureDimension1D.set(value); return this; }
        public long getMaxTextureDimension2D() { return this.maxTextureDimension2D.get(); }
        public WGPULimits setMaxTextureDimension2D(long value) { this.maxTextureDimension2D.set(value); return this; }
        public long getMaxTextureDimension3D() { return this.maxTextureDimension3D.get(); }
        public WGPULimits setMaxTextureDimension3D(long value) { this.maxTextureDimension3D.set(value); return this; }
        public long getMaxTextureArrayLayers() { return this.maxTextureArrayLayers.get(); }
        public WGPULimits setMaxTextureArrayLayers(long value) { this.maxTextureArrayLayers.set(value); return this; }
        public long getMaxBindGroups() { return this.maxBindGroups.get(); }
        public WGPULimits setMaxBindGroups(long value) { this.maxBindGroups.set(value); return this; }
        public long getMaxBindGroupsPlusVertexBuffers() { return this.maxBindGroupsPlusVertexBuffers.get(); }
        public WGPULimits setMaxBindGroupsPlusVertexBuffers(long value) { this.maxBindGroupsPlusVertexBuffers.set(value); return this; }
        public long getMaxBindingsPerBindGroup() { return this.maxBindingsPerBindGroup.get(); }
        public WGPULimits setMaxBindingsPerBindGroup(long value) { this.maxBindingsPerBindGroup.set(value); return this; }
        public long getMaxDynamicUniformBuffersPerPipelineLayout() { return this.maxDynamicUniformBuffersPerPipelineLayout.get(); }
        public WGPULimits setMaxDynamicUniformBuffersPerPipelineLayout(long value) { this.maxDynamicUniformBuffersPerPipelineLayout.set(value); return this; }
        public long getMaxDynamicStorageBuffersPerPipelineLayout() { return this.maxDynamicStorageBuffersPerPipelineLayout.get(); }
        public WGPULimits setMaxDynamicStorageBuffersPerPipelineLayout(long value) { this.maxDynamicStorageBuffersPerPipelineLayout.set(value); return this; }
        public long getMaxSampledTexturesPerShaderStage() { return this.maxSampledTexturesPerShaderStage.get(); }
        public WGPULimits setMaxSampledTexturesPerShaderStage(long value) { this.maxSampledTexturesPerShaderStage.set(value); return this; }
        public long getMaxSamplersPerShaderStage() { return this.maxSamplersPerShaderStage.get(); }
        public WGPULimits setMaxSamplersPerShaderStage(long value) { this.maxSamplersPerShaderStage.set(value); return this; }
        public long getMaxStorageBuffersPerShaderStage() { return this.maxStorageBuffersPerShaderStage.get(); }
        public WGPULimits setMaxStorageBuffersPerShaderStage(long value) { this.maxStorageBuffersPerShaderStage.set(value); return this; }
        public long getMaxStorageTexturesPerShaderStage() { return this.maxStorageTexturesPerShaderStage.get(); }
        public WGPULimits setMaxStorageTexturesPerShaderStage(long value) { this.maxStorageTexturesPerShaderStage.set(value); return this; }
        public long getMaxUniformBuffersPerShaderStage() { return this.maxUniformBuffersPerShaderStage.get(); }
        public WGPULimits setMaxUniformBuffersPerShaderStage(long value) { this.maxUniformBuffersPerShaderStage.set(value); return this; }
        public long getMaxUniformBufferBindingSize() { return this.maxUniformBufferBindingSize.get(); }
        public WGPULimits setMaxUniformBufferBindingSize(long value) { this.maxUniformBufferBindingSize.set(value); return this; }
        public long getMaxStorageBufferBindingSize() { return this.maxStorageBufferBindingSize.get(); }
        public WGPULimits setMaxStorageBufferBindingSize(long value) { this.maxStorageBufferBindingSize.set(value); return this; }
        public long getMinUniformBufferOffsetAlignment() { return this.minUniformBufferOffsetAlignment.get(); }
        public WGPULimits setMinUniformBufferOffsetAlignment(long value) { this.minUniformBufferOffsetAlignment.set(value); return this; }
        public long getMinStorageBufferOffsetAlignment() { return this.minStorageBufferOffsetAlignment.get(); }
        public WGPULimits setMinStorageBufferOffsetAlignment(long value) { this.minStorageBufferOffsetAlignment.set(value); return this; }
        public long getMaxVertexBuffers() { return this.maxVertexBuffers.get(); }
        public WGPULimits setMaxVertexBuffers(long value) { this.maxVertexBuffers.set(value); return this; }
        public long getMaxBufferSize() { return this.maxBufferSize.get(); }
        public WGPULimits setMaxBufferSize(long value) { this.maxBufferSize.set(value); return this; }
        public long getMaxVertexAttributes() { return this.maxVertexAttributes.get(); }
        public WGPULimits setMaxVertexAttributes(long value) { this.maxVertexAttributes.set(value); return this; }
        public long getMaxVertexBufferArrayStride() { return this.maxVertexBufferArrayStride.get(); }
        public WGPULimits setMaxVertexBufferArrayStride(long value) { this.maxVertexBufferArrayStride.set(value); return this; }
        public long getMaxInterStageShaderComponents() { return this.maxInterStageShaderComponents.get(); }
        public WGPULimits setMaxInterStageShaderComponents(long value) { this.maxInterStageShaderComponents.set(value); return this; }
        public long getMaxInterStageShaderVariables() { return this.maxInterStageShaderVariables.get(); }
        public WGPULimits setMaxInterStageShaderVariables(long value) { this.maxInterStageShaderVariables.set(value); return this; }
        public long getMaxColorAttachments() { return this.maxColorAttachments.get(); }
        public WGPULimits setMaxColorAttachments(long value) { this.maxColorAttachments.set(value); return this; }
        public long getMaxColorAttachmentBytesPerSample() { return this.maxColorAttachmentBytesPerSample.get(); }
        public WGPULimits setMaxColorAttachmentBytesPerSample(long value) { this.maxColorAttachmentBytesPerSample.set(value); return this; }
        public long getMaxComputeWorkgroupStorageSize() { return this.maxComputeWorkgroupStorageSize.get(); }
        public WGPULimits setMaxComputeWorkgroupStorageSize(long value) { this.maxComputeWorkgroupStorageSize.set(value); return this; }
        public long getMaxComputeInvocationsPerWorkgroup() { return this.maxComputeInvocationsPerWorkgroup.get(); }
        public WGPULimits setMaxComputeInvocationsPerWorkgroup(long value) { this.maxComputeInvocationsPerWorkgroup.set(value); return this; }
        public long getMaxComputeWorkgroupSizeX() { return this.maxComputeWorkgroupSizeX.get(); }
        public WGPULimits setMaxComputeWorkgroupSizeX(long value) { this.maxComputeWorkgroupSizeX.set(value); return this; }
        public long getMaxComputeWorkgroupSizeY() { return this.maxComputeWorkgroupSizeY.get(); }
        public WGPULimits setMaxComputeWorkgroupSizeY(long value) { this.maxComputeWorkgroupSizeY.set(value); return this; }
        public long getMaxComputeWorkgroupSizeZ() { return this.maxComputeWorkgroupSizeZ.get(); }
        public WGPULimits setMaxComputeWorkgroupSizeZ(long value) { this.maxComputeWorkgroupSizeZ.set(value); return this; }
        public long getMaxComputeWorkgroupsPerDimension() { return this.maxComputeWorkgroupsPerDimension.get(); }
        public WGPULimits setMaxComputeWorkgroupsPerDimension(long value) { this.maxComputeWorkgroupsPerDimension.set(value); return this; }
    }
    public static class WGPUMultisampleState extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Unsigned32 count = new Struct.Unsigned32();
        private final Struct.Unsigned32 mask = new Struct.Unsigned32();
        private final Struct.Unsigned32 alphaToCoverageEnabled = new Struct.Unsigned32();
        public WGPUMultisampleState() {}

        public WGPUMultisampleState(Runtime runtime) { super(runtime); }

        public static WGPUMultisampleState create() { return new WGPUMultisampleState(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUMultisampleState setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public long getCount() { return this.count.get(); }
        public WGPUMultisampleState setCount(long value) { this.count.set(value); return this; }
        public long getMask() { return this.mask.get(); }
        public WGPUMultisampleState setMask(long value) { this.mask.set(value); return this; }
        public long getAlphaToCoverageEnabled() { return this.alphaToCoverageEnabled.get(); }
        public WGPUMultisampleState setAlphaToCoverageEnabled(long value) { this.alphaToCoverageEnabled.set(value); return this; }
    }
    public static class WGPUOrigin3D extends WgpuStruct {
        private final Struct.Unsigned32 x = new Struct.Unsigned32();
        private final Struct.Unsigned32 y = new Struct.Unsigned32();
        private final Struct.Unsigned32 z = new Struct.Unsigned32();
        public WGPUOrigin3D() {}

        public WGPUOrigin3D(Runtime runtime) { super(runtime); }

        public static WGPUOrigin3D create() { return new WGPUOrigin3D(); }

        public long getX() { return this.x.get(); }
        public WGPUOrigin3D setX(long value) { this.x.set(value); return this; }
        public long getY() { return this.y.get(); }
        public WGPUOrigin3D setY(long value) { this.y.set(value); return this; }
        public long getZ() { return this.z.get(); }
        public WGPUOrigin3D setZ(long value) { this.z.set(value); return this; }
    }
    public static class WGPUPipelineLayoutDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.UnsignedLong bindGroupLayoutCount = new Struct.UnsignedLong();
        private final Struct.Pointer bindGroupLayouts = new Struct.Pointer();
        public WGPUPipelineLayoutDescriptor() {}

        public WGPUPipelineLayoutDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUPipelineLayoutDescriptor create() { return new WGPUPipelineLayoutDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUPipelineLayoutDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUPipelineLayoutDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public long getBindGroupLayoutCount() { return this.bindGroupLayoutCount.get(); }
        public WGPUPipelineLayoutDescriptor setBindGroupLayoutCount(long value) { this.bindGroupLayoutCount.set(value); return this; }
        public jnr.ffi.Pointer getBindGroupLayouts() { return this.bindGroupLayouts.get(); }
        public WGPUPipelineLayoutDescriptor setBindGroupLayouts(jnr.ffi.Pointer value) { this.bindGroupLayouts.set(value); return this; }
    }
    public static class WGPUPrimitiveDepthClipControl extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Unsigned32 unclippedDepth = new Struct.Unsigned32();
        public WGPUPrimitiveDepthClipControl() {}

        public WGPUPrimitiveDepthClipControl(Runtime runtime) { super(runtime); }

        public static WGPUPrimitiveDepthClipControl create() { return new WGPUPrimitiveDepthClipControl(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUPrimitiveDepthClipControl setChain(WGPUChainedStruct value) { return this; }
        public long getUnclippedDepth() { return this.unclippedDepth.get(); }
        public WGPUPrimitiveDepthClipControl setUnclippedDepth(long value) { this.unclippedDepth.set(value); return this; }
    }
    public static class WGPUPrimitiveState extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Enum<WGPUPrimitiveTopology> topology = new Struct.Enum<>(WGPUPrimitiveTopology.class);
        private final Struct.Enum<WGPUIndexFormat> stripIndexFormat = new Struct.Enum<>(WGPUIndexFormat.class);
        private final Struct.Enum<WGPUFrontFace> frontFace = new Struct.Enum<>(WGPUFrontFace.class);
        private final Struct.Enum<WGPUCullMode> cullMode = new Struct.Enum<>(WGPUCullMode.class);
        public WGPUPrimitiveState() {}

        public WGPUPrimitiveState(Runtime runtime) { super(runtime); }

        public static WGPUPrimitiveState create() { return new WGPUPrimitiveState(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUPrimitiveState setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPUPrimitiveTopology getTopology() { return this.topology.get(); }
        public WGPUPrimitiveState setTopology(WGPUPrimitiveTopology value) { this.topology.set(value); return this; }
        public WGPUIndexFormat getStripIndexFormat() { return this.stripIndexFormat.get(); }
        public WGPUPrimitiveState setStripIndexFormat(WGPUIndexFormat value) { this.stripIndexFormat.set(value); return this; }
        public WGPUFrontFace getFrontFace() { return this.frontFace.get(); }
        public WGPUPrimitiveState setFrontFace(WGPUFrontFace value) { this.frontFace.set(value); return this; }
        public WGPUCullMode getCullMode() { return this.cullMode.get(); }
        public WGPUPrimitiveState setCullMode(WGPUCullMode value) { this.cullMode.set(value); return this; }
    }
    public static class WGPUQuerySetDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Enum<WGPUQueryType> type = new Struct.Enum<>(WGPUQueryType.class);
        private final Struct.Unsigned32 count = new Struct.Unsigned32();
        public WGPUQuerySetDescriptor() {}

        public WGPUQuerySetDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUQuerySetDescriptor create() { return new WGPUQuerySetDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUQuerySetDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUQuerySetDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public WGPUQueryType getType() { return this.type.get(); }
        public WGPUQuerySetDescriptor setType(WGPUQueryType value) { this.type.set(value); return this; }
        public long getCount() { return this.count.get(); }
        public WGPUQuerySetDescriptor setCount(long value) { this.count.set(value); return this; }
    }
    public static class WGPUQueueDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        public WGPUQueueDescriptor() {}

        public WGPUQueueDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUQueueDescriptor create() { return new WGPUQueueDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUQueueDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUQueueDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPURenderBundleDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        public WGPURenderBundleDescriptor() {}

        public WGPURenderBundleDescriptor(Runtime runtime) { super(runtime); }

        public static WGPURenderBundleDescriptor create() { return new WGPURenderBundleDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPURenderBundleDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPURenderBundleDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPURenderBundleEncoderDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.UnsignedLong colorFormatCount = new Struct.UnsignedLong();
        private final Struct.Pointer colorFormats = new Struct.Pointer();
        private final Struct.Enum<WGPUTextureFormat> depthStencilFormat = new Struct.Enum<>(WGPUTextureFormat.class);
        private final Struct.Unsigned32 sampleCount = new Struct.Unsigned32();
        private final Struct.Unsigned32 depthReadOnly = new Struct.Unsigned32();
        private final Struct.Unsigned32 stencilReadOnly = new Struct.Unsigned32();
        public WGPURenderBundleEncoderDescriptor() {}

        public WGPURenderBundleEncoderDescriptor(Runtime runtime) { super(runtime); }

        public static WGPURenderBundleEncoderDescriptor create() { return new WGPURenderBundleEncoderDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPURenderBundleEncoderDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPURenderBundleEncoderDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public long getColorFormatCount() { return this.colorFormatCount.get(); }
        public WGPURenderBundleEncoderDescriptor setColorFormatCount(long value) { this.colorFormatCount.set(value); return this; }
        public jnr.ffi.Pointer getColorFormats() { return this.colorFormats.get(); }
        public WGPURenderBundleEncoderDescriptor setColorFormats(jnr.ffi.Pointer value) { this.colorFormats.set(value); return this; }
        public WGPUTextureFormat getDepthStencilFormat() { return this.depthStencilFormat.get(); }
        public WGPURenderBundleEncoderDescriptor setDepthStencilFormat(WGPUTextureFormat value) { this.depthStencilFormat.set(value); return this; }
        public long getSampleCount() { return this.sampleCount.get(); }
        public WGPURenderBundleEncoderDescriptor setSampleCount(long value) { this.sampleCount.set(value); return this; }
        public long getDepthReadOnly() { return this.depthReadOnly.get(); }
        public WGPURenderBundleEncoderDescriptor setDepthReadOnly(long value) { this.depthReadOnly.set(value); return this; }
        public long getStencilReadOnly() { return this.stencilReadOnly.get(); }
        public WGPURenderBundleEncoderDescriptor setStencilReadOnly(long value) { this.stencilReadOnly.set(value); return this; }
    }
    public static class WGPURenderPassDepthStencilAttachment extends WgpuStruct {
        private final Struct.Pointer view = new Struct.Pointer();
        private final Struct.Enum<WGPULoadOp> depthLoadOp = new Struct.Enum<>(WGPULoadOp.class);
        private final Struct.Enum<WGPUStoreOp> depthStoreOp = new Struct.Enum<>(WGPUStoreOp.class);
        private final Struct.Float depthClearValue = new Struct.Float();
        private final Struct.Unsigned32 depthReadOnly = new Struct.Unsigned32();
        private final Struct.Enum<WGPULoadOp> stencilLoadOp = new Struct.Enum<>(WGPULoadOp.class);
        private final Struct.Enum<WGPUStoreOp> stencilStoreOp = new Struct.Enum<>(WGPUStoreOp.class);
        private final Struct.Unsigned32 stencilClearValue = new Struct.Unsigned32();
        private final Struct.Unsigned32 stencilReadOnly = new Struct.Unsigned32();
        public WGPURenderPassDepthStencilAttachment() {}

        public WGPURenderPassDepthStencilAttachment(Runtime runtime) { super(runtime); }

        public static WGPURenderPassDepthStencilAttachment create() { return new WGPURenderPassDepthStencilAttachment(); }

        public jnr.ffi.Pointer getView() { return this.view.get(); }
        public WGPURenderPassDepthStencilAttachment setView(jnr.ffi.Pointer value) { this.view.set(value); return this; }
        public WGPULoadOp getDepthLoadOp() { return this.depthLoadOp.get(); }
        public WGPURenderPassDepthStencilAttachment setDepthLoadOp(WGPULoadOp value) { this.depthLoadOp.set(value); return this; }
        public WGPUStoreOp getDepthStoreOp() { return this.depthStoreOp.get(); }
        public WGPURenderPassDepthStencilAttachment setDepthStoreOp(WGPUStoreOp value) { this.depthStoreOp.set(value); return this; }
        public float getDepthClearValue() { return this.depthClearValue.get(); }
        public WGPURenderPassDepthStencilAttachment setDepthClearValue(float value) { this.depthClearValue.set(value); return this; }
        public long getDepthReadOnly() { return this.depthReadOnly.get(); }
        public WGPURenderPassDepthStencilAttachment setDepthReadOnly(long value) { this.depthReadOnly.set(value); return this; }
        public WGPULoadOp getStencilLoadOp() { return this.stencilLoadOp.get(); }
        public WGPURenderPassDepthStencilAttachment setStencilLoadOp(WGPULoadOp value) { this.stencilLoadOp.set(value); return this; }
        public WGPUStoreOp getStencilStoreOp() { return this.stencilStoreOp.get(); }
        public WGPURenderPassDepthStencilAttachment setStencilStoreOp(WGPUStoreOp value) { this.stencilStoreOp.set(value); return this; }
        public long getStencilClearValue() { return this.stencilClearValue.get(); }
        public WGPURenderPassDepthStencilAttachment setStencilClearValue(long value) { this.stencilClearValue.set(value); return this; }
        public long getStencilReadOnly() { return this.stencilReadOnly.get(); }
        public WGPURenderPassDepthStencilAttachment setStencilReadOnly(long value) { this.stencilReadOnly.set(value); return this; }
    }
    public static class WGPURenderPassDescriptorMaxDrawCount extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.UnsignedLong maxDrawCount = new Struct.UnsignedLong();
        public WGPURenderPassDescriptorMaxDrawCount() {}

        public WGPURenderPassDescriptorMaxDrawCount(Runtime runtime) { super(runtime); }

        public static WGPURenderPassDescriptorMaxDrawCount create() { return new WGPURenderPassDescriptorMaxDrawCount(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPURenderPassDescriptorMaxDrawCount setChain(WGPUChainedStruct value) { return this; }
        public long getMaxDrawCount() { return this.maxDrawCount.get(); }
        public WGPURenderPassDescriptorMaxDrawCount setMaxDrawCount(long value) { this.maxDrawCount.set(value); return this; }
    }
    public static class WGPURenderPassTimestampWrites extends WgpuStruct {
        private final Struct.Pointer querySet = new Struct.Pointer();
        private final Struct.Unsigned32 beginningOfPassWriteIndex = new Struct.Unsigned32();
        private final Struct.Unsigned32 endOfPassWriteIndex = new Struct.Unsigned32();
        public WGPURenderPassTimestampWrites() {}

        public WGPURenderPassTimestampWrites(Runtime runtime) { super(runtime); }

        public static WGPURenderPassTimestampWrites create() { return new WGPURenderPassTimestampWrites(); }

        public jnr.ffi.Pointer getQuerySet() { return this.querySet.get(); }
        public WGPURenderPassTimestampWrites setQuerySet(jnr.ffi.Pointer value) { this.querySet.set(value); return this; }
        public long getBeginningOfPassWriteIndex() { return this.beginningOfPassWriteIndex.get(); }
        public WGPURenderPassTimestampWrites setBeginningOfPassWriteIndex(long value) { this.beginningOfPassWriteIndex.set(value); return this; }
        public long getEndOfPassWriteIndex() { return this.endOfPassWriteIndex.get(); }
        public WGPURenderPassTimestampWrites setEndOfPassWriteIndex(long value) { this.endOfPassWriteIndex.set(value); return this; }
    }
    public static class WGPURequestAdapterOptions extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Pointer compatibleSurface = new Struct.Pointer();
        private final Struct.Enum<WGPUPowerPreference> powerPreference = new Struct.Enum<>(WGPUPowerPreference.class);
        private final Struct.Enum<WGPUBackendType> backendType = new Struct.Enum<>(WGPUBackendType.class);
        private final Struct.Unsigned32 forceFallbackAdapter = new Struct.Unsigned32();
        public WGPURequestAdapterOptions() {}

        public WGPURequestAdapterOptions(Runtime runtime) { super(runtime); }

        public static WGPURequestAdapterOptions create() { return new WGPURequestAdapterOptions(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPURequestAdapterOptions setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public jnr.ffi.Pointer getCompatibleSurface() { return this.compatibleSurface.get(); }
        public WGPURequestAdapterOptions setCompatibleSurface(jnr.ffi.Pointer value) { this.compatibleSurface.set(value); return this; }
        public WGPUPowerPreference getPowerPreference() { return this.powerPreference.get(); }
        public WGPURequestAdapterOptions setPowerPreference(WGPUPowerPreference value) { this.powerPreference.set(value); return this; }
        public WGPUBackendType getBackendType() { return this.backendType.get(); }
        public WGPURequestAdapterOptions setBackendType(WGPUBackendType value) { this.backendType.set(value); return this; }
        public long getForceFallbackAdapter() { return this.forceFallbackAdapter.get(); }
        public WGPURequestAdapterOptions setForceFallbackAdapter(long value) { this.forceFallbackAdapter.set(value); return this; }
    }
    public static class WGPUSamplerBindingLayout extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Enum<WGPUSamplerBindingType> type = new Struct.Enum<>(WGPUSamplerBindingType.class);
        public WGPUSamplerBindingLayout() {}

        public WGPUSamplerBindingLayout(Runtime runtime) { super(runtime); }

        public static WGPUSamplerBindingLayout create() { return new WGPUSamplerBindingLayout(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUSamplerBindingLayout setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPUSamplerBindingType getType() { return this.type.get(); }
        public WGPUSamplerBindingLayout setType(WGPUSamplerBindingType value) { this.type.set(value); return this; }
    }
    public static class WGPUSamplerDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Enum<WGPUAddressMode> addressModeU = new Struct.Enum<>(WGPUAddressMode.class);
        private final Struct.Enum<WGPUAddressMode> addressModeV = new Struct.Enum<>(WGPUAddressMode.class);
        private final Struct.Enum<WGPUAddressMode> addressModeW = new Struct.Enum<>(WGPUAddressMode.class);
        private final Struct.Enum<WGPUFilterMode> magFilter = new Struct.Enum<>(WGPUFilterMode.class);
        private final Struct.Enum<WGPUFilterMode> minFilter = new Struct.Enum<>(WGPUFilterMode.class);
        private final Struct.Enum<WGPUMipmapFilterMode> mipmapFilter = new Struct.Enum<>(WGPUMipmapFilterMode.class);
        private final Struct.Float lodMinClamp = new Struct.Float();
        private final Struct.Float lodMaxClamp = new Struct.Float();
        private final Struct.Enum<WGPUCompareFunction> compare = new Struct.Enum<>(WGPUCompareFunction.class);
        private final Struct.Unsigned16 maxAnisotropy = new Struct.Unsigned16();
        public WGPUSamplerDescriptor() {}

        public WGPUSamplerDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUSamplerDescriptor create() { return new WGPUSamplerDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUSamplerDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUSamplerDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public WGPUAddressMode getAddressModeU() { return this.addressModeU.get(); }
        public WGPUSamplerDescriptor setAddressModeU(WGPUAddressMode value) { this.addressModeU.set(value); return this; }
        public WGPUAddressMode getAddressModeV() { return this.addressModeV.get(); }
        public WGPUSamplerDescriptor setAddressModeV(WGPUAddressMode value) { this.addressModeV.set(value); return this; }
        public WGPUAddressMode getAddressModeW() { return this.addressModeW.get(); }
        public WGPUSamplerDescriptor setAddressModeW(WGPUAddressMode value) { this.addressModeW.set(value); return this; }
        public WGPUFilterMode getMagFilter() { return this.magFilter.get(); }
        public WGPUSamplerDescriptor setMagFilter(WGPUFilterMode value) { this.magFilter.set(value); return this; }
        public WGPUFilterMode getMinFilter() { return this.minFilter.get(); }
        public WGPUSamplerDescriptor setMinFilter(WGPUFilterMode value) { this.minFilter.set(value); return this; }
        public WGPUMipmapFilterMode getMipmapFilter() { return this.mipmapFilter.get(); }
        public WGPUSamplerDescriptor setMipmapFilter(WGPUMipmapFilterMode value) { this.mipmapFilter.set(value); return this; }
        public float getLodMinClamp() { return this.lodMinClamp.get(); }
        public WGPUSamplerDescriptor setLodMinClamp(float value) { this.lodMinClamp.set(value); return this; }
        public float getLodMaxClamp() { return this.lodMaxClamp.get(); }
        public WGPUSamplerDescriptor setLodMaxClamp(float value) { this.lodMaxClamp.set(value); return this; }
        public WGPUCompareFunction getCompare() { return this.compare.get(); }
        public WGPUSamplerDescriptor setCompare(WGPUCompareFunction value) { this.compare.set(value); return this; }
        public int getMaxAnisotropy() { return this.maxAnisotropy.get(); }
        public WGPUSamplerDescriptor setMaxAnisotropy(int value) { this.maxAnisotropy.set(value); return this; }
    }
    public static class WGPUShaderModuleCompilationHint extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer entryPoint = new Struct.Pointer();
        private final Struct.Pointer layout = new Struct.Pointer();
        public WGPUShaderModuleCompilationHint() {}

        public WGPUShaderModuleCompilationHint(Runtime runtime) { super(runtime); }

        public static WGPUShaderModuleCompilationHint create() { return new WGPUShaderModuleCompilationHint(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUShaderModuleCompilationHint setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getEntryPoint() { return RustCString.fromPointer(this.entryPoint.get()); }
        public WGPUShaderModuleCompilationHint setEntryPoint(java.lang.String value) { this.entryPoint.set(RustCString.toPointer(value)); return this; }
        public jnr.ffi.Pointer getLayout() { return this.layout.get(); }
        public WGPUShaderModuleCompilationHint setLayout(jnr.ffi.Pointer value) { this.layout.set(value); return this; }
    }
    public static class WGPUShaderModuleSPIRVDescriptor extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Unsigned32 codeSize = new Struct.Unsigned32();
        private final Struct.Pointer code = new Struct.Pointer();
        public WGPUShaderModuleSPIRVDescriptor() {}

        public WGPUShaderModuleSPIRVDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUShaderModuleSPIRVDescriptor create() { return new WGPUShaderModuleSPIRVDescriptor(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUShaderModuleSPIRVDescriptor setChain(WGPUChainedStruct value) { return this; }
        public long getCodeSize() { return this.codeSize.get(); }
        public WGPUShaderModuleSPIRVDescriptor setCodeSize(long value) { this.codeSize.set(value); return this; }
        public jnr.ffi.Pointer getCode() { return this.code.get(); }
        public WGPUShaderModuleSPIRVDescriptor setCode(jnr.ffi.Pointer value) { this.code.set(value); return this; }
    }
    public static class WGPUShaderModuleWGSLDescriptor extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final @CStrPointer Struct.Pointer code = new Struct.Pointer();
        public WGPUShaderModuleWGSLDescriptor() {}

        public WGPUShaderModuleWGSLDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUShaderModuleWGSLDescriptor create() { return new WGPUShaderModuleWGSLDescriptor(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUShaderModuleWGSLDescriptor setChain(WGPUChainedStruct value) { return this; }
        public java.lang.String getCode() { return RustCString.fromPointer(this.code.get()); }
        public WGPUShaderModuleWGSLDescriptor setCode(java.lang.String value) { this.code.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPUStencilFaceState extends WgpuStruct {
        private final Struct.Enum<WGPUCompareFunction> compare = new Struct.Enum<>(WGPUCompareFunction.class);
        private final Struct.Enum<WGPUStencilOperation> failOp = new Struct.Enum<>(WGPUStencilOperation.class);
        private final Struct.Enum<WGPUStencilOperation> depthFailOp = new Struct.Enum<>(WGPUStencilOperation.class);
        private final Struct.Enum<WGPUStencilOperation> passOp = new Struct.Enum<>(WGPUStencilOperation.class);
        public WGPUStencilFaceState() {}

        public WGPUStencilFaceState(Runtime runtime) { super(runtime); }

        public static WGPUStencilFaceState create() { return new WGPUStencilFaceState(); }

        public WGPUCompareFunction getCompare() { return this.compare.get(); }
        public WGPUStencilFaceState setCompare(WGPUCompareFunction value) { this.compare.set(value); return this; }
        public WGPUStencilOperation getFailOp() { return this.failOp.get(); }
        public WGPUStencilFaceState setFailOp(WGPUStencilOperation value) { this.failOp.set(value); return this; }
        public WGPUStencilOperation getDepthFailOp() { return this.depthFailOp.get(); }
        public WGPUStencilFaceState setDepthFailOp(WGPUStencilOperation value) { this.depthFailOp.set(value); return this; }
        public WGPUStencilOperation getPassOp() { return this.passOp.get(); }
        public WGPUStencilFaceState setPassOp(WGPUStencilOperation value) { this.passOp.set(value); return this; }
    }
    public static class WGPUStorageTextureBindingLayout extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Enum<WGPUStorageTextureAccess> access = new Struct.Enum<>(WGPUStorageTextureAccess.class);
        private final Struct.Enum<WGPUTextureFormat> format = new Struct.Enum<>(WGPUTextureFormat.class);
        private final Struct.Enum<WGPUTextureViewDimension> viewDimension = new Struct.Enum<>(WGPUTextureViewDimension.class);
        public WGPUStorageTextureBindingLayout() {}

        public WGPUStorageTextureBindingLayout(Runtime runtime) { super(runtime); }

        public static WGPUStorageTextureBindingLayout create() { return new WGPUStorageTextureBindingLayout(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUStorageTextureBindingLayout setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPUStorageTextureAccess getAccess() { return this.access.get(); }
        public WGPUStorageTextureBindingLayout setAccess(WGPUStorageTextureAccess value) { this.access.set(value); return this; }
        public WGPUTextureFormat getFormat() { return this.format.get(); }
        public WGPUStorageTextureBindingLayout setFormat(WGPUTextureFormat value) { this.format.set(value); return this; }
        public WGPUTextureViewDimension getViewDimension() { return this.viewDimension.get(); }
        public WGPUStorageTextureBindingLayout setViewDimension(WGPUTextureViewDimension value) { this.viewDimension.set(value); return this; }
    }
    public static class WGPUSurfaceCapabilities extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.UnsignedLong formatCount = new Struct.UnsignedLong();
        private final Struct.Pointer formats = new Struct.Pointer();
        private final Struct.UnsignedLong presentModeCount = new Struct.UnsignedLong();
        private final Struct.Pointer presentModes = new Struct.Pointer();
        private final Struct.UnsignedLong alphaModeCount = new Struct.UnsignedLong();
        private final Struct.Pointer alphaModes = new Struct.Pointer();
        public WGPUSurfaceCapabilities() {}

        public WGPUSurfaceCapabilities(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceCapabilities create() { return new WGPUSurfaceCapabilities(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUSurfaceCapabilities setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public long getFormatCount() { return this.formatCount.get(); }
        public WGPUSurfaceCapabilities setFormatCount(long value) { this.formatCount.set(value); return this; }
        public jnr.ffi.Pointer getFormats() { return this.formats.get(); }
        public WGPUSurfaceCapabilities setFormats(jnr.ffi.Pointer value) { this.formats.set(value); return this; }
        public long getPresentModeCount() { return this.presentModeCount.get(); }
        public WGPUSurfaceCapabilities setPresentModeCount(long value) { this.presentModeCount.set(value); return this; }
        public jnr.ffi.Pointer getPresentModes() { return this.presentModes.get(); }
        public WGPUSurfaceCapabilities setPresentModes(jnr.ffi.Pointer value) { this.presentModes.set(value); return this; }
        public long getAlphaModeCount() { return this.alphaModeCount.get(); }
        public WGPUSurfaceCapabilities setAlphaModeCount(long value) { this.alphaModeCount.set(value); return this; }
        public jnr.ffi.Pointer getAlphaModes() { return this.alphaModes.get(); }
        public WGPUSurfaceCapabilities setAlphaModes(jnr.ffi.Pointer value) { this.alphaModes.set(value); return this; }
    }
    public static class WGPUSurfaceConfiguration extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Pointer device = new Struct.Pointer();
        private final Struct.Enum<WGPUTextureFormat> format = new Struct.Enum<>(WGPUTextureFormat.class);
        private final Struct.Unsigned32 usage = new Struct.Unsigned32();
        private final Struct.UnsignedLong viewFormatCount = new Struct.UnsignedLong();
        private final Struct.Pointer viewFormats = new Struct.Pointer();
        private final Struct.Enum<WGPUCompositeAlphaMode> alphaMode = new Struct.Enum<>(WGPUCompositeAlphaMode.class);
        private final Struct.Unsigned32 width = new Struct.Unsigned32();
        private final Struct.Unsigned32 height = new Struct.Unsigned32();
        private final Struct.Enum<WGPUPresentMode> presentMode = new Struct.Enum<>(WGPUPresentMode.class);
        public WGPUSurfaceConfiguration() {}

        public WGPUSurfaceConfiguration(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceConfiguration create() { return new WGPUSurfaceConfiguration(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUSurfaceConfiguration setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public jnr.ffi.Pointer getDevice() { return this.device.get(); }
        public WGPUSurfaceConfiguration setDevice(jnr.ffi.Pointer value) { this.device.set(value); return this; }
        public WGPUTextureFormat getFormat() { return this.format.get(); }
        public WGPUSurfaceConfiguration setFormat(WGPUTextureFormat value) { this.format.set(value); return this; }
        public long getUsage() { return this.usage.get(); }
        public WGPUSurfaceConfiguration setUsage(long value) { this.usage.set(value); return this; }
        public long getViewFormatCount() { return this.viewFormatCount.get(); }
        public WGPUSurfaceConfiguration setViewFormatCount(long value) { this.viewFormatCount.set(value); return this; }
        public jnr.ffi.Pointer getViewFormats() { return this.viewFormats.get(); }
        public WGPUSurfaceConfiguration setViewFormats(jnr.ffi.Pointer value) { this.viewFormats.set(value); return this; }
        public WGPUCompositeAlphaMode getAlphaMode() { return this.alphaMode.get(); }
        public WGPUSurfaceConfiguration setAlphaMode(WGPUCompositeAlphaMode value) { this.alphaMode.set(value); return this; }
        public long getWidth() { return this.width.get(); }
        public WGPUSurfaceConfiguration setWidth(long value) { this.width.set(value); return this; }
        public long getHeight() { return this.height.get(); }
        public WGPUSurfaceConfiguration setHeight(long value) { this.height.set(value); return this; }
        public WGPUPresentMode getPresentMode() { return this.presentMode.get(); }
        public WGPUSurfaceConfiguration setPresentMode(WGPUPresentMode value) { this.presentMode.set(value); return this; }
    }
    public static class WGPUSurfaceDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        public WGPUSurfaceDescriptor() {}

        public WGPUSurfaceDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceDescriptor create() { return new WGPUSurfaceDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUSurfaceDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUSurfaceDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPUSurfaceDescriptorFromAndroidNativeWindow extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Pointer window = new Struct.Pointer();
        public WGPUSurfaceDescriptorFromAndroidNativeWindow() {}

        public WGPUSurfaceDescriptorFromAndroidNativeWindow(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceDescriptorFromAndroidNativeWindow create() { return new WGPUSurfaceDescriptorFromAndroidNativeWindow(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUSurfaceDescriptorFromAndroidNativeWindow setChain(WGPUChainedStruct value) { return this; }
        public jnr.ffi.Pointer getWindow() { return this.window.get(); }
        public WGPUSurfaceDescriptorFromAndroidNativeWindow setWindow(jnr.ffi.Pointer value) { this.window.set(value); return this; }
    }
    public static class WGPUSurfaceDescriptorFromCanvasHTMLSelector extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final @CStrPointer Struct.Pointer selector = new Struct.Pointer();
        public WGPUSurfaceDescriptorFromCanvasHTMLSelector() {}

        public WGPUSurfaceDescriptorFromCanvasHTMLSelector(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceDescriptorFromCanvasHTMLSelector create() { return new WGPUSurfaceDescriptorFromCanvasHTMLSelector(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUSurfaceDescriptorFromCanvasHTMLSelector setChain(WGPUChainedStruct value) { return this; }
        public java.lang.String getSelector() { return RustCString.fromPointer(this.selector.get()); }
        public WGPUSurfaceDescriptorFromCanvasHTMLSelector setSelector(java.lang.String value) { this.selector.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPUSurfaceDescriptorFromMetalLayer extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Pointer layer = new Struct.Pointer();
        public WGPUSurfaceDescriptorFromMetalLayer() {}

        public WGPUSurfaceDescriptorFromMetalLayer(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceDescriptorFromMetalLayer create() { return new WGPUSurfaceDescriptorFromMetalLayer(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUSurfaceDescriptorFromMetalLayer setChain(WGPUChainedStruct value) { return this; }
        public jnr.ffi.Pointer getLayer() { return this.layer.get(); }
        public WGPUSurfaceDescriptorFromMetalLayer setLayer(jnr.ffi.Pointer value) { this.layer.set(value); return this; }
    }
    public static class WGPUSurfaceDescriptorFromWaylandSurface extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Pointer display = new Struct.Pointer();
        private final Struct.Pointer surface = new Struct.Pointer();
        public WGPUSurfaceDescriptorFromWaylandSurface() {}

        public WGPUSurfaceDescriptorFromWaylandSurface(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceDescriptorFromWaylandSurface create() { return new WGPUSurfaceDescriptorFromWaylandSurface(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUSurfaceDescriptorFromWaylandSurface setChain(WGPUChainedStruct value) { return this; }
        public jnr.ffi.Pointer getDisplay() { return this.display.get(); }
        public WGPUSurfaceDescriptorFromWaylandSurface setDisplay(jnr.ffi.Pointer value) { this.display.set(value); return this; }
        public jnr.ffi.Pointer getSurface() { return this.surface.get(); }
        public WGPUSurfaceDescriptorFromWaylandSurface setSurface(jnr.ffi.Pointer value) { this.surface.set(value); return this; }
    }
    public static class WGPUSurfaceDescriptorFromWindowsHWND extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Pointer hinstance = new Struct.Pointer();
        private final Struct.Pointer hwnd = new Struct.Pointer();
        public WGPUSurfaceDescriptorFromWindowsHWND() {}

        public WGPUSurfaceDescriptorFromWindowsHWND(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceDescriptorFromWindowsHWND create() { return new WGPUSurfaceDescriptorFromWindowsHWND(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUSurfaceDescriptorFromWindowsHWND setChain(WGPUChainedStruct value) { return this; }
        public jnr.ffi.Pointer getHinstance() { return this.hinstance.get(); }
        public WGPUSurfaceDescriptorFromWindowsHWND setHinstance(jnr.ffi.Pointer value) { this.hinstance.set(value); return this; }
        public jnr.ffi.Pointer getHwnd() { return this.hwnd.get(); }
        public WGPUSurfaceDescriptorFromWindowsHWND setHwnd(jnr.ffi.Pointer value) { this.hwnd.set(value); return this; }
    }
    public static class WGPUSurfaceDescriptorFromXcbWindow extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Pointer connection = new Struct.Pointer();
        private final Struct.Unsigned32 window = new Struct.Unsigned32();
        public WGPUSurfaceDescriptorFromXcbWindow() {}

        public WGPUSurfaceDescriptorFromXcbWindow(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceDescriptorFromXcbWindow create() { return new WGPUSurfaceDescriptorFromXcbWindow(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUSurfaceDescriptorFromXcbWindow setChain(WGPUChainedStruct value) { return this; }
        public jnr.ffi.Pointer getConnection() { return this.connection.get(); }
        public WGPUSurfaceDescriptorFromXcbWindow setConnection(jnr.ffi.Pointer value) { this.connection.set(value); return this; }
        public long getWindow() { return this.window.get(); }
        public WGPUSurfaceDescriptorFromXcbWindow setWindow(long value) { this.window.set(value); return this; }
    }
    public static class WGPUSurfaceDescriptorFromXlibWindow extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Pointer display = new Struct.Pointer();
        private final Struct.UnsignedLong window = new Struct.UnsignedLong();
        public WGPUSurfaceDescriptorFromXlibWindow() {}

        public WGPUSurfaceDescriptorFromXlibWindow(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceDescriptorFromXlibWindow create() { return new WGPUSurfaceDescriptorFromXlibWindow(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUSurfaceDescriptorFromXlibWindow setChain(WGPUChainedStruct value) { return this; }
        public jnr.ffi.Pointer getDisplay() { return this.display.get(); }
        public WGPUSurfaceDescriptorFromXlibWindow setDisplay(jnr.ffi.Pointer value) { this.display.set(value); return this; }
        public long getWindow() { return this.window.get(); }
        public WGPUSurfaceDescriptorFromXlibWindow setWindow(long value) { this.window.set(value); return this; }
    }
    public static class WGPUSurfaceTexture extends WgpuStruct {
        private final Struct.Pointer texture = new Struct.Pointer();
        private final Struct.Unsigned32 suboptimal = new Struct.Unsigned32();
        private final Struct.Enum<WGPUSurfaceGetCurrentTextureStatus> status = new Struct.Enum<>(WGPUSurfaceGetCurrentTextureStatus.class);
        public WGPUSurfaceTexture() {}

        public WGPUSurfaceTexture(Runtime runtime) { super(runtime); }

        public static WGPUSurfaceTexture create() { return new WGPUSurfaceTexture(); }

        public jnr.ffi.Pointer getTexture() { return this.texture.get(); }
        public WGPUSurfaceTexture setTexture(jnr.ffi.Pointer value) { this.texture.set(value); return this; }
        public long getSuboptimal() { return this.suboptimal.get(); }
        public WGPUSurfaceTexture setSuboptimal(long value) { this.suboptimal.set(value); return this; }
        public WGPUSurfaceGetCurrentTextureStatus getStatus() { return this.status.get(); }
        public WGPUSurfaceTexture setStatus(WGPUSurfaceGetCurrentTextureStatus value) { this.status.set(value); return this; }
    }
    public static class WGPUTextureBindingLayout extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Enum<WGPUTextureSampleType> sampleType = new Struct.Enum<>(WGPUTextureSampleType.class);
        private final Struct.Enum<WGPUTextureViewDimension> viewDimension = new Struct.Enum<>(WGPUTextureViewDimension.class);
        private final Struct.Unsigned32 multisampled = new Struct.Unsigned32();
        public WGPUTextureBindingLayout() {}

        public WGPUTextureBindingLayout(Runtime runtime) { super(runtime); }

        public static WGPUTextureBindingLayout create() { return new WGPUTextureBindingLayout(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUTextureBindingLayout setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPUTextureSampleType getSampleType() { return this.sampleType.get(); }
        public WGPUTextureBindingLayout setSampleType(WGPUTextureSampleType value) { this.sampleType.set(value); return this; }
        public WGPUTextureViewDimension getViewDimension() { return this.viewDimension.get(); }
        public WGPUTextureBindingLayout setViewDimension(WGPUTextureViewDimension value) { this.viewDimension.set(value); return this; }
        public long getMultisampled() { return this.multisampled.get(); }
        public WGPUTextureBindingLayout setMultisampled(long value) { this.multisampled.set(value); return this; }
    }
    public static class WGPUTextureDataLayout extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.UnsignedLong offset = new Struct.UnsignedLong();
        private final Struct.Unsigned32 bytesPerRow = new Struct.Unsigned32();
        private final Struct.Unsigned32 rowsPerImage = new Struct.Unsigned32();
        public WGPUTextureDataLayout() {}

        public WGPUTextureDataLayout(Runtime runtime) { super(runtime); }

        public static WGPUTextureDataLayout create() { return new WGPUTextureDataLayout(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUTextureDataLayout setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public long getOffset() { return this.offset.get(); }
        public WGPUTextureDataLayout setOffset(long value) { this.offset.set(value); return this; }
        public long getBytesPerRow() { return this.bytesPerRow.get(); }
        public WGPUTextureDataLayout setBytesPerRow(long value) { this.bytesPerRow.set(value); return this; }
        public long getRowsPerImage() { return this.rowsPerImage.get(); }
        public WGPUTextureDataLayout setRowsPerImage(long value) { this.rowsPerImage.set(value); return this; }
    }
    public static class WGPUTextureViewDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Enum<WGPUTextureFormat> format = new Struct.Enum<>(WGPUTextureFormat.class);
        private final Struct.Enum<WGPUTextureViewDimension> dimension = new Struct.Enum<>(WGPUTextureViewDimension.class);
        private final Struct.Unsigned32 baseMipLevel = new Struct.Unsigned32();
        private final Struct.Unsigned32 mipLevelCount = new Struct.Unsigned32();
        private final Struct.Unsigned32 baseArrayLayer = new Struct.Unsigned32();
        private final Struct.Unsigned32 arrayLayerCount = new Struct.Unsigned32();
        private final Struct.Enum<WGPUTextureAspect> aspect = new Struct.Enum<>(WGPUTextureAspect.class);
        public WGPUTextureViewDescriptor() {}

        public WGPUTextureViewDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUTextureViewDescriptor create() { return new WGPUTextureViewDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUTextureViewDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUTextureViewDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public WGPUTextureFormat getFormat() { return this.format.get(); }
        public WGPUTextureViewDescriptor setFormat(WGPUTextureFormat value) { this.format.set(value); return this; }
        public WGPUTextureViewDimension getDimension() { return this.dimension.get(); }
        public WGPUTextureViewDescriptor setDimension(WGPUTextureViewDimension value) { this.dimension.set(value); return this; }
        public long getBaseMipLevel() { return this.baseMipLevel.get(); }
        public WGPUTextureViewDescriptor setBaseMipLevel(long value) { this.baseMipLevel.set(value); return this; }
        public long getMipLevelCount() { return this.mipLevelCount.get(); }
        public WGPUTextureViewDescriptor setMipLevelCount(long value) { this.mipLevelCount.set(value); return this; }
        public long getBaseArrayLayer() { return this.baseArrayLayer.get(); }
        public WGPUTextureViewDescriptor setBaseArrayLayer(long value) { this.baseArrayLayer.set(value); return this; }
        public long getArrayLayerCount() { return this.arrayLayerCount.get(); }
        public WGPUTextureViewDescriptor setArrayLayerCount(long value) { this.arrayLayerCount.set(value); return this; }
        public WGPUTextureAspect getAspect() { return this.aspect.get(); }
        public WGPUTextureViewDescriptor setAspect(WGPUTextureAspect value) { this.aspect.set(value); return this; }
    }
    public static class WGPUVertexAttribute extends WgpuStruct {
        private final Struct.Enum<WGPUVertexFormat> format = new Struct.Enum<>(WGPUVertexFormat.class);
        private final Struct.UnsignedLong offset = new Struct.UnsignedLong();
        private final Struct.Unsigned32 shaderLocation = new Struct.Unsigned32();
        public WGPUVertexAttribute() {}

        public WGPUVertexAttribute(Runtime runtime) { super(runtime); }

        public static WGPUVertexAttribute create() { return new WGPUVertexAttribute(); }

        public WGPUVertexFormat getFormat() { return this.format.get(); }
        public WGPUVertexAttribute setFormat(WGPUVertexFormat value) { this.format.set(value); return this; }
        public long getOffset() { return this.offset.get(); }
        public WGPUVertexAttribute setOffset(long value) { this.offset.set(value); return this; }
        public long getShaderLocation() { return this.shaderLocation.get(); }
        public WGPUVertexAttribute setShaderLocation(long value) { this.shaderLocation.set(value); return this; }
    }
    public static class WGPUBindGroupDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Pointer layout = new Struct.Pointer();
        private final Struct.UnsignedLong entryCount = new Struct.UnsignedLong();
        private final Struct.Pointer entries = new Struct.Pointer();
        public WGPUBindGroupDescriptor() {}

        public WGPUBindGroupDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUBindGroupDescriptor create() { return new WGPUBindGroupDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUBindGroupDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUBindGroupDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public jnr.ffi.Pointer getLayout() { return this.layout.get(); }
        public WGPUBindGroupDescriptor setLayout(jnr.ffi.Pointer value) { this.layout.set(value); return this; }
        public long getEntryCount() { return this.entryCount.get(); }
        public WGPUBindGroupDescriptor setEntryCount(long value) { this.entryCount.set(value); return this; }
        public jnr.ffi.Pointer getEntries() { return this.entries.get(); }
        public WGPUBindGroupDescriptor setEntries(jnr.ffi.Pointer value) { this.entries.set(value); return this; }
    }
    public static class WGPUBindGroupLayoutEntry extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Unsigned32 binding = new Struct.Unsigned32();
        private final Struct.Unsigned32 visibility = new Struct.Unsigned32();
        private final WGPUBufferBindingLayout buffer = inner(new WGPUBufferBindingLayout());
        private final WGPUSamplerBindingLayout sampler = inner(new WGPUSamplerBindingLayout());
        private final WGPUTextureBindingLayout texture = inner(new WGPUTextureBindingLayout());
        private final WGPUStorageTextureBindingLayout storageTexture = inner(new WGPUStorageTextureBindingLayout());
        public WGPUBindGroupLayoutEntry() {}

        public WGPUBindGroupLayoutEntry(Runtime runtime) { super(runtime); }

        public static WGPUBindGroupLayoutEntry create() { return new WGPUBindGroupLayoutEntry(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUBindGroupLayoutEntry setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public long getBinding() { return this.binding.get(); }
        public WGPUBindGroupLayoutEntry setBinding(long value) { this.binding.set(value); return this; }
        public long getVisibility() { return this.visibility.get(); }
        public WGPUBindGroupLayoutEntry setVisibility(long value) { this.visibility.set(value); return this; }
        public WGPUBufferBindingLayout getBuffer() { return this.buffer; }
        public WGPUBindGroupLayoutEntry setBuffer(WGPUBufferBindingLayout value) { return this; }
        public WGPUSamplerBindingLayout getSampler() { return this.sampler; }
        public WGPUBindGroupLayoutEntry setSampler(WGPUSamplerBindingLayout value) { return this; }
        public WGPUTextureBindingLayout getTexture() { return this.texture; }
        public WGPUBindGroupLayoutEntry setTexture(WGPUTextureBindingLayout value) { return this; }
        public WGPUStorageTextureBindingLayout getStorageTexture() { return this.storageTexture; }
        public WGPUBindGroupLayoutEntry setStorageTexture(WGPUStorageTextureBindingLayout value) { return this; }
    }
    public static class WGPUBlendState extends WgpuStruct {
        private final WGPUBlendComponent color = inner(new WGPUBlendComponent());
        private final WGPUBlendComponent alpha = inner(new WGPUBlendComponent());
        public WGPUBlendState() {}

        public WGPUBlendState(Runtime runtime) { super(runtime); }

        public static WGPUBlendState create() { return new WGPUBlendState(); }

        public WGPUBlendComponent getColor() { return this.color; }
        public WGPUBlendState setColor(WGPUBlendComponent value) { return this; }
        public WGPUBlendComponent getAlpha() { return this.alpha; }
        public WGPUBlendState setAlpha(WGPUBlendComponent value) { return this; }
    }
    public static class WGPUCompilationInfo extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.UnsignedLong messageCount = new Struct.UnsignedLong();
        private final Struct.Pointer messages = new Struct.Pointer();
        public WGPUCompilationInfo() {}

        public WGPUCompilationInfo(Runtime runtime) { super(runtime); }

        public static WGPUCompilationInfo create() { return new WGPUCompilationInfo(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUCompilationInfo setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public long getMessageCount() { return this.messageCount.get(); }
        public WGPUCompilationInfo setMessageCount(long value) { this.messageCount.set(value); return this; }
        public jnr.ffi.Pointer getMessages() { return this.messages.get(); }
        public WGPUCompilationInfo setMessages(jnr.ffi.Pointer value) { this.messages.set(value); return this; }
    }
    public static class WGPUComputePassDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Pointer timestampWrites = new Struct.Pointer();
        public WGPUComputePassDescriptor() {}

        public WGPUComputePassDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUComputePassDescriptor create() { return new WGPUComputePassDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUComputePassDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUComputePassDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public jnr.ffi.Pointer getTimestampWrites() { return this.timestampWrites.get(); }
        public WGPUComputePassDescriptor setTimestampWrites(jnr.ffi.Pointer value) { this.timestampWrites.set(value); return this; }
    }
    public static class WGPUDepthStencilState extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Enum<WGPUTextureFormat> format = new Struct.Enum<>(WGPUTextureFormat.class);
        private final Struct.Unsigned32 depthWriteEnabled = new Struct.Unsigned32();
        private final Struct.Enum<WGPUCompareFunction> depthCompare = new Struct.Enum<>(WGPUCompareFunction.class);
        private final WGPUStencilFaceState stencilFront = inner(new WGPUStencilFaceState());
        private final WGPUStencilFaceState stencilBack = inner(new WGPUStencilFaceState());
        private final Struct.Unsigned32 stencilReadMask = new Struct.Unsigned32();
        private final Struct.Unsigned32 stencilWriteMask = new Struct.Unsigned32();
        private final Struct.Signed32 depthBias = new Struct.Signed32();
        private final Struct.Float depthBiasSlopeScale = new Struct.Float();
        private final Struct.Float depthBiasClamp = new Struct.Float();
        public WGPUDepthStencilState() {}

        public WGPUDepthStencilState(Runtime runtime) { super(runtime); }

        public static WGPUDepthStencilState create() { return new WGPUDepthStencilState(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUDepthStencilState setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPUTextureFormat getFormat() { return this.format.get(); }
        public WGPUDepthStencilState setFormat(WGPUTextureFormat value) { this.format.set(value); return this; }
        public long getDepthWriteEnabled() { return this.depthWriteEnabled.get(); }
        public WGPUDepthStencilState setDepthWriteEnabled(long value) { this.depthWriteEnabled.set(value); return this; }
        public WGPUCompareFunction getDepthCompare() { return this.depthCompare.get(); }
        public WGPUDepthStencilState setDepthCompare(WGPUCompareFunction value) { this.depthCompare.set(value); return this; }
        public WGPUStencilFaceState getStencilFront() { return this.stencilFront; }
        public WGPUDepthStencilState setStencilFront(WGPUStencilFaceState value) { return this; }
        public WGPUStencilFaceState getStencilBack() { return this.stencilBack; }
        public WGPUDepthStencilState setStencilBack(WGPUStencilFaceState value) { return this; }
        public long getStencilReadMask() { return this.stencilReadMask.get(); }
        public WGPUDepthStencilState setStencilReadMask(long value) { this.stencilReadMask.set(value); return this; }
        public long getStencilWriteMask() { return this.stencilWriteMask.get(); }
        public WGPUDepthStencilState setStencilWriteMask(long value) { this.stencilWriteMask.set(value); return this; }
        public int getDepthBias() { return this.depthBias.get(); }
        public WGPUDepthStencilState setDepthBias(int value) { this.depthBias.set(value); return this; }
        public float getDepthBiasSlopeScale() { return this.depthBiasSlopeScale.get(); }
        public WGPUDepthStencilState setDepthBiasSlopeScale(float value) { this.depthBiasSlopeScale.set(value); return this; }
        public float getDepthBiasClamp() { return this.depthBiasClamp.get(); }
        public WGPUDepthStencilState setDepthBiasClamp(float value) { this.depthBiasClamp.set(value); return this; }
    }
    public static class WGPUImageCopyBuffer extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final WGPUTextureDataLayout layout = inner(new WGPUTextureDataLayout());
        private final Struct.Pointer buffer = new Struct.Pointer();
        public WGPUImageCopyBuffer() {}

        public WGPUImageCopyBuffer(Runtime runtime) { super(runtime); }

        public static WGPUImageCopyBuffer create() { return new WGPUImageCopyBuffer(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUImageCopyBuffer setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPUTextureDataLayout getLayout() { return this.layout; }
        public WGPUImageCopyBuffer setLayout(WGPUTextureDataLayout value) { return this; }
        public jnr.ffi.Pointer getBuffer() { return this.buffer.get(); }
        public WGPUImageCopyBuffer setBuffer(jnr.ffi.Pointer value) { this.buffer.set(value); return this; }
    }
    public static class WGPUImageCopyTexture extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Pointer texture = new Struct.Pointer();
        private final Struct.Unsigned32 mipLevel = new Struct.Unsigned32();
        private final WGPUOrigin3D origin = inner(new WGPUOrigin3D());
        private final Struct.Enum<WGPUTextureAspect> aspect = new Struct.Enum<>(WGPUTextureAspect.class);
        public WGPUImageCopyTexture() {}

        public WGPUImageCopyTexture(Runtime runtime) { super(runtime); }

        public static WGPUImageCopyTexture create() { return new WGPUImageCopyTexture(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUImageCopyTexture setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public jnr.ffi.Pointer getTexture() { return this.texture.get(); }
        public WGPUImageCopyTexture setTexture(jnr.ffi.Pointer value) { this.texture.set(value); return this; }
        public long getMipLevel() { return this.mipLevel.get(); }
        public WGPUImageCopyTexture setMipLevel(long value) { this.mipLevel.set(value); return this; }
        public WGPUOrigin3D getOrigin() { return this.origin; }
        public WGPUImageCopyTexture setOrigin(WGPUOrigin3D value) { return this; }
        public WGPUTextureAspect getAspect() { return this.aspect.get(); }
        public WGPUImageCopyTexture setAspect(WGPUTextureAspect value) { this.aspect.set(value); return this; }
    }
    public static class WGPUProgrammableStageDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Pointer module = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer entryPoint = new Struct.Pointer();
        private final Struct.UnsignedLong constantCount = new Struct.UnsignedLong();
        private final Struct.Pointer constants = new Struct.Pointer();
        public WGPUProgrammableStageDescriptor() {}

        public WGPUProgrammableStageDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUProgrammableStageDescriptor create() { return new WGPUProgrammableStageDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUProgrammableStageDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public jnr.ffi.Pointer getModule() { return this.module.get(); }
        public WGPUProgrammableStageDescriptor setModule(jnr.ffi.Pointer value) { this.module.set(value); return this; }
        public java.lang.String getEntryPoint() { return RustCString.fromPointer(this.entryPoint.get()); }
        public WGPUProgrammableStageDescriptor setEntryPoint(java.lang.String value) { this.entryPoint.set(RustCString.toPointer(value)); return this; }
        public long getConstantCount() { return this.constantCount.get(); }
        public WGPUProgrammableStageDescriptor setConstantCount(long value) { this.constantCount.set(value); return this; }
        public jnr.ffi.Pointer getConstants() { return this.constants.get(); }
        public WGPUProgrammableStageDescriptor setConstants(jnr.ffi.Pointer value) { this.constants.set(value); return this; }
    }
    public static class WGPURenderPassColorAttachment extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Pointer view = new Struct.Pointer();
        private final Struct.Pointer resolveTarget = new Struct.Pointer();
        private final Struct.Enum<WGPULoadOp> loadOp = new Struct.Enum<>(WGPULoadOp.class);
        private final Struct.Enum<WGPUStoreOp> storeOp = new Struct.Enum<>(WGPUStoreOp.class);
        private final WGPUColor clearValue = inner(new WGPUColor());
        public WGPURenderPassColorAttachment() {}

        public WGPURenderPassColorAttachment(Runtime runtime) { super(runtime); }

        public static WGPURenderPassColorAttachment create() { return new WGPURenderPassColorAttachment(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPURenderPassColorAttachment setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public jnr.ffi.Pointer getView() { return this.view.get(); }
        public WGPURenderPassColorAttachment setView(jnr.ffi.Pointer value) { this.view.set(value); return this; }
        public jnr.ffi.Pointer getResolveTarget() { return this.resolveTarget.get(); }
        public WGPURenderPassColorAttachment setResolveTarget(jnr.ffi.Pointer value) { this.resolveTarget.set(value); return this; }
        public WGPULoadOp getLoadOp() { return this.loadOp.get(); }
        public WGPURenderPassColorAttachment setLoadOp(WGPULoadOp value) { this.loadOp.set(value); return this; }
        public WGPUStoreOp getStoreOp() { return this.storeOp.get(); }
        public WGPURenderPassColorAttachment setStoreOp(WGPUStoreOp value) { this.storeOp.set(value); return this; }
        public WGPUColor getClearValue() { return this.clearValue; }
        public WGPURenderPassColorAttachment setClearValue(WGPUColor value) { return this; }
    }
    public static class WGPURequiredLimits extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final WGPULimits limits = inner(new WGPULimits());
        public WGPURequiredLimits() {}

        public WGPURequiredLimits(Runtime runtime) { super(runtime); }

        public static WGPURequiredLimits create() { return new WGPURequiredLimits(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPURequiredLimits setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPULimits getLimits() { return this.limits; }
        public WGPURequiredLimits setLimits(WGPULimits value) { return this; }
    }
    public static class WGPUShaderModuleDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.UnsignedLong hintCount = new Struct.UnsignedLong();
        private final Struct.Pointer hints = new Struct.Pointer();
        public WGPUShaderModuleDescriptor() {}

        public WGPUShaderModuleDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUShaderModuleDescriptor create() { return new WGPUShaderModuleDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUShaderModuleDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUShaderModuleDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public long getHintCount() { return this.hintCount.get(); }
        public WGPUShaderModuleDescriptor setHintCount(long value) { this.hintCount.set(value); return this; }
        public jnr.ffi.Pointer getHints() { return this.hints.get(); }
        public WGPUShaderModuleDescriptor setHints(jnr.ffi.Pointer value) { this.hints.set(value); return this; }
    }
    public static class WGPUSupportedLimits extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final WGPULimits limits = inner(new WGPULimits());
        public WGPUSupportedLimits() {}

        public WGPUSupportedLimits(Runtime runtime) { super(runtime); }

        public static WGPUSupportedLimits create() { return new WGPUSupportedLimits(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUSupportedLimits setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPULimits getLimits() { return this.limits; }
        public WGPUSupportedLimits setLimits(WGPULimits value) { return this; }
    }
    public static class WGPUTextureDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Unsigned32 usage = new Struct.Unsigned32();
        private final Struct.Enum<WGPUTextureDimension> dimension = new Struct.Enum<>(WGPUTextureDimension.class);
        private final WGPUExtent3D size = inner(new WGPUExtent3D());
        private final Struct.Enum<WGPUTextureFormat> format = new Struct.Enum<>(WGPUTextureFormat.class);
        private final Struct.Unsigned32 mipLevelCount = new Struct.Unsigned32();
        private final Struct.Unsigned32 sampleCount = new Struct.Unsigned32();
        private final Struct.UnsignedLong viewFormatCount = new Struct.UnsignedLong();
        private final Struct.Pointer viewFormats = new Struct.Pointer();
        public WGPUTextureDescriptor() {}

        public WGPUTextureDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUTextureDescriptor create() { return new WGPUTextureDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUTextureDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUTextureDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public long getUsage() { return this.usage.get(); }
        public WGPUTextureDescriptor setUsage(long value) { this.usage.set(value); return this; }
        public WGPUTextureDimension getDimension() { return this.dimension.get(); }
        public WGPUTextureDescriptor setDimension(WGPUTextureDimension value) { this.dimension.set(value); return this; }
        public WGPUExtent3D getSize() { return this.size; }
        public WGPUTextureDescriptor setSize(WGPUExtent3D value) { return this; }
        public WGPUTextureFormat getFormat() { return this.format.get(); }
        public WGPUTextureDescriptor setFormat(WGPUTextureFormat value) { this.format.set(value); return this; }
        public long getMipLevelCount() { return this.mipLevelCount.get(); }
        public WGPUTextureDescriptor setMipLevelCount(long value) { this.mipLevelCount.set(value); return this; }
        public long getSampleCount() { return this.sampleCount.get(); }
        public WGPUTextureDescriptor setSampleCount(long value) { this.sampleCount.set(value); return this; }
        public long getViewFormatCount() { return this.viewFormatCount.get(); }
        public WGPUTextureDescriptor setViewFormatCount(long value) { this.viewFormatCount.set(value); return this; }
        public jnr.ffi.Pointer getViewFormats() { return this.viewFormats.get(); }
        public WGPUTextureDescriptor setViewFormats(jnr.ffi.Pointer value) { this.viewFormats.set(value); return this; }
    }
    public static class WGPUVertexBufferLayout extends WgpuStruct {
        private final Struct.UnsignedLong arrayStride = new Struct.UnsignedLong();
        private final Struct.Enum<WGPUVertexStepMode> stepMode = new Struct.Enum<>(WGPUVertexStepMode.class);
        private final Struct.UnsignedLong attributeCount = new Struct.UnsignedLong();
        private final Struct.Pointer attributes = new Struct.Pointer();
        public WGPUVertexBufferLayout() {}

        public WGPUVertexBufferLayout(Runtime runtime) { super(runtime); }

        public static WGPUVertexBufferLayout create() { return new WGPUVertexBufferLayout(); }

        public long getArrayStride() { return this.arrayStride.get(); }
        public WGPUVertexBufferLayout setArrayStride(long value) { this.arrayStride.set(value); return this; }
        public WGPUVertexStepMode getStepMode() { return this.stepMode.get(); }
        public WGPUVertexBufferLayout setStepMode(WGPUVertexStepMode value) { this.stepMode.set(value); return this; }
        public long getAttributeCount() { return this.attributeCount.get(); }
        public WGPUVertexBufferLayout setAttributeCount(long value) { this.attributeCount.set(value); return this; }
        public jnr.ffi.Pointer getAttributes() { return this.attributes.get(); }
        public WGPUVertexBufferLayout setAttributes(jnr.ffi.Pointer value) { this.attributes.set(value); return this; }
    }
    public static class WGPUBindGroupLayoutDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.UnsignedLong entryCount = new Struct.UnsignedLong();
        private final Struct.Pointer entries = new Struct.Pointer();
        public WGPUBindGroupLayoutDescriptor() {}

        public WGPUBindGroupLayoutDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUBindGroupLayoutDescriptor create() { return new WGPUBindGroupLayoutDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUBindGroupLayoutDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUBindGroupLayoutDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public long getEntryCount() { return this.entryCount.get(); }
        public WGPUBindGroupLayoutDescriptor setEntryCount(long value) { this.entryCount.set(value); return this; }
        public jnr.ffi.Pointer getEntries() { return this.entries.get(); }
        public WGPUBindGroupLayoutDescriptor setEntries(jnr.ffi.Pointer value) { this.entries.set(value); return this; }
    }
    public static class WGPUColorTargetState extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Enum<WGPUTextureFormat> format = new Struct.Enum<>(WGPUTextureFormat.class);
        private final Struct.Pointer blend = new Struct.Pointer();
        private final Struct.Unsigned32 writeMask = new Struct.Unsigned32();
        public WGPUColorTargetState() {}

        public WGPUColorTargetState(Runtime runtime) { super(runtime); }

        public static WGPUColorTargetState create() { return new WGPUColorTargetState(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUColorTargetState setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public WGPUTextureFormat getFormat() { return this.format.get(); }
        public WGPUColorTargetState setFormat(WGPUTextureFormat value) { this.format.set(value); return this; }
        public jnr.ffi.Pointer getBlend() { return this.blend.get(); }
        public WGPUColorTargetState setBlend(jnr.ffi.Pointer value) { this.blend.set(value); return this; }
        public long getWriteMask() { return this.writeMask.get(); }
        public WGPUColorTargetState setWriteMask(long value) { this.writeMask.set(value); return this; }
    }
    public static class WGPUComputePipelineDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Pointer layout = new Struct.Pointer();
        private final WGPUProgrammableStageDescriptor compute = inner(new WGPUProgrammableStageDescriptor());
        public WGPUComputePipelineDescriptor() {}

        public WGPUComputePipelineDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUComputePipelineDescriptor create() { return new WGPUComputePipelineDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUComputePipelineDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUComputePipelineDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public jnr.ffi.Pointer getLayout() { return this.layout.get(); }
        public WGPUComputePipelineDescriptor setLayout(jnr.ffi.Pointer value) { this.layout.set(value); return this; }
        public WGPUProgrammableStageDescriptor getCompute() { return this.compute; }
        public WGPUComputePipelineDescriptor setCompute(WGPUProgrammableStageDescriptor value) { return this; }
    }
    public static class WGPUDeviceDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.UnsignedLong requiredFeatureCount = new Struct.UnsignedLong();
        private final Struct.Pointer requiredFeatures = new Struct.Pointer();
        private final Struct.Pointer requiredLimits = new Struct.Pointer();
        private final WGPUQueueDescriptor defaultQueue = inner(new WGPUQueueDescriptor());
        private final WGPUDeviceLostCallback deviceLostCallback = null;
        private final Struct.Pointer deviceLostUserdata = new Struct.Pointer();
        public WGPUDeviceDescriptor() {}

        public WGPUDeviceDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUDeviceDescriptor create() { return new WGPUDeviceDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUDeviceDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPUDeviceDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public long getRequiredFeatureCount() { return this.requiredFeatureCount.get(); }
        public WGPUDeviceDescriptor setRequiredFeatureCount(long value) { this.requiredFeatureCount.set(value); return this; }
        public jnr.ffi.Pointer getRequiredFeatures() { return this.requiredFeatures.get(); }
        public WGPUDeviceDescriptor setRequiredFeatures(jnr.ffi.Pointer value) { this.requiredFeatures.set(value); return this; }
        public jnr.ffi.Pointer getRequiredLimits() { return this.requiredLimits.get(); }
        public WGPUDeviceDescriptor setRequiredLimits(jnr.ffi.Pointer value) { this.requiredLimits.set(value); return this; }
        public WGPUQueueDescriptor getDefaultQueue() { return this.defaultQueue; }
        public WGPUDeviceDescriptor setDefaultQueue(WGPUQueueDescriptor value) { return this; }
        public WGPUDeviceLostCallback getDeviceLostCallback() { return this.deviceLostCallback; }
        public WGPUDeviceDescriptor setDeviceLostCallback(WGPUDeviceLostCallback value) { return this; }
        public jnr.ffi.Pointer getDeviceLostUserdata() { return this.deviceLostUserdata.get(); }
        public WGPUDeviceDescriptor setDeviceLostUserdata(jnr.ffi.Pointer value) { this.deviceLostUserdata.set(value); return this; }
    }
    public static class WGPURenderPassDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.UnsignedLong colorAttachmentCount = new Struct.UnsignedLong();
        private final Struct.Pointer colorAttachments = new Struct.Pointer();
        private final Struct.Pointer depthStencilAttachment = new Struct.Pointer();
        private final Struct.Pointer occlusionQuerySet = new Struct.Pointer();
        private final Struct.Pointer timestampWrites = new Struct.Pointer();
        public WGPURenderPassDescriptor() {}

        public WGPURenderPassDescriptor(Runtime runtime) { super(runtime); }

        public static WGPURenderPassDescriptor create() { return new WGPURenderPassDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPURenderPassDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPURenderPassDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public long getColorAttachmentCount() { return this.colorAttachmentCount.get(); }
        public WGPURenderPassDescriptor setColorAttachmentCount(long value) { this.colorAttachmentCount.set(value); return this; }
        public jnr.ffi.Pointer getColorAttachments() { return this.colorAttachments.get(); }
        public WGPURenderPassDescriptor setColorAttachments(jnr.ffi.Pointer value) { this.colorAttachments.set(value); return this; }
        public jnr.ffi.Pointer getDepthStencilAttachment() { return this.depthStencilAttachment.get(); }
        public WGPURenderPassDescriptor setDepthStencilAttachment(jnr.ffi.Pointer value) { this.depthStencilAttachment.set(value); return this; }
        public jnr.ffi.Pointer getOcclusionQuerySet() { return this.occlusionQuerySet.get(); }
        public WGPURenderPassDescriptor setOcclusionQuerySet(jnr.ffi.Pointer value) { this.occlusionQuerySet.set(value); return this; }
        public jnr.ffi.Pointer getTimestampWrites() { return this.timestampWrites.get(); }
        public WGPURenderPassDescriptor setTimestampWrites(jnr.ffi.Pointer value) { this.timestampWrites.set(value); return this; }
    }
    public static class WGPUVertexState extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Pointer module = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer entryPoint = new Struct.Pointer();
        private final Struct.UnsignedLong constantCount = new Struct.UnsignedLong();
        private final Struct.Pointer constants = new Struct.Pointer();
        private final Struct.UnsignedLong bufferCount = new Struct.UnsignedLong();
        private final Struct.Pointer buffers = new Struct.Pointer();
        public WGPUVertexState() {}

        public WGPUVertexState(Runtime runtime) { super(runtime); }

        public static WGPUVertexState create() { return new WGPUVertexState(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUVertexState setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public jnr.ffi.Pointer getModule() { return this.module.get(); }
        public WGPUVertexState setModule(jnr.ffi.Pointer value) { this.module.set(value); return this; }
        public java.lang.String getEntryPoint() { return RustCString.fromPointer(this.entryPoint.get()); }
        public WGPUVertexState setEntryPoint(java.lang.String value) { this.entryPoint.set(RustCString.toPointer(value)); return this; }
        public long getConstantCount() { return this.constantCount.get(); }
        public WGPUVertexState setConstantCount(long value) { this.constantCount.set(value); return this; }
        public jnr.ffi.Pointer getConstants() { return this.constants.get(); }
        public WGPUVertexState setConstants(jnr.ffi.Pointer value) { this.constants.set(value); return this; }
        public long getBufferCount() { return this.bufferCount.get(); }
        public WGPUVertexState setBufferCount(long value) { this.bufferCount.set(value); return this; }
        public jnr.ffi.Pointer getBuffers() { return this.buffers.get(); }
        public WGPUVertexState setBuffers(jnr.ffi.Pointer value) { this.buffers.set(value); return this; }
    }
    public static class WGPUFragmentState extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Pointer module = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer entryPoint = new Struct.Pointer();
        private final Struct.UnsignedLong constantCount = new Struct.UnsignedLong();
        private final Struct.Pointer constants = new Struct.Pointer();
        private final Struct.UnsignedLong targetCount = new Struct.UnsignedLong();
        private final Struct.Pointer targets = new Struct.Pointer();
        public WGPUFragmentState() {}

        public WGPUFragmentState(Runtime runtime) { super(runtime); }

        public static WGPUFragmentState create() { return new WGPUFragmentState(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUFragmentState setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public jnr.ffi.Pointer getModule() { return this.module.get(); }
        public WGPUFragmentState setModule(jnr.ffi.Pointer value) { this.module.set(value); return this; }
        public java.lang.String getEntryPoint() { return RustCString.fromPointer(this.entryPoint.get()); }
        public WGPUFragmentState setEntryPoint(java.lang.String value) { this.entryPoint.set(RustCString.toPointer(value)); return this; }
        public long getConstantCount() { return this.constantCount.get(); }
        public WGPUFragmentState setConstantCount(long value) { this.constantCount.set(value); return this; }
        public jnr.ffi.Pointer getConstants() { return this.constants.get(); }
        public WGPUFragmentState setConstants(jnr.ffi.Pointer value) { this.constants.set(value); return this; }
        public long getTargetCount() { return this.targetCount.get(); }
        public WGPUFragmentState setTargetCount(long value) { this.targetCount.set(value); return this; }
        public jnr.ffi.Pointer getTargets() { return this.targets.get(); }
        public WGPUFragmentState setTargets(jnr.ffi.Pointer value) { this.targets.set(value); return this; }
    }
    public static class WGPURenderPipelineDescriptor extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer label = new Struct.Pointer();
        private final Struct.Pointer layout = new Struct.Pointer();
        private final WGPUVertexState vertex = inner(new WGPUVertexState());
        private final WGPUPrimitiveState primitive = inner(new WGPUPrimitiveState());
        private final Struct.Pointer depthStencil = new Struct.Pointer();
        private final WGPUMultisampleState multisample = inner(new WGPUMultisampleState());
        private final Struct.Pointer fragment = new Struct.Pointer();
        public WGPURenderPipelineDescriptor() {}

        public WGPURenderPipelineDescriptor(Runtime runtime) { super(runtime); }

        public static WGPURenderPipelineDescriptor create() { return new WGPURenderPipelineDescriptor(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPURenderPipelineDescriptor setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public java.lang.String getLabel() { return RustCString.fromPointer(this.label.get()); }
        public WGPURenderPipelineDescriptor setLabel(java.lang.String value) { this.label.set(RustCString.toPointer(value)); return this; }
        public jnr.ffi.Pointer getLayout() { return this.layout.get(); }
        public WGPURenderPipelineDescriptor setLayout(jnr.ffi.Pointer value) { this.layout.set(value); return this; }
        public WGPUVertexState getVertex() { return this.vertex; }
        public WGPURenderPipelineDescriptor setVertex(WGPUVertexState value) { return this; }
        public WGPUPrimitiveState getPrimitive() { return this.primitive; }
        public WGPURenderPipelineDescriptor setPrimitive(WGPUPrimitiveState value) { return this; }
        public jnr.ffi.Pointer getDepthStencil() { return this.depthStencil.get(); }
        public WGPURenderPipelineDescriptor setDepthStencil(jnr.ffi.Pointer value) { this.depthStencil.set(value); return this; }
        public WGPUMultisampleState getMultisample() { return this.multisample; }
        public WGPURenderPipelineDescriptor setMultisample(WGPUMultisampleState value) { return this; }
        public jnr.ffi.Pointer getFragment() { return this.fragment.get(); }
        public WGPURenderPipelineDescriptor setFragment(jnr.ffi.Pointer value) { this.fragment.set(value); return this; }
    }
    public enum WGPUNativeSType {
        WGPUSType_DeviceExtras,
        WGPUSType_RequiredLimitsExtras,
        WGPUSType_PipelineLayoutExtras,
        WGPUSType_ShaderModuleGLSLDescriptor,
        WGPUSType_SupportedLimitsExtras,
        WGPUSType_InstanceExtras,
        WGPUSType_BindGroupEntryExtras,
        WGPUSType_BindGroupLayoutEntryExtras,
        WGPUSType_QuerySetDescriptorExtras,
        Force32,
    }
    public enum WGPUNativeFeature {
        PushConstants,
        TextureAdapterSpecificFormatFeatures,
        MultiDrawIndirect,
        MultiDrawIndirectCount,
        VertexWritableStorage,
        TextureBindingArray,
        SampledTextureAndStorageBufferArrayNonUniformIndexing,
        PipelineStatisticsQuery,
        Force32,
    }
    public enum WGPULogLevel {
        Off,
        Error,
        Warn,
        Info,
        Debug,
        Trace,
        Force32,
    }
    public enum WGPUInstanceBackend {
        All,
        Vulkan,
        GL,
        Metal,
        DX12,
        DX11,
        BrowserWebGPU,
        Primary,
        Secondary,
        Force32,
    }
    public enum WGPUInstanceFlag {
        Default,
        Debug,
        Validation,
        DiscardHalLabels,
        Force32,
    }
    public enum WGPUDx12Compiler {
        Undefined,
        Fxc,
        Dxc,
        Force32,
    }
    public enum WGPUGles3MinorVersion {
        Automatic,
        Version0,
        Version1,
        Version2,
        Force32,
    }
    public enum WGPUPipelineStatisticName {
        VertexShaderInvocations,
        ClipperInvocations,
        ClipperPrimitivesOut,
        FragmentShaderInvocations,
        ComputeShaderInvocations,
        Force32,
    }
    public enum WGPUNativeQueryType {
        PipelineStatistics,
        Force32,
    }
    public static class WGPUInstanceExtras extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Unsigned32 backends = new Struct.Unsigned32();
        private final Struct.Unsigned32 flags = new Struct.Unsigned32();
        private final Struct.Enum<WGPUDx12Compiler> dx12ShaderCompiler = new Struct.Enum<>(WGPUDx12Compiler.class);
        private final Struct.Enum<WGPUGles3MinorVersion> gles3MinorVersion = new Struct.Enum<>(WGPUGles3MinorVersion.class);
        private final @CStrPointer Struct.Pointer dxilPath = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer dxcPath = new Struct.Pointer();
        public WGPUInstanceExtras() {}

        public WGPUInstanceExtras(Runtime runtime) { super(runtime); }

        public static WGPUInstanceExtras create() { return new WGPUInstanceExtras(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUInstanceExtras setChain(WGPUChainedStruct value) { return this; }
        public long getBackends() { return this.backends.get(); }
        public WGPUInstanceExtras setBackends(long value) { this.backends.set(value); return this; }
        public long getFlags() { return this.flags.get(); }
        public WGPUInstanceExtras setFlags(long value) { this.flags.set(value); return this; }
        public WGPUDx12Compiler getDx12ShaderCompiler() { return this.dx12ShaderCompiler.get(); }
        public WGPUInstanceExtras setDx12ShaderCompiler(WGPUDx12Compiler value) { this.dx12ShaderCompiler.set(value); return this; }
        public WGPUGles3MinorVersion getGles3MinorVersion() { return this.gles3MinorVersion.get(); }
        public WGPUInstanceExtras setGles3MinorVersion(WGPUGles3MinorVersion value) { this.gles3MinorVersion.set(value); return this; }
        public java.lang.String getDxilPath() { return RustCString.fromPointer(this.dxilPath.get()); }
        public WGPUInstanceExtras setDxilPath(java.lang.String value) { this.dxilPath.set(RustCString.toPointer(value)); return this; }
        public java.lang.String getDxcPath() { return RustCString.fromPointer(this.dxcPath.get()); }
        public WGPUInstanceExtras setDxcPath(java.lang.String value) { this.dxcPath.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPUDeviceExtras extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final @CStrPointer Struct.Pointer tracePath = new Struct.Pointer();
        public WGPUDeviceExtras() {}

        public WGPUDeviceExtras(Runtime runtime) { super(runtime); }

        public static WGPUDeviceExtras create() { return new WGPUDeviceExtras(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUDeviceExtras setChain(WGPUChainedStruct value) { return this; }
        public java.lang.String getTracePath() { return RustCString.fromPointer(this.tracePath.get()); }
        public WGPUDeviceExtras setTracePath(java.lang.String value) { this.tracePath.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPUNativeLimits extends WgpuStruct {
        private final Struct.Unsigned32 maxPushConstantSize = new Struct.Unsigned32();
        private final Struct.Unsigned32 maxNonSamplerBindings = new Struct.Unsigned32();
        public WGPUNativeLimits() {}

        public WGPUNativeLimits(Runtime runtime) { super(runtime); }

        public static WGPUNativeLimits create() { return new WGPUNativeLimits(); }

        public long getMaxPushConstantSize() { return this.maxPushConstantSize.get(); }
        public WGPUNativeLimits setMaxPushConstantSize(long value) { this.maxPushConstantSize.set(value); return this; }
        public long getMaxNonSamplerBindings() { return this.maxNonSamplerBindings.get(); }
        public WGPUNativeLimits setMaxNonSamplerBindings(long value) { this.maxNonSamplerBindings.set(value); return this; }
    }
    public static class WGPURequiredLimitsExtras extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final WGPUNativeLimits limits = inner(new WGPUNativeLimits());
        public WGPURequiredLimitsExtras() {}

        public WGPURequiredLimitsExtras(Runtime runtime) { super(runtime); }

        public static WGPURequiredLimitsExtras create() { return new WGPURequiredLimitsExtras(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPURequiredLimitsExtras setChain(WGPUChainedStruct value) { return this; }
        public WGPUNativeLimits getLimits() { return this.limits; }
        public WGPURequiredLimitsExtras setLimits(WGPUNativeLimits value) { return this; }
    }
    public static class WGPUSupportedLimitsExtras extends WgpuStruct {
        private final WGPUChainedStructOut chain = inner(new WGPUChainedStructOut());
        private final WGPUNativeLimits limits = inner(new WGPUNativeLimits());
        public WGPUSupportedLimitsExtras() {}

        public WGPUSupportedLimitsExtras(Runtime runtime) { super(runtime); }

        public static WGPUSupportedLimitsExtras create() { return new WGPUSupportedLimitsExtras(); }

        public WGPUChainedStructOut getChain() { return this.chain; }
        public WGPUSupportedLimitsExtras setChain(WGPUChainedStructOut value) { return this; }
        public WGPUNativeLimits getLimits() { return this.limits; }
        public WGPUSupportedLimitsExtras setLimits(WGPUNativeLimits value) { return this; }
    }
    public static class WGPUPushConstantRange extends WgpuStruct {
        private final Struct.Unsigned32 stages = new Struct.Unsigned32();
        private final Struct.Unsigned32 start = new Struct.Unsigned32();
        private final Struct.Unsigned32 end = new Struct.Unsigned32();
        public WGPUPushConstantRange() {}

        public WGPUPushConstantRange(Runtime runtime) { super(runtime); }

        public static WGPUPushConstantRange create() { return new WGPUPushConstantRange(); }

        public long getStages() { return this.stages.get(); }
        public WGPUPushConstantRange setStages(long value) { this.stages.set(value); return this; }
        public long getStart() { return this.start.get(); }
        public WGPUPushConstantRange setStart(long value) { this.start.set(value); return this; }
        public long getEnd() { return this.end.get(); }
        public WGPUPushConstantRange setEnd(long value) { this.end.set(value); return this; }
    }
    public static class WGPUPipelineLayoutExtras extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Unsigned32 pushConstantRangeCount = new Struct.Unsigned32();
        private final Struct.Pointer pushConstantRanges = new Struct.Pointer();
        public WGPUPipelineLayoutExtras() {}

        public WGPUPipelineLayoutExtras(Runtime runtime) { super(runtime); }

        public static WGPUPipelineLayoutExtras create() { return new WGPUPipelineLayoutExtras(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUPipelineLayoutExtras setChain(WGPUChainedStruct value) { return this; }
        public long getPushConstantRangeCount() { return this.pushConstantRangeCount.get(); }
        public WGPUPipelineLayoutExtras setPushConstantRangeCount(long value) { this.pushConstantRangeCount.set(value); return this; }
        public jnr.ffi.Pointer getPushConstantRanges() { return this.pushConstantRanges.get(); }
        public WGPUPipelineLayoutExtras setPushConstantRanges(jnr.ffi.Pointer value) { this.pushConstantRanges.set(value); return this; }
    }
    public static class WGPUWrappedSubmissionIndex extends WgpuStruct {
        private final Struct.Pointer queue = new Struct.Pointer();
        private final Struct.UnsignedLong submissionIndex = new Struct.UnsignedLong();
        public WGPUWrappedSubmissionIndex() {}

        public WGPUWrappedSubmissionIndex(Runtime runtime) { super(runtime); }

        public static WGPUWrappedSubmissionIndex create() { return new WGPUWrappedSubmissionIndex(); }

        public jnr.ffi.Pointer getQueue() { return this.queue.get(); }
        public WGPUWrappedSubmissionIndex setQueue(jnr.ffi.Pointer value) { this.queue.set(value); return this; }
        public long getSubmissionIndex() { return this.submissionIndex.get(); }
        public WGPUWrappedSubmissionIndex setSubmissionIndex(long value) { this.submissionIndex.set(value); return this; }
    }
    public static class WGPUShaderDefine extends WgpuStruct {
        private final @CStrPointer Struct.Pointer name = new Struct.Pointer();
        private final @CStrPointer Struct.Pointer value = new Struct.Pointer();
        public WGPUShaderDefine() {}

        public WGPUShaderDefine(Runtime runtime) { super(runtime); }

        public static WGPUShaderDefine create() { return new WGPUShaderDefine(); }

        public java.lang.String getName() { return RustCString.fromPointer(this.name.get()); }
        public WGPUShaderDefine setName(java.lang.String value) { this.name.set(RustCString.toPointer(value)); return this; }
        public java.lang.String getValue() { return RustCString.fromPointer(this.value.get()); }
        public WGPUShaderDefine setValue(java.lang.String value) { this.value.set(RustCString.toPointer(value)); return this; }
    }
    public static class WGPUShaderModuleGLSLDescriptor extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Enum<WGPUShaderStage> stage = new Struct.Enum<>(WGPUShaderStage.class);
        private final @CStrPointer Struct.Pointer code = new Struct.Pointer();
        private final Struct.Unsigned32 defineCount = new Struct.Unsigned32();
        private final Struct.Pointer defines = new Struct.Pointer();
        public WGPUShaderModuleGLSLDescriptor() {}

        public WGPUShaderModuleGLSLDescriptor(Runtime runtime) { super(runtime); }

        public static WGPUShaderModuleGLSLDescriptor create() { return new WGPUShaderModuleGLSLDescriptor(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUShaderModuleGLSLDescriptor setChain(WGPUChainedStruct value) { return this; }
        public WGPUShaderStage getStage() { return this.stage.get(); }
        public WGPUShaderModuleGLSLDescriptor setStage(WGPUShaderStage value) { this.stage.set(value); return this; }
        public java.lang.String getCode() { return RustCString.fromPointer(this.code.get()); }
        public WGPUShaderModuleGLSLDescriptor setCode(java.lang.String value) { this.code.set(RustCString.toPointer(value)); return this; }
        public long getDefineCount() { return this.defineCount.get(); }
        public WGPUShaderModuleGLSLDescriptor setDefineCount(long value) { this.defineCount.set(value); return this; }
        public jnr.ffi.Pointer getDefines() { return this.defines.get(); }
        public WGPUShaderModuleGLSLDescriptor setDefines(jnr.ffi.Pointer value) { this.defines.set(value); return this; }
    }
    public static class WGPURegistryReport extends WgpuStruct {
        private final Struct.UnsignedLong numAllocated = new Struct.UnsignedLong();
        private final Struct.UnsignedLong numKeptFromUser = new Struct.UnsignedLong();
        private final Struct.UnsignedLong numReleasedFromUser = new Struct.UnsignedLong();
        private final Struct.UnsignedLong numDestroyedFromUser = new Struct.UnsignedLong();
        private final Struct.UnsignedLong numError = new Struct.UnsignedLong();
        private final Struct.UnsignedLong elementSize = new Struct.UnsignedLong();
        public WGPURegistryReport() {}

        public WGPURegistryReport(Runtime runtime) { super(runtime); }

        public static WGPURegistryReport create() { return new WGPURegistryReport(); }

        public long getNumAllocated() { return this.numAllocated.get(); }
        public WGPURegistryReport setNumAllocated(long value) { this.numAllocated.set(value); return this; }
        public long getNumKeptFromUser() { return this.numKeptFromUser.get(); }
        public WGPURegistryReport setNumKeptFromUser(long value) { this.numKeptFromUser.set(value); return this; }
        public long getNumReleasedFromUser() { return this.numReleasedFromUser.get(); }
        public WGPURegistryReport setNumReleasedFromUser(long value) { this.numReleasedFromUser.set(value); return this; }
        public long getNumDestroyedFromUser() { return this.numDestroyedFromUser.get(); }
        public WGPURegistryReport setNumDestroyedFromUser(long value) { this.numDestroyedFromUser.set(value); return this; }
        public long getNumError() { return this.numError.get(); }
        public WGPURegistryReport setNumError(long value) { this.numError.set(value); return this; }
        public long getElementSize() { return this.elementSize.get(); }
        public WGPURegistryReport setElementSize(long value) { this.elementSize.set(value); return this; }
    }
    public static class WGPUHubReport extends WgpuStruct {
        private final WGPURegistryReport adapters = inner(new WGPURegistryReport());
        private final WGPURegistryReport devices = inner(new WGPURegistryReport());
        private final WGPURegistryReport queues = inner(new WGPURegistryReport());
        private final WGPURegistryReport pipelineLayouts = inner(new WGPURegistryReport());
        private final WGPURegistryReport shaderModules = inner(new WGPURegistryReport());
        private final WGPURegistryReport bindGroupLayouts = inner(new WGPURegistryReport());
        private final WGPURegistryReport bindGroups = inner(new WGPURegistryReport());
        private final WGPURegistryReport commandBuffers = inner(new WGPURegistryReport());
        private final WGPURegistryReport renderBundles = inner(new WGPURegistryReport());
        private final WGPURegistryReport renderPipelines = inner(new WGPURegistryReport());
        private final WGPURegistryReport computePipelines = inner(new WGPURegistryReport());
        private final WGPURegistryReport querySets = inner(new WGPURegistryReport());
        private final WGPURegistryReport buffers = inner(new WGPURegistryReport());
        private final WGPURegistryReport textures = inner(new WGPURegistryReport());
        private final WGPURegistryReport textureViews = inner(new WGPURegistryReport());
        private final WGPURegistryReport samplers = inner(new WGPURegistryReport());
        public WGPUHubReport() {}

        public WGPUHubReport(Runtime runtime) { super(runtime); }

        public static WGPUHubReport create() { return new WGPUHubReport(); }

        public WGPURegistryReport getAdapters() { return this.adapters; }
        public WGPUHubReport setAdapters(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getDevices() { return this.devices; }
        public WGPUHubReport setDevices(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getQueues() { return this.queues; }
        public WGPUHubReport setQueues(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getPipelineLayouts() { return this.pipelineLayouts; }
        public WGPUHubReport setPipelineLayouts(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getShaderModules() { return this.shaderModules; }
        public WGPUHubReport setShaderModules(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getBindGroupLayouts() { return this.bindGroupLayouts; }
        public WGPUHubReport setBindGroupLayouts(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getBindGroups() { return this.bindGroups; }
        public WGPUHubReport setBindGroups(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getCommandBuffers() { return this.commandBuffers; }
        public WGPUHubReport setCommandBuffers(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getRenderBundles() { return this.renderBundles; }
        public WGPUHubReport setRenderBundles(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getRenderPipelines() { return this.renderPipelines; }
        public WGPUHubReport setRenderPipelines(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getComputePipelines() { return this.computePipelines; }
        public WGPUHubReport setComputePipelines(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getQuerySets() { return this.querySets; }
        public WGPUHubReport setQuerySets(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getBuffers() { return this.buffers; }
        public WGPUHubReport setBuffers(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getTextures() { return this.textures; }
        public WGPUHubReport setTextures(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getTextureViews() { return this.textureViews; }
        public WGPUHubReport setTextureViews(WGPURegistryReport value) { return this; }
        public WGPURegistryReport getSamplers() { return this.samplers; }
        public WGPUHubReport setSamplers(WGPURegistryReport value) { return this; }
    }
    public static class WGPUGlobalReport extends WgpuStruct {
        private final WGPURegistryReport surfaces = inner(new WGPURegistryReport());
        private final Struct.Enum<WGPUBackendType> backendType = new Struct.Enum<>(WGPUBackendType.class);
        private final WGPUHubReport vulkan = inner(new WGPUHubReport());
        private final WGPUHubReport metal = inner(new WGPUHubReport());
        private final WGPUHubReport dx12 = inner(new WGPUHubReport());
        private final WGPUHubReport gl = inner(new WGPUHubReport());
        public WGPUGlobalReport() {}

        public WGPUGlobalReport(Runtime runtime) { super(runtime); }

        public static WGPUGlobalReport create() { return new WGPUGlobalReport(); }

        public WGPURegistryReport getSurfaces() { return this.surfaces; }
        public WGPUGlobalReport setSurfaces(WGPURegistryReport value) { return this; }
        public WGPUBackendType getBackendType() { return this.backendType.get(); }
        public WGPUGlobalReport setBackendType(WGPUBackendType value) { this.backendType.set(value); return this; }
        public WGPUHubReport getVulkan() { return this.vulkan; }
        public WGPUGlobalReport setVulkan(WGPUHubReport value) { return this; }
        public WGPUHubReport getMetal() { return this.metal; }
        public WGPUGlobalReport setMetal(WGPUHubReport value) { return this; }
        public WGPUHubReport getDx12() { return this.dx12; }
        public WGPUGlobalReport setDx12(WGPUHubReport value) { return this; }
        public WGPUHubReport getGl() { return this.gl; }
        public WGPUGlobalReport setGl(WGPUHubReport value) { return this; }
    }
    public static class WGPUInstanceEnumerateAdapterOptions extends WgpuStruct {
        private final Struct.Pointer nextInChain = new Struct.Pointer();
        private final Struct.Unsigned32 backends = new Struct.Unsigned32();
        public WGPUInstanceEnumerateAdapterOptions() {}

        public WGPUInstanceEnumerateAdapterOptions(Runtime runtime) { super(runtime); }

        public static WGPUInstanceEnumerateAdapterOptions create() { return new WGPUInstanceEnumerateAdapterOptions(); }

        public jnr.ffi.Pointer getNextInChain() { return this.nextInChain.get(); }
        public WGPUInstanceEnumerateAdapterOptions setNextInChain(jnr.ffi.Pointer value) { this.nextInChain.set(value); return this; }
        public long getBackends() { return this.backends.get(); }
        public WGPUInstanceEnumerateAdapterOptions setBackends(long value) { this.backends.set(value); return this; }
    }
    public static class WGPUBindGroupEntryExtras extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Pointer buffers = new Struct.Pointer();
        private final Struct.UnsignedLong bufferCount = new Struct.UnsignedLong();
        private final Struct.Pointer samplers = new Struct.Pointer();
        private final Struct.UnsignedLong samplerCount = new Struct.UnsignedLong();
        private final Struct.Pointer textureViews = new Struct.Pointer();
        private final Struct.UnsignedLong textureViewCount = new Struct.UnsignedLong();
        public WGPUBindGroupEntryExtras() {}

        public WGPUBindGroupEntryExtras(Runtime runtime) { super(runtime); }

        public static WGPUBindGroupEntryExtras create() { return new WGPUBindGroupEntryExtras(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUBindGroupEntryExtras setChain(WGPUChainedStruct value) { return this; }
        public jnr.ffi.Pointer getBuffers() { return this.buffers.get(); }
        public WGPUBindGroupEntryExtras setBuffers(jnr.ffi.Pointer value) { this.buffers.set(value); return this; }
        public long getBufferCount() { return this.bufferCount.get(); }
        public WGPUBindGroupEntryExtras setBufferCount(long value) { this.bufferCount.set(value); return this; }
        public jnr.ffi.Pointer getSamplers() { return this.samplers.get(); }
        public WGPUBindGroupEntryExtras setSamplers(jnr.ffi.Pointer value) { this.samplers.set(value); return this; }
        public long getSamplerCount() { return this.samplerCount.get(); }
        public WGPUBindGroupEntryExtras setSamplerCount(long value) { this.samplerCount.set(value); return this; }
        public jnr.ffi.Pointer getTextureViews() { return this.textureViews.get(); }
        public WGPUBindGroupEntryExtras setTextureViews(jnr.ffi.Pointer value) { this.textureViews.set(value); return this; }
        public long getTextureViewCount() { return this.textureViewCount.get(); }
        public WGPUBindGroupEntryExtras setTextureViewCount(long value) { this.textureViewCount.set(value); return this; }
    }
    public static class WGPUBindGroupLayoutEntryExtras extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Unsigned32 count = new Struct.Unsigned32();
        public WGPUBindGroupLayoutEntryExtras() {}

        public WGPUBindGroupLayoutEntryExtras(Runtime runtime) { super(runtime); }

        public static WGPUBindGroupLayoutEntryExtras create() { return new WGPUBindGroupLayoutEntryExtras(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUBindGroupLayoutEntryExtras setChain(WGPUChainedStruct value) { return this; }
        public long getCount() { return this.count.get(); }
        public WGPUBindGroupLayoutEntryExtras setCount(long value) { this.count.set(value); return this; }
    }
    public static class WGPUQuerySetDescriptorExtras extends WgpuStruct {
        private final WGPUChainedStruct chain = inner(new WGPUChainedStruct());
        private final Struct.Pointer pipelineStatistics = new Struct.Pointer();
        private final Struct.UnsignedLong pipelineStatisticCount = new Struct.UnsignedLong();
        public WGPUQuerySetDescriptorExtras() {}

        public WGPUQuerySetDescriptorExtras(Runtime runtime) { super(runtime); }

        public static WGPUQuerySetDescriptorExtras create() { return new WGPUQuerySetDescriptorExtras(); }

        public WGPUChainedStruct getChain() { return this.chain; }
        public WGPUQuerySetDescriptorExtras setChain(WGPUChainedStruct value) { return this; }
        public jnr.ffi.Pointer getPipelineStatistics() { return this.pipelineStatistics.get(); }
        public WGPUQuerySetDescriptorExtras setPipelineStatistics(jnr.ffi.Pointer value) { this.pipelineStatistics.set(value); return this; }
        public long getPipelineStatisticCount() { return this.pipelineStatisticCount.get(); }
        public WGPUQuerySetDescriptorExtras setPipelineStatisticCount(long value) { this.pipelineStatisticCount.set(value); return this; }
    }
    public interface WGPULogCallback {
        @Delegate
        void callback(WGPULogLevel level, Pointer message, Pointer userdata);
    }
    public static interface WgpuNativeJNI {
        void __va_start(Pointer param0);
        void __security_init_cookie();
        void __security_check_cookie(@u_int64_t long _StackCookie);
        void __report_gsfailure(@u_int64_t long _StackCookie);
        void _invalid_parameter_noinfo();
        void _invalid_parameter_noinfo_noreturn();
        void _invoke_watson(Pointer _Expression, Pointer _FunctionName, Pointer _FileName, @u_int32_t long _LineNo, @u_int64_t long _Reserved);
        Pointer _errno();
        @int32_t int _set_errno(@int32_t int _Value);
        @int32_t int _get_errno(Pointer _Value);
        @u_int64_t long __threadid();
        @u_int64_t long __threadhandle();
        Pointer wgpuCreateInstance(Pointer descriptor);
        WGPUProc wgpuGetProcAddress(Pointer device, Pointer procName);
        @u_int64_t long wgpuAdapterEnumerateFeatures(Pointer adapter, Pointer features);
        @u_int32_t long wgpuAdapterGetLimits(Pointer adapter, Pointer limits);
        void wgpuAdapterGetProperties(Pointer adapter, Pointer properties);
        @u_int32_t long wgpuAdapterHasFeature(Pointer adapter, WGPUFeatureName feature);
        void wgpuAdapterRequestDevice(Pointer adapter, Pointer descriptor, WGPURequestDeviceCallback callback, Pointer userdata);
        void wgpuAdapterReference(Pointer adapter);
        void wgpuAdapterRelease(Pointer adapter);
        void wgpuBindGroupSetLabel(Pointer bindGroup, Pointer label);
        void wgpuBindGroupReference(Pointer bindGroup);
        void wgpuBindGroupRelease(Pointer bindGroup);
        void wgpuBindGroupLayoutSetLabel(Pointer bindGroupLayout, Pointer label);
        void wgpuBindGroupLayoutReference(Pointer bindGroupLayout);
        void wgpuBindGroupLayoutRelease(Pointer bindGroupLayout);
        void wgpuBufferDestroy(Pointer buffer);
        Pointer wgpuBufferGetConstMappedRange(Pointer buffer, @u_int64_t long offset, @u_int64_t long size);
        WGPUBufferMapState wgpuBufferGetMapState(Pointer buffer);
        Pointer wgpuBufferGetMappedRange(Pointer buffer, @u_int64_t long offset, @u_int64_t long size);
        @u_int64_t long wgpuBufferGetSize(Pointer buffer);
        @u_int32_t long wgpuBufferGetUsage(Pointer buffer);
        void wgpuBufferMapAsync(Pointer buffer, @u_int32_t long mode, @u_int64_t long offset, @u_int64_t long size, WGPUBufferMapCallback callback, Pointer userdata);
        void wgpuBufferSetLabel(Pointer buffer, Pointer label);
        void wgpuBufferUnmap(Pointer buffer);
        void wgpuBufferReference(Pointer buffer);
        void wgpuBufferRelease(Pointer buffer);
        void wgpuCommandBufferSetLabel(Pointer commandBuffer, Pointer label);
        void wgpuCommandBufferReference(Pointer commandBuffer);
        void wgpuCommandBufferRelease(Pointer commandBuffer);
        Pointer wgpuCommandEncoderBeginComputePass(Pointer commandEncoder, Pointer descriptor);
        Pointer wgpuCommandEncoderBeginRenderPass(Pointer commandEncoder, Pointer descriptor);
        void wgpuCommandEncoderClearBuffer(Pointer commandEncoder, Pointer buffer, @u_int64_t long offset, @u_int64_t long size);
        void wgpuCommandEncoderCopyBufferToBuffer(Pointer commandEncoder, Pointer source, @u_int64_t long sourceOffset, Pointer destination, @u_int64_t long destinationOffset, @u_int64_t long size);
        void wgpuCommandEncoderCopyBufferToTexture(Pointer commandEncoder, Pointer source, Pointer destination, Pointer copySize);
        void wgpuCommandEncoderCopyTextureToBuffer(Pointer commandEncoder, Pointer source, Pointer destination, Pointer copySize);
        void wgpuCommandEncoderCopyTextureToTexture(Pointer commandEncoder, Pointer source, Pointer destination, Pointer copySize);
        Pointer wgpuCommandEncoderFinish(Pointer commandEncoder, Pointer descriptor);
        void wgpuCommandEncoderInsertDebugMarker(Pointer commandEncoder, Pointer markerLabel);
        void wgpuCommandEncoderPopDebugGroup(Pointer commandEncoder);
        void wgpuCommandEncoderPushDebugGroup(Pointer commandEncoder, Pointer groupLabel);
        void wgpuCommandEncoderResolveQuerySet(Pointer commandEncoder, Pointer querySet, @u_int32_t long firstQuery, @u_int32_t long queryCount, Pointer destination, @u_int64_t long destinationOffset);
        void wgpuCommandEncoderSetLabel(Pointer commandEncoder, Pointer label);
        void wgpuCommandEncoderWriteTimestamp(Pointer commandEncoder, Pointer querySet, @u_int32_t long queryIndex);
        void wgpuCommandEncoderReference(Pointer commandEncoder);
        void wgpuCommandEncoderRelease(Pointer commandEncoder);
        void wgpuComputePassEncoderDispatchWorkgroups(Pointer computePassEncoder, @u_int32_t long workgroupCountX, @u_int32_t long workgroupCountY, @u_int32_t long workgroupCountZ);
        void wgpuComputePassEncoderDispatchWorkgroupsIndirect(Pointer computePassEncoder, Pointer indirectBuffer, @u_int64_t long indirectOffset);
        void wgpuComputePassEncoderEnd(Pointer computePassEncoder);
        void wgpuComputePassEncoderInsertDebugMarker(Pointer computePassEncoder, Pointer markerLabel);
        void wgpuComputePassEncoderPopDebugGroup(Pointer computePassEncoder);
        void wgpuComputePassEncoderPushDebugGroup(Pointer computePassEncoder, Pointer groupLabel);
        void wgpuComputePassEncoderSetBindGroup(Pointer computePassEncoder, @u_int32_t long groupIndex, Pointer group, @u_int64_t long dynamicOffsetCount, Pointer dynamicOffsets);
        void wgpuComputePassEncoderSetLabel(Pointer computePassEncoder, Pointer label);
        void wgpuComputePassEncoderSetPipeline(Pointer computePassEncoder, Pointer pipeline);
        void wgpuComputePassEncoderReference(Pointer computePassEncoder);
        void wgpuComputePassEncoderRelease(Pointer computePassEncoder);
        Pointer wgpuComputePipelineGetBindGroupLayout(Pointer computePipeline, @u_int32_t long groupIndex);
        void wgpuComputePipelineSetLabel(Pointer computePipeline, Pointer label);
        void wgpuComputePipelineReference(Pointer computePipeline);
        void wgpuComputePipelineRelease(Pointer computePipeline);
        Pointer wgpuDeviceCreateBindGroup(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateBindGroupLayout(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateBuffer(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateCommandEncoder(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateComputePipeline(Pointer device, Pointer descriptor);
        void wgpuDeviceCreateComputePipelineAsync(Pointer device, Pointer descriptor, WGPUCreateComputePipelineAsyncCallback callback, Pointer userdata);
        Pointer wgpuDeviceCreatePipelineLayout(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateQuerySet(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateRenderBundleEncoder(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateRenderPipeline(Pointer device, Pointer descriptor);
        void wgpuDeviceCreateRenderPipelineAsync(Pointer device, Pointer descriptor, WGPUCreateRenderPipelineAsyncCallback callback, Pointer userdata);
        Pointer wgpuDeviceCreateSampler(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateShaderModule(Pointer device, Pointer descriptor);
        Pointer wgpuDeviceCreateTexture(Pointer device, Pointer descriptor);
        void wgpuDeviceDestroy(Pointer device);
        @u_int64_t long wgpuDeviceEnumerateFeatures(Pointer device, Pointer features);
        @u_int32_t long wgpuDeviceGetLimits(Pointer device, Pointer limits);
        Pointer wgpuDeviceGetQueue(Pointer device);
        @u_int32_t long wgpuDeviceHasFeature(Pointer device, WGPUFeatureName feature);
        void wgpuDevicePopErrorScope(Pointer device, WGPUErrorCallback callback, Pointer userdata);
        void wgpuDevicePushErrorScope(Pointer device, WGPUErrorFilter filter);
        void wgpuDeviceSetLabel(Pointer device, Pointer label);
        void wgpuDeviceSetUncapturedErrorCallback(Pointer device, WGPUErrorCallback callback, Pointer userdata);
        void wgpuDeviceReference(Pointer device);
        void wgpuDeviceRelease(Pointer device);
        Pointer wgpuInstanceCreateSurface(Pointer instance, Pointer descriptor);
        void wgpuInstanceProcessEvents(Pointer instance);
        void wgpuInstanceRequestAdapter(Pointer instance, Pointer options, WGPURequestAdapterCallback callback, Pointer userdata);
        void wgpuInstanceReference(Pointer instance);
        void wgpuInstanceRelease(Pointer instance);
        void wgpuPipelineLayoutSetLabel(Pointer pipelineLayout, Pointer label);
        void wgpuPipelineLayoutReference(Pointer pipelineLayout);
        void wgpuPipelineLayoutRelease(Pointer pipelineLayout);
        void wgpuQuerySetDestroy(Pointer querySet);
        @u_int32_t long wgpuQuerySetGetCount(Pointer querySet);
        WGPUQueryType wgpuQuerySetGetType(Pointer querySet);
        void wgpuQuerySetSetLabel(Pointer querySet, Pointer label);
        void wgpuQuerySetReference(Pointer querySet);
        void wgpuQuerySetRelease(Pointer querySet);
        void wgpuQueueOnSubmittedWorkDone(Pointer queue, WGPUQueueWorkDoneCallback callback, Pointer userdata);
        void wgpuQueueSetLabel(Pointer queue, Pointer label);
        void wgpuQueueSubmit(Pointer queue, @u_int64_t long commandCount, Pointer commands);
        void wgpuQueueWriteBuffer(Pointer queue, Pointer buffer, @u_int64_t long bufferOffset, Pointer data, @u_int64_t long size);
        void wgpuQueueWriteTexture(Pointer queue, Pointer destination, Pointer data, @u_int64_t long dataSize, Pointer dataLayout, Pointer writeSize);
        void wgpuQueueReference(Pointer queue);
        void wgpuQueueRelease(Pointer queue);
        void wgpuRenderBundleSetLabel(Pointer renderBundle, Pointer label);
        void wgpuRenderBundleReference(Pointer renderBundle);
        void wgpuRenderBundleRelease(Pointer renderBundle);
        void wgpuRenderBundleEncoderDraw(Pointer renderBundleEncoder, @u_int32_t long vertexCount, @u_int32_t long instanceCount, @u_int32_t long firstVertex, @u_int32_t long firstInstance);
        void wgpuRenderBundleEncoderDrawIndexed(Pointer renderBundleEncoder, @u_int32_t long indexCount, @u_int32_t long instanceCount, @u_int32_t long firstIndex, @int32_t int baseVertex, @u_int32_t long firstInstance);
        void wgpuRenderBundleEncoderDrawIndexedIndirect(Pointer renderBundleEncoder, Pointer indirectBuffer, @u_int64_t long indirectOffset);
        void wgpuRenderBundleEncoderDrawIndirect(Pointer renderBundleEncoder, Pointer indirectBuffer, @u_int64_t long indirectOffset);
        Pointer wgpuRenderBundleEncoderFinish(Pointer renderBundleEncoder, Pointer descriptor);
        void wgpuRenderBundleEncoderInsertDebugMarker(Pointer renderBundleEncoder, Pointer markerLabel);
        void wgpuRenderBundleEncoderPopDebugGroup(Pointer renderBundleEncoder);
        void wgpuRenderBundleEncoderPushDebugGroup(Pointer renderBundleEncoder, Pointer groupLabel);
        void wgpuRenderBundleEncoderSetBindGroup(Pointer renderBundleEncoder, @u_int32_t long groupIndex, Pointer group, @u_int64_t long dynamicOffsetCount, Pointer dynamicOffsets);
        void wgpuRenderBundleEncoderSetIndexBuffer(Pointer renderBundleEncoder, Pointer buffer, WGPUIndexFormat format, @u_int64_t long offset, @u_int64_t long size);
        void wgpuRenderBundleEncoderSetLabel(Pointer renderBundleEncoder, Pointer label);
        void wgpuRenderBundleEncoderSetPipeline(Pointer renderBundleEncoder, Pointer pipeline);
        void wgpuRenderBundleEncoderSetVertexBuffer(Pointer renderBundleEncoder, @u_int32_t long slot, Pointer buffer, @u_int64_t long offset, @u_int64_t long size);
        void wgpuRenderBundleEncoderReference(Pointer renderBundleEncoder);
        void wgpuRenderBundleEncoderRelease(Pointer renderBundleEncoder);
        void wgpuRenderPassEncoderBeginOcclusionQuery(Pointer renderPassEncoder, @u_int32_t long queryIndex);
        void wgpuRenderPassEncoderDraw(Pointer renderPassEncoder, @u_int32_t long vertexCount, @u_int32_t long instanceCount, @u_int32_t long firstVertex, @u_int32_t long firstInstance);
        void wgpuRenderPassEncoderDrawIndexed(Pointer renderPassEncoder, @u_int32_t long indexCount, @u_int32_t long instanceCount, @u_int32_t long firstIndex, @int32_t int baseVertex, @u_int32_t long firstInstance);
        void wgpuRenderPassEncoderDrawIndexedIndirect(Pointer renderPassEncoder, Pointer indirectBuffer, @u_int64_t long indirectOffset);
        void wgpuRenderPassEncoderDrawIndirect(Pointer renderPassEncoder, Pointer indirectBuffer, @u_int64_t long indirectOffset);
        void wgpuRenderPassEncoderEnd(Pointer renderPassEncoder);
        void wgpuRenderPassEncoderEndOcclusionQuery(Pointer renderPassEncoder);
        void wgpuRenderPassEncoderExecuteBundles(Pointer renderPassEncoder, @u_int64_t long bundleCount, Pointer bundles);
        void wgpuRenderPassEncoderInsertDebugMarker(Pointer renderPassEncoder, Pointer markerLabel);
        void wgpuRenderPassEncoderPopDebugGroup(Pointer renderPassEncoder);
        void wgpuRenderPassEncoderPushDebugGroup(Pointer renderPassEncoder, Pointer groupLabel);
        void wgpuRenderPassEncoderSetBindGroup(Pointer renderPassEncoder, @u_int32_t long groupIndex, Pointer group, @u_int64_t long dynamicOffsetCount, Pointer dynamicOffsets);
        void wgpuRenderPassEncoderSetBlendConstant(Pointer renderPassEncoder, Pointer color);
        void wgpuRenderPassEncoderSetIndexBuffer(Pointer renderPassEncoder, Pointer buffer, WGPUIndexFormat format, @u_int64_t long offset, @u_int64_t long size);
        void wgpuRenderPassEncoderSetLabel(Pointer renderPassEncoder, Pointer label);
        void wgpuRenderPassEncoderSetPipeline(Pointer renderPassEncoder, Pointer pipeline);
        void wgpuRenderPassEncoderSetScissorRect(Pointer renderPassEncoder, @u_int32_t long x, @u_int32_t long y, @u_int32_t long width, @u_int32_t long height);
        void wgpuRenderPassEncoderSetStencilReference(Pointer renderPassEncoder, @u_int32_t long reference);
        void wgpuRenderPassEncoderSetVertexBuffer(Pointer renderPassEncoder, @u_int32_t long slot, Pointer buffer, @u_int64_t long offset, @u_int64_t long size);
        void wgpuRenderPassEncoderSetViewport(Pointer renderPassEncoder, float x, float y, float width, float height, float minDepth, float maxDepth);
        void wgpuRenderPassEncoderReference(Pointer renderPassEncoder);
        void wgpuRenderPassEncoderRelease(Pointer renderPassEncoder);
        Pointer wgpuRenderPipelineGetBindGroupLayout(Pointer renderPipeline, @u_int32_t long groupIndex);
        void wgpuRenderPipelineSetLabel(Pointer renderPipeline, Pointer label);
        void wgpuRenderPipelineReference(Pointer renderPipeline);
        void wgpuRenderPipelineRelease(Pointer renderPipeline);
        void wgpuSamplerSetLabel(Pointer sampler, Pointer label);
        void wgpuSamplerReference(Pointer sampler);
        void wgpuSamplerRelease(Pointer sampler);
        void wgpuShaderModuleGetCompilationInfo(Pointer shaderModule, WGPUCompilationInfoCallback callback, Pointer userdata);
        void wgpuShaderModuleSetLabel(Pointer shaderModule, Pointer label);
        void wgpuShaderModuleReference(Pointer shaderModule);
        void wgpuShaderModuleRelease(Pointer shaderModule);
        void wgpuSurfaceConfigure(Pointer surface, Pointer config);
        void wgpuSurfaceGetCapabilities(Pointer surface, Pointer adapter, Pointer capabilities);
        void wgpuSurfaceGetCurrentTexture(Pointer surface, Pointer surfaceTexture);
        WGPUTextureFormat wgpuSurfaceGetPreferredFormat(Pointer surface, Pointer adapter);
        void wgpuSurfacePresent(Pointer surface);
        void wgpuSurfaceUnconfigure(Pointer surface);
        void wgpuSurfaceReference(Pointer surface);
        void wgpuSurfaceRelease(Pointer surface);
        void wgpuSurfaceCapabilitiesFreeMembers(WGPUSurfaceCapabilities capabilities);
        Pointer wgpuTextureCreateView(Pointer texture, Pointer descriptor);
        void wgpuTextureDestroy(Pointer texture);
        @u_int32_t long wgpuTextureGetDepthOrArrayLayers(Pointer texture);
        WGPUTextureDimension wgpuTextureGetDimension(Pointer texture);
        WGPUTextureFormat wgpuTextureGetFormat(Pointer texture);
        @u_int32_t long wgpuTextureGetHeight(Pointer texture);
        @u_int32_t long wgpuTextureGetMipLevelCount(Pointer texture);
        @u_int32_t long wgpuTextureGetSampleCount(Pointer texture);
        @u_int32_t long wgpuTextureGetUsage(Pointer texture);
        @u_int32_t long wgpuTextureGetWidth(Pointer texture);
        void wgpuTextureSetLabel(Pointer texture, Pointer label);
        void wgpuTextureReference(Pointer texture);
        void wgpuTextureRelease(Pointer texture);
        void wgpuTextureViewSetLabel(Pointer textureView, Pointer label);
        void wgpuTextureViewReference(Pointer textureView);
        void wgpuTextureViewRelease(Pointer textureView);
        void wgpuGenerateReport(Pointer instance, Pointer report);
        @u_int64_t long wgpuInstanceEnumerateAdapters(Pointer instance, Pointer options, Pointer adapters);
        @u_int64_t long wgpuQueueSubmitForIndex(Pointer queue, @u_int64_t long commandCount, Pointer commands);
        @u_int32_t long wgpuDevicePoll(Pointer device, @u_int32_t long wait, Pointer wrappedSubmissionIndex);
        void wgpuSetLogCallback(WGPULogCallback callback, Pointer userdata);
        void wgpuSetLogLevel(WGPULogLevel level);
        @u_int32_t long wgpuGetVersion();
        void wgpuRenderPassEncoderSetPushConstants(Pointer encoder, @u_int32_t long stages, @u_int32_t long offset, @u_int32_t long sizeBytes, Pointer data);
        void wgpuRenderPassEncoderMultiDrawIndirect(Pointer encoder, Pointer buffer, @u_int64_t long offset, @u_int32_t long count);
        void wgpuRenderPassEncoderMultiDrawIndexedIndirect(Pointer encoder, Pointer buffer, @u_int64_t long offset, @u_int32_t long count);
        void wgpuRenderPassEncoderMultiDrawIndirectCount(Pointer encoder, Pointer buffer, @u_int64_t long offset, Pointer count_buffer, @u_int64_t long count_buffer_offset, @u_int32_t long max_count);
        void wgpuRenderPassEncoderMultiDrawIndexedIndirectCount(Pointer encoder, Pointer buffer, @u_int64_t long offset, Pointer count_buffer, @u_int64_t long count_buffer_offset, @u_int32_t long max_count);
        void wgpuComputePassEncoderBeginPipelineStatisticsQuery(Pointer computePassEncoder, Pointer querySet, @u_int32_t long queryIndex);
        void wgpuComputePassEncoderEndPipelineStatisticsQuery(Pointer computePassEncoder);
        void wgpuRenderPassEncoderBeginPipelineStatisticsQuery(Pointer renderPassEncoder, Pointer querySet, @u_int32_t long queryIndex);
        void wgpuRenderPassEncoderEndPipelineStatisticsQuery(Pointer renderPassEncoder);
    }
}