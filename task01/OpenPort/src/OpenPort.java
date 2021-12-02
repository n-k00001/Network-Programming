import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class OpenPort {
    public static void main(String[] args)  {
        Socket socket = new Socket();
        boolean isopen;
        for (int port = 0; port < 65536; port++)
        {
            isopen=true;
            try {
                socket=new Socket("localhost",port);
            }catch (IOException e){
                isopen=false;
            }finally {
                try {
                    socket.close();
                }catch (IOException ex)
                {

                }
            }
            if (isopen){
                System.out.println("Port "+port+" is open");
            }
        }
    }
}
