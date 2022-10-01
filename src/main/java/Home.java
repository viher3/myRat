import UI.HomePanel;
import Network.Ip.IpFinder;
import java.io.IOException;
import Network.Ip.PublicIpFinder;
import Network.Ip.PrivateIpFinder;

public class Home {

    private HomePanel panel;

    public void init()
    {
        this.panel = new HomePanel();
        this.panel.open();

        this.panel.appendLogText("Getting device IPs ...");
        this.getIpAddresses();
    }

    private void getIpAddresses()
    {
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
