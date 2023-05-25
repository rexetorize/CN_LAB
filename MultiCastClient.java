import java.io.*;
import java.net.*;
import java.util.Date;


public class MultiCastClient {
    public static void main(String[] args)throws IOException {
        
        MulticastSocket socket = new MulticastSocket(4200);
        InetAddress address = InetAddress.getByName("235.12.36.11");


        socket.joinGroup(address);

        for(int i = 0; i < 10; i++){
           
            byte buffer[] = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            socket.receive(packet);
            String x = new String(packet.getData());
           System.out.println(x);


        }

        socket.close();
    }
}
