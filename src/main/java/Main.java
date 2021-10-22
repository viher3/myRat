import Network.Ip.PrivateIpFinder;
import UI.HomePanel;
import Network.Ip.IpFinder;
import UI.Tools.JFrameUtils;
import Network.Ip.PublicIpFinder;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("myRat");
        frame.setContentPane(new HomePanel().window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame = JFrameUtils.setCenteredPosition(frame);
        frame.pack();
        frame.setVisible(true);

        Main main = new Main();
        main.onInit();
    }

    protected void onInit()
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
