import java.io.*;
import java.net.*;

public class DateClient {
    public static void main(String[] args)throws IOException {
        
        Socket client = new Socket("127.0.0.1", 1313);

      
            BufferedReader in = new BufferedReader( new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            

            String x = in.readLine();
            System.out.println("recived from server");

            System.out.print(x);
       
            in.close();
            out.close();
            client.close();
    }
}
