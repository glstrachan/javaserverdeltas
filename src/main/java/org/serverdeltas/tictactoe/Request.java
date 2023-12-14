package org.serverdeltas.tictactoe;

public class Request {
    private String clientID;
    private String data;
    private String type;

    Request(String clientID, String data, String type) {
        this.clientID = clientID;
        this.data = data;
        this.type = type;
    }

    public Request(String serialized) {
        String[] parts = serialized.split("\"");

        this.clientID = parts[1];
        this.data = parts[3];
        this.type = parts[5];
    }

    public String getClientID() {
        return clientID;
    }

    public String getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Request {clientID: \"" + clientID + "\", data: \"" + data + "\", type: \"" + type + "\"}";
    }
}
