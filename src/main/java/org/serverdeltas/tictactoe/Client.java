package org.serverdeltas.tictactoe;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private String ip;
    private int port;
    private GameState state = new GameState();
    Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() {

    }
    public static void main(String[] args) {

    }
}
