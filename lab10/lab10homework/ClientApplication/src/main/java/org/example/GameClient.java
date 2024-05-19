package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedReader stdIn;

    public GameClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        stdIn = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        System.out.println("Connected to the server. Type 'exit' to quit.");
        String userInput;
        try {
            while ((userInput = stdIn.readLine()) != null) {
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                out.println(userInput);
                System.out.println("Server response: " + in.readLine());
            }
        } catch (IOException e) {
            System.err.println("Error communicating with server: " + e.getMessage());
        } finally {
            stop();
        }
    }

    public void stop() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            System.out.println("Client stopped.");
        } catch (IOException e) {
            System.err.println("Error closing client: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            GameClient client = new GameClient("localhost", 12345);
            client.start();
        } catch (IOException e) {
            System.err.println("Could not connect to server: " + e.getMessage());
        }
    }
}
