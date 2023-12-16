package org.serverdeltas.wgpu_native;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

public class WgpuStruct extends Struct {
    public WgpuStruct(Runtime runtime) {
        super(runtime);
    }

    protected WgpuStruct() {
        super(Wgpu.getRuntime());
    }

    public WgpuStruct(final Runtime runtime, final Struct enclosing) {
        super(runtime, enclosing);
    }

    public static <T extends WgpuStruct> T createDirect(T value) {
        int size = Struct.size(value);

        jnr.ffi.Pointer pointer = Wgpu.getRuntime().getMemoryManager().allocateDirect(size);
        value.useMemory(pointer);

        return (T)value;
    }

    public jnr.ffi.Pointer getPointerTo() { return Struct.getMemory(this); }

    public class DynamicStructRef<T extends WgpuStruct> extends PointerField {
        private final Constructor<T> structConstructor;
        private final Class<T> structType;

        public DynamicStructRef(Class<T> structType) {
            this.structType = structType;

            try {
                structConstructor = structType.getDeclaredConstructor();
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("StructRef classes must have an empty constructor!", e);
            }
        }

        public final void set(T struct) {
            set(struct.getPointerTo());
        }

        public final void set(T[] structs) {
            if (structs.length == 0) {
                set(Wgpu.createNullPointer());
                return;
            }
            int size = Struct.size(structs[0]);

            jnr.ffi.Pointer value = Wgpu.createDirectPointer(size * structs.length);
            byte[] data = new byte[size];
            for (int i = 0; i < structs.length; i++) {
                Struct.getMemory(structs[i]).get(0L, data, 0, size);
                value.put(size * i, data, 0, size);
            }

            set(value);
        }

        /**
         * returns the struct from memory
         */
        public final T get() {
            T struct;
            try {
                struct = structConstructor.newInstance();
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Failed to create " + structType.getName(), e);
            }

            struct.useMemory(getPointer());
            return struct;
        }

        /**
         * returns the struct from memory
         */
        public final T[] get(int length) {
            try {
                @SuppressWarnings("unchecked")
                T[] array = (T[]) Array.newInstance(structType, length);

                for (int i = 0; i < length; ++i) {
                    array[i] = structConstructor.newInstance();
                    array[i].useMemory(getPointer().slice((long) Struct.size(array[i]) * i));
                }

                return array;
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Failed to create " + structType.getName(), e);
            }
        }

        @Override
        public java.lang.String toString() {
            return "struct @ " + super.toString()
                    + '\n' + get();
        }
    }
}
