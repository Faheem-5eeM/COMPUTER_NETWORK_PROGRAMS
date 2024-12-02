import java.util.Scanner;
import java.util.*;
import java.net.*;

class Client 
{
       public static void main(String [] args) throws Exception
       {
                 DatagramSocket ClientSocket = new DatagramSocket();

                 InetAddress IPaddress = InetAddress.getByName("localhost");

                 byte[] sendData = new byte[1024];
                 byte[] receiveData = new byte[1024];
                 
                 System.out.println("Enter start to connect to Server: ");
                 Scanner s = new Scanner(System.in);
                 String Srt = s.nextLine();
                 sendData = Srt.getBytes();
                 
                 DatagramPacket SendPacket = new DatagramPacket(sendData,sendData.length,IPaddress,1234);
                 ClientSocket.send(SendPacket);

                 DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                 ClientSocket.receive(receivePacket);

                 String ModifiedSentence = new String(receivePacket.getData());

                 System.out.println("Received Message is : "+ ModifiedSentence);
                 ClientSocket.close();

       }
}
