import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args)throws IOException {
        
        ServerSocket socket = new ServerSocket(7);

        Socket clientSocket = socket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String x = in.readLine();
        out.println(x);

        in.close();
        out.close();
        clientSocket.close();
        socket.close();
    }
}
