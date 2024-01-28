import Config.ConfigReader;
import Config.ConfigValue;
import UI.HomePanel;
import Network.Ip.IpFinder;

import java.io.IOException;

import Network.Ip.PublicIpFinder;
import Network.Ip.PrivateIpFinder;

public class Home {

    private HomePanel panel;

    public void init() {
        ConfigReader config;
        this.panel = new HomePanel();
        this.panel.open();

        try {
            config = ConfigReader.getInstance();
        } catch (IOException e) {
            this.panel.appendLogText(e.getMessage());
            throw new RuntimeException(e);
        }

        this.panel.appendLogText("Client version " . concat(config.get(ConfigValue.APP_VERSION.getValue())));
        this.panel.appendLogText("Getting device IPs ...");
        this.getIpAddresses();
        this.panel.appendLogText("Sending signal to main server ...");
    }

    private void getIpAddresses() {
        try {
            IpFinder publicIpFinder = new PublicIpFinder();
            IpFinder privateIpFinder = new PrivateIpFinder();

            String publicIp = publicIpFinder.find();
            String privateIp = privateIpFinder.find();

            this.panel.appendLogText("Private IP: " + privateIp);
            this.panel.appendLogText("Public IP: " + publicIp);
            this.panel.setIpAddresses(publicIp, privateIp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
