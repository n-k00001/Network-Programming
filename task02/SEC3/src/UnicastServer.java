import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UnicastServer implements Runnable{
    private final int clientport;

    public UnicastServer(int clientport) {
        this.clientport = clientport;
    }

    @Override
    public void run() {
        System.out.println("Unicast Server");
        try (DatagramSocket serversockect=new DatagramSocket(50000)){
            for (int i=0;i<3;i++)
            {
                String message = "Message Number "+i;
                byte[] buffer = new byte[65507];
                buffer=message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(),clientport);
                serversockect.send(packet);
            }
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
