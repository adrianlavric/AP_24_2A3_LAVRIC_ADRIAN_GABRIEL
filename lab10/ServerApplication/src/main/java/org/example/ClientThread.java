package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientThread(Socket socket) {
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server received the request: " + inputLine);
                if (inputLine.equals("stop")) {
                    out.println("Server stopped");
                    break;
                } else {
                    out.println("Server received the request: " + inputLine);
                }
            }
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
