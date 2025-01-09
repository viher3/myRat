import Application.Setup.SetupFacade;
import Network.Socket.Exception.ClientConnectionException;
import UI.HomePanel;
import java.io.IOException;

public class Home {

    private HomePanel panel;

    public void init() {
        this.panel = new HomePanel();
        this.panel.open();

        try {
            SetupFacade setupFacade = new SetupFacade(this.panel);
            setupFacade.execute();
        } catch (IOException e) {
            this.panel.appendLogText(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
