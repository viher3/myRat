package Application.Server;

import Config.ConfigReader;
import Network.Socket.ServerSocketService;

import java.io.IOException;

public class ServerFacade {

    private ConfigReader config;

    private final ServerSocketService serverSocketService;

    public ServerFacade() throws IOException {
        this.config = ConfigReader.getInstance();
        int port = Integer.parseInt(this.config.get("SERVER_PORT"));

        this.serverSocketService = new ServerSocketService(port);
    }

    public void execute() {

        this.serverSocketService.run();

    }
}
