import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    private static InetAddress host;
    private static final int port = 1234;

    public static void main(String[] args) {
        try {
            host = InetAddress.getLocalHost();
        } catch (IOException var2) {
            System.out.println("Cannot found Host ID");
            System.exit(1);
        }

        accessconecction();
    }

    private static void accessconecction() {
        Socket socket = null;

        try {
            socket = new Socket(host, port);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner userin = new Scanner(System.in);
            System.out.println("Enter UserName : ");
            String username = userin.nextLine();
            out.println(username);
            System.out.println("Enter Pass : ");
            String pass = userin.nextLine();
            out.println(pass);
            String rep;
            rep= in.nextLine();
            System.out.println(rep);
            while (!rep.equals("SUCCESSFUL LOGIN")&&!username.equals("close")) {
                System.out.println("\n:) Try Again\n*********************************************\n");
                System.out.println("Enter UserName : ");
                username = userin.nextLine();
                out.println(username);
                System.out.println("Enter Pass : ");
                pass = userin.nextLine();
                out.println(pass);
                rep= in.nextLine();
                System.out.println(rep);
                if (rep.equals("SUCCESSFUL LOGIN")) {
                    String msg;
                    do {
                        System.out.println("Enter Message : ");
                        msg = userin.nextLine();
                        out.println(msg);
                    } while (!msg.equals("exit"));
                }
            }
        } catch (IOException var16) {
            var16.printStackTrace();
        } finally {
            try {
                System.out.println("Conecction  is closing......");
                socket.close();
                System.exit(1);
            } catch (IOException var15) {
                System.out.println("Cannot Close Connection");
                System.exit(1);
            }

        }

    }
}
