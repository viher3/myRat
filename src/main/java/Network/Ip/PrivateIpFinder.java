package Network.Ip;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class PrivateIpFinder implements IpFinder {
    @Override
    public String find() {
        String ip = "";

        try(final DatagramSocket socket = new DatagramSocket()){
            try {
                socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            ip = socket.getLocalAddress().getHostAddress();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return ip;
    }
}
