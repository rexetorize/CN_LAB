import java.io.*;
import java.net.*;


public class DateServer{
    public static void main(String[] args) throws IOException {
        
        ServerSocket socket = new ServerSocket(1313);

        Socket clientSocket = socket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), false);

        
        out.println("MAY");

        out.close();
        in.close();
        clientSocket.close();
        socket.close();
    }
}