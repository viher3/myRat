package Network.Socket.Exception;

import java.io.IOException;

public class ServerConnectionException extends IOException {

    public ServerConnectionException(String message) {
        super("Error connecting to client: " + message);
    }

}
