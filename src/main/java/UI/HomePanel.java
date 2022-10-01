package UI;

import UI.Tools.JFrameUtils;
import javax.swing.*;

public class HomePanel {
    public JPanel window;
    private JTabbedPane tabbedPane1;
    private JTextArea logTextarea;
    private JLabel ipAddresses;

    private void createUIComponents() { }

    public void open() {
        JFrame frame = new JFrame("myRat");
        frame.setContentPane(this.window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame = JFrameUtils.setCenteredPosition(frame);
        frame.pack();
        frame.setVisible(true);
    }

    public void appendLogText(String text) {
        this.logTextarea.append(text + "\n");
    }

    public void setIpAddresses(String pub, String priv) {
        this.ipAddresses.setText("Private IP: " + priv + " | Public IP: " + pub);
    }
}
