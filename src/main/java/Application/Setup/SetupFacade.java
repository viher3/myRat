package Application.Setup;

import Application.Client.ClientFacade;
import Application.Server.ServerFacade;
import Config.PropertiesFileConfig;
import Config.ConfigValue;
import Config.InMemoryConfig;
import Network.Ip.IpFinder;
import Network.Ip.PrivateIpFinder;
import Network.Ip.PublicIpFinder;
import UI.HomePanel;

import java.io.IOException;

public class SetupFacade {

    private final HomePanel homePanel;
    private PropertiesFileConfig config;

    private final InMemoryConfig inMemoryConfig;

    public SetupFacade(HomePanel homePanel) throws IOException {
        this.config = PropertiesFileConfig.getInstance();
        this.homePanel = homePanel;
        this.inMemoryConfig = InMemoryConfig.getInstance();
    }

    public void execute() throws IOException {
        this.homePanel.appendLogText("Client version " . concat(config.get(ConfigValue.APP_VERSION.getValue())));
        this.getIpAddresses();
        this.setConfigIntoMemory();
        this.checkAppMode();
    }

    private void setConfigIntoMemory() {
        String appMode = this.config.get(ConfigValue.APP_MODE.getValue()).toUpperCase();
        this.inMemoryConfig.set(ConfigValue.APP_MODE.getValue(), appMode);

        String serverAddress = this.config.get(ConfigValue.SERVER_ADDRESS.getValue());
        String serverPort = this.config.get(ConfigValue.SERVER_PORT.getValue());
        this.inMemoryConfig.set(ConfigValue.SERVER_ADDRESS.getValue(), serverAddress);
        this.inMemoryConfig.set(ConfigValue.SERVER_PORT.getValue(), serverPort);
    }

    private void checkAppMode() throws IOException {
        String appMode = this.inMemoryConfig.get(ConfigValue.APP_MODE.getValue());


        try{
            if(appMode.equals(ConfigValue.APP_MODE_CLIENT.getValue())){
                this.homePanel.appendLogText("App mode: CLIENT");

                ClientFacade clientFacade = new ClientFacade();
                clientFacade.execute();
            }else if(appMode.equals(ConfigValue.APP_MODE_SERVER.getValue())){
                this.homePanel.appendLogText("App mode: SERVER");

                ServerFacade serverFacade = new ServerFacade();
                serverFacade.execute();
            }
        } catch (IOException e) {
            this.homePanel.appendLogText("");
            this.homePanel.appendLogText("##########");
            this.homePanel.appendLogText("Exception: " + e.getMessage());
            this.homePanel.appendLogText("##########");
            this.homePanel.appendLogText("");
        }
    }

    private void getIpAddresses() {
        this.homePanel.appendLogText("Getting device IPs ...");

        try {
            IpFinder publicIpFinder = new PublicIpFinder();
            IpFinder privateIpFinder = new PrivateIpFinder();

            String publicIp = publicIpFinder.find();
            String privateIp = privateIpFinder.find();

            this.inMemoryConfig.set(ConfigValue.PUBLIC_IP.getValue(), publicIp);
            this.inMemoryConfig.set(ConfigValue.PRIVATE_IP.getValue(), privateIp);

            this.homePanel.appendLogText("Private IP: " + privateIp);
            this.homePanel.appendLogText("Public IP: " + publicIp);
            this.homePanel.setIpAddresses(publicIp, privateIp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
