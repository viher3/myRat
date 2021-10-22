package UI;

import javax.swing.*;

public class HomePanel {
    public JPanel window;
    private JTabbedPane tabbedPane1;
    private JTextArea logTextarea;
    private JLabel ipAddresses;

    private void createUIComponents()
    {

    }

    public void appendLogText(String text)
    {
        this.logTextarea.append(text + "\n");
    }

    public void setIpAddresses(String pub, String priv)
    {
        this.ipAddresses.setText("Private IP: " + priv + " | Public IP: " + pub);
    }
}
