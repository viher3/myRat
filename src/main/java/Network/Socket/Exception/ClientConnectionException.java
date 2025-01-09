package Network.Socket.Exception;

import java.io.IOException;

public class ClientConnectionException extends IOException {

    public ClientConnectionException(String message) {
        super("Error connecting to server: " + message);
    }

}
