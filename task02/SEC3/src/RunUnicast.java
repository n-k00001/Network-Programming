import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunUnicast {
    public static void main(String[] args) {
        int port = 50001;
        UnicastServer server = new UnicastServer(port);
        UnicastClient client=new UnicastClient(port);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(server);
        executorService.submit(client);
    }
}
