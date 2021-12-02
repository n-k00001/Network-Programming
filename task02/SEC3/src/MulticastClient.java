import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class MulticastClient {
    public static void main(String[] args) {
       System.out.println("Multicast Time Client");
       try (MulticastSocket socket = new MulticastSocket(8888)){
           InetAddress group = InetAddress.getByName("224.0.0.0");
           socket.joinGroup(group);
           byte[] buffer = new byte[256];
           System.out.println("Multicast Group Joined");
           DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
           for (int i=0 ;i<5;i++)
           {
               socket.receive(packet);
               String recieve = new String(packet.getData());
               System.out.println(recieve.trim());
           }
           socket.leaveGroup(group);
       }catch (IOException e)
       {
           e.printStackTrace();
       }
       System.out.println("Multicast Time Client Terminated");
    }
}
