package Application.Setup;

import Config.ConfigReader;
import Config.ConfigValue;
import Network.Ip.IpFinder;
import Network.Ip.PrivateIpFinder;
import Network.Ip.PublicIpFinder;
import UI.HomePanel;

import java.awt.*;
import java.io.IOException;

public class SetupFacade {

    private final HomePanel homePanel;
    private ConfigReader config;

    public SetupFacade(HomePanel homePanel) throws IOException {
        this.config = ConfigReader.getInstance();
        this.homePanel = homePanel;
    }

    public void execute(){
        this.homePanel.appendLogText("Client version " . concat(config.get(ConfigValue.APP_VERSION.getValue())));
        this.getIpAddresses();
        this.checkAppMode();
        //this.homePanel.appendLogText("Sending signal to main server ...");
    }

    private void checkAppMode()
    {
        String appMode = this.config.get("APP_MODE").toUpperCase();

        if(appMode.equals("CLIENT")){
            this.homePanel.appendLogText("App mode: CLIENT");
        }else if(appMode.equals("SERVER")){
            this.homePanel.appendLogText("App mode: SERVER");
        }
    }

    private void getIpAddresses() {
        this.homePanel.appendLogText("Getting device IPs ...");

        try {
            IpFinder publicIpFinder = new PublicIpFinder();
            IpFinder privateIpFinder = new PrivateIpFinder();

            String publicIp = publicIpFinder.find();
            String privateIp = privateIpFinder.find();

            this.homePanel.appendLogText("Private IP: " + privateIp);
            this.homePanel.appendLogText("Public IP: " + publicIp);
            this.homePanel.setIpAddresses(publicIp, privateIp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
