import java.io.*;
import java.util.*;
import java.net.*;

public class StringServer {
    public static void main(String[] args)throws IOException {
        
        ServerSocket socket = new ServerSocket(4200);
        System.out.println("SERVER HAS BEEN STARTED");
        Socket client = socket.accept();
        System.out.println("CLKIENT  HAS BEEN STARTED");

        
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);



        String x = in.readLine();
        System.out.println(x);
        
        out.println(x.toUpperCase());

        in.close();
        out.close();
        client.close();
        socket.close();



    }
}
