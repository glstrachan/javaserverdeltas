package org.serverdeltas.tictactoe;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    Server(int port) {
        this.port = port;
    }

    public void start() {

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port + " and IP " + ip);

            while(true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                Request request = new Request((String) objectInputStream.readObject());
                handleRequest(request);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleRequest(Request request) {

    }

    public static void main(String[] args) {
        Server server = new Server(55);
        server.start();
    }
}
