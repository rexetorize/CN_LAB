import java.io.*;
import java.util.*;
import java.net.*;


public class StringClient {
    public static void main(String[] args)throws IOException {
        
        Socket socket = new Socket("127.0.0.1", 4200);


        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("hello");
        String x = in.readLine();

        System.out.println(x);

        in.close();
        out.close();
        socket.close();
    }
}
