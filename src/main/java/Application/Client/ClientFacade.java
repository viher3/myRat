package Application.Client;

import Config.ConfigReader;
import Network.Socket.ClientService;

import java.io.IOException;

public class ClientFacade {

    private ClientService clientService;

    private ConfigReader config;

    public ClientFacade() throws IOException {
        this.config = ConfigReader.getInstance();
        String address = this.config.get("SERVER_ADDRESS");
        int port = Integer.parseInt(this.config.get("SERVER_PORT"));

        this.clientService = new ClientService(address, port);
    }

    public void execute() {

        this.clientService.run();

    }

}
