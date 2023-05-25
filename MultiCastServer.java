import java.io.*;
import java.net.*;
import java.util.Date;

public class MultiCastServer {
    
    public static void main(String[] args)throws IOException, InterruptedException {
        DatagramSocket socket = new DatagramSocket(1313);

        Date date = new Date();
        String X = date.toString();
        System.out.println(date);

        for(int i = 0; i < 50; i++) {

            byte buffer[] = X.getBytes();
            InetAddress address = InetAddress.getByName("235.12.36.11");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4200);

            socket.send(packet);

            Thread.sleep(1000);
        }

        socket.close();

    }
}
