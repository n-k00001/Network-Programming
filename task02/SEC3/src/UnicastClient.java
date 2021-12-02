import java.io.IOException;
import java.net.*;
import java.net.SocketException;

public class UnicastClient implements Runnable{
    private final int port;

    public UnicastClient(int port) {
        this.port = port;
    }
    @Override
    public void run() {
        System.out.println("Unicast Client");
        try (DatagramSocket clientsocket = new DatagramSocket(port)){
            byte[] buffer = new byte[65507];
            clientsocket.setSoTimeout(3000);
            while (true)
            {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                clientsocket.receive(packet);
                String receive = new String(packet.getData());
                System.out.println(receive);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
