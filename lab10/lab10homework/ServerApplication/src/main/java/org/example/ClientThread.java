package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    private Socket clientSocket;
    private GameServer server;
    private BufferedReader in;
    private PrintWriter out;

    public ClientThread(Socket socket, GameServer server) {
        this.clientSocket = socket;
        this.server = server;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Error initializing client thread: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        String request;
        try {
            while ((request = in.readLine()) != null) {
                System.out.println("Received request: " + request);
                String[] parts = request.split(" ");
                String command = parts[0];
                String response;

                switch (command) {
                    case "create":
                        String gameId = server.createGame();
                        response = "Game created with ID: " + gameId;
                        break;
                    case "join":
                        if (parts.length < 3) {
                            response = "Usage: join <gameId> <playerName>";
                        } else {
                            Game game = server.getGame(parts[1]);
                            if (game != null) {
                                response = game.addPlayer(parts[2]);
                            } else {
                                response = "Game not found: " + parts[1];
                            }
                        }
                        break;
                    case "move":
                        if (parts.length < 4) {
                            response = "Usage: move <gameId> <playerName> <move>";
                        } else {
                            Game game = server.getGame(parts[1]);
                            if (game != null) {
                                response = game.submitMove(parts[2], parts[3]);
                            } else {
                                response = "Game not found: " + parts[1];
                            }
                        }
                        break;
                    case "stop":
                        response = "Server stopped";
                        server.stop();
                        break;
                    default:
                        response = "Unknown command: " + command;
                        break;
                }
                out.println(response);
            }
        } catch (IOException e) {
            System.err.println("Error handling client request: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}