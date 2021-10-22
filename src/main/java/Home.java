import UI.HomePanel;
import Network.Ip.IpFinder;
import java.io.IOException;
import Network.Ip.PublicIpFinder;
import Network.Ip.PrivateIpFinder;
import UI.Tools.JFrameUtils;

import javax.swing.*;

public class Home {

    private HomePanel panel;

    public void init()
    {
        this.panel = new HomePanel();
        JFrame frame = new JFrame("myRat");
        frame.setContentPane(this.panel.window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame = JFrameUtils.setCenteredPosition(frame);
        frame.pack();
        frame.setVisible(true);

        this.panel.appendLogText("Getting device IPs ...");
    }

    private void getIpAddresses()
    {
        try {
            IpFinder publicIpFinder = new PublicIpFinder();
            IpFinder privateIpFinder = new PrivateIpFinder();

            String publicIp = publicIpFinder.find();
            String privateIp = privateIpFinder.find();

            System.out.println("My public IP is: " + publicIp);
            System.out.println("My private IP is: " + privateIp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
