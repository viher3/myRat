package Network.Socket;

import Network.Socket.Exception.ServerConnectionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerService {

    private int port;

    public ServerService(int port) {
        this.port = port;
    }

    public ServerService() {
        this.port = 8080;
    }

    public void run() throws ServerConnectionException {

        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            System.out.println("Server is listening on port " + this.port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                new Thread(() -> {
                    try {
                        handleClient(clientSocket);
                    } catch (ServerConnectionException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        } catch (IOException e) {
            throw new ServerConnectionException(e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) throws ServerConnectionException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);

                // Server sends response to the client
                writer.println("Server echoes: " + inputLine);

                if(inputLine.equals("test-cmd")){
                    System.out.println("Server handler => test-cmd");
                }

            }

        } catch (IOException e) {
            throw new ServerConnectionException(e.getMessage());
        }
    }

    private void disconnectClient(Socket clientSocket) throws ServerConnectionException {
        try {
            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket);
        } catch (IOException e) {
            throw new ServerConnectionException(e.getMessage());
        }
    }

}
