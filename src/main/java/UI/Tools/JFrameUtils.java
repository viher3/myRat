package UI.Tools;

import java.awt.*;
import javax.swing.*;

public class JFrameUtils
{
    public static JFrame setCenteredPosition(JFrame frame)
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        //Calculate the frame location
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        frame.setLocation(x, y);

        return frame;
    }
}
