package Application.Server;

import Config.ConfigReader;
import Config.ConfigValue;
import Config.InMemoryConfig;
import Network.Socket.ServerSocketService;

import java.io.IOException;

public class ServerFacade {

    private InMemoryConfig config;

    private ServerSocketService serverSocketService;

    public ServerFacade() throws IOException {
        this.config = InMemoryConfig.getInstance();
    }

    public void execute() {
        // Run server
        int port = Integer.parseInt(this.config.get(ConfigValue.SERVER_PORT.getValue()));
        this.serverSocketService = new ServerSocketService(port);
        this.serverSocketService.run();
    }
}
