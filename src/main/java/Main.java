import UI.HomePanel;
import UI.Tools.JFrameUtils;

import javax.swing.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("myRat");
        frame.setContentPane(new HomePanel().window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame = JFrameUtils.setCenteredPosition(frame);
        frame.pack();
        frame.setVisible(true);
    }
}
