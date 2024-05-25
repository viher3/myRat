package UI;

import UI.Tools.JFrameUtils;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HomePanel {
    public JPanel window;
    private JTabbedPane tabbedPane1;
    private JTextArea logTextarea;
    private JLabel ipAddresses;
    private JTextPane commandTextPane;

    private void createUIComponents() { }

    public void open() {
        JFrame frame = new JFrame("myRat");
        frame.setContentPane(this.window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame = JFrameUtils.setCenteredPosition(frame);
        frame.pack();
        frame.setVisible(true);

        commandTextPane.setText("Enter your command here ...");
        commandTextPane.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    System.out.println("HIZO ENTER!!");
                }
            }
        });

    }

    public void appendLogText(String text) {
        this.logTextarea.append(text + "\n");
    }

    public void setIpAddresses(String pub, String priv) {
        this.ipAddresses.setText("Private IP: " + priv + " | Public IP: " + pub);
    }
}
