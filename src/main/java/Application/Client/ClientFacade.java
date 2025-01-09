package Application.Client;

import Config.ConfigValue;
import Config.InMemoryConfig;
import Network.Socket.ClientService;
import Network.Socket.Exception.ClientConnectionException;

import java.io.IOException;

public class ClientFacade {

    private ClientService clientService;

    private InMemoryConfig config;

    public ClientFacade() throws IOException {
        this.config = InMemoryConfig.getInstance();
    }

    public void execute() throws ClientConnectionException {
        // Connect to server
        String address = this.config.get(ConfigValue.SERVER_ADDRESS.getValue());
        int port = Integer.parseInt(this.config.get(ConfigValue.SERVER_PORT.getValue()));

        this.clientService = new ClientService(address, port);
        this.clientService.run();
    }

}
