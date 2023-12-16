package org.serverdeltas.tictactoe;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWNativeWin32;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.*;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;


import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.IntBuffer;

import org.serverdeltas.Surface;
import org.serverdeltas.Wgpu;
import org.serverdeltas.wgpu_native.WgpuNative;

public class Client {
    private String ip;
    private int port;
    private GameState state = new GameState();
    private long window;

    Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() {
        Wgpu.loadWgpuNative();
        setupWindow();



        var hwnd = GLFWNativeWin32.glfwGetWin32Window(window);

        var instance = Wgpu.createInstance();
        var surface = instance.createSurface(hwnd);
        var adapter = instance.requestAdapter(surface);
        var device = adapter.requestDevice();
        var queue = device.getQueue();

        int width = 0;
        int height = 0;
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            width = pWidth.get();
            height = pWidth.get();
        }

        var capabilities = surface.getCapabilities(adapter);
        surface.configure(new Surface.Configuration(device, width, height).withUsage(0x10).withFormat(WgpuNative.WGPUTextureFormat.RGBA8UnormSrgb));
    }

    public void shutdown() {
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void setupWindow() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(800, 800, "Hello World!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });

        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }
         // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }

    private void loop() {
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(window) ) {
            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("0.0.0.0", 4000);

        client.start();
        client.loop();
        client.shutdown();
    }
}
