import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class MulticastServer {
    public static void main(String[] args) {
        System.out.println("Multicast Time Server");
        DatagramSocket sc = null;
        try {
            sc = new DatagramSocket();
            while (true) {

                String data = new Date().toString();
                byte[] buffer = new byte[256];
                buffer = data.getBytes();
                InetAddress group = InetAddress.getByName("224.0.0.0");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 8888);
                sc.send(packet);
                System.out.println("Time Sent : "+data);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
