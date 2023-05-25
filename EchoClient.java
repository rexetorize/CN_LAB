import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args)throws IOException {
        
        Socket socket = new Socket("127.0.0.1", Integer.parseInt(args[1]));

        String x = args[0];
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Echoed to the server : "+x);
        out.println(x);
        System.out.println();
        System.out.println("ECHO BACK : " + in.readLine());

        in.close();
        out.close();
        socket.close();

    
    }
}
