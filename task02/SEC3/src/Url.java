import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
public class Url {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter URL : ");
        String url = in.nextLine();
        accessweb(url);

    }
    private static void accessweb(String url)
    {
        File f = new File("C://Users//nooor//OneDrive//Desktop//test.html");
        BufferedReader br = null;
        BufferedWriter bw=null;
        try {
            URL weburl = new URL(url);
            URLConnection urlConnection = weburl.openConnection();
            InputStream is = urlConnection.getInputStream();
            OutputStream os = new FileOutputStream(f);
            int data;
            while ((data= is.read())!= -1)
            {
                os.write(data);
            }
            is.close();
            os.close();
        }
        catch (IOException e) {
            System.out.println("Cannot access URL");
            System.exit(1);
        }
        finally {
            System.out.println("CLOSING CONNECTION");
        }
    }
}

