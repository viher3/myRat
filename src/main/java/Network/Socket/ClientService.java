package Network.Socket;

import Network.Socket.Exception.ClientConnectionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientService {

    String serverAddress;
    int serverPort;

    public ClientService() {
        this.serverAddress = "localhost";
        this.serverPort = 8080;
    }

    public ClientService(
            String serverAddress,
            int serverPort
    ) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void run() throws ClientConnectionException {
        System.out.println("Connecting to ".concat(this.serverAddress).concat(":").concat(String.valueOf(this.serverPort)));

        try (Socket socket = new Socket(this.serverAddress, this.serverPort);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to server");

            // Send a message to the server
            writer.println("Hello, Server!");
            writer.println("test-cmd");

            // Receive and print the response from the server
            String response = reader.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            throw new ClientConnectionException(e.getMessage());
        }
    }

}
