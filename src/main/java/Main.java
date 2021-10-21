import UI.HomePanel;
import Network.Ip.IpFinder;
import UI.Tools.JFrameUtils;
import Network.Ip.PublicIpFinder;

import javax.swing.*;

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
        IpFinder publicIpFinder = new PublicIpFinder();
        System.out.println("My public IP is: " + publicIpFinder.find());
    }
}
