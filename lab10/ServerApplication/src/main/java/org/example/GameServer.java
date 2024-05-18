package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private int port;
    private ServerSocket serverSocket;

    public GameServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 12345;
        GameServer server = new GameServer(port);
        server.start();
    }
}
