import java.util.*;
import java.net.*;
import java.util.Scanner;

class Server
{
       public static void main(String [] args) throws Exception
       {
               DatagramSocket serverSocket = new DatagramSocket(1234);
               System.out.println("Server Started.");
               byte[] sendData = new byte[1024];
               byte[] receiveData = new byte[1024];
               
               DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
               serverSocket.receive(receivePacket);
               receivePacket.getData();
               InetAddress IPaddress = receivePacket.getAddress();
               int port = receivePacket.getPort();

               System.out.println("Connected to client");
               
               System.out.println("Enter the message: ");
               Scanner s = new Scanner(System.in);
               String message = s.nextLine();
               sendData = message.getBytes();

               DatagramPacket sendPacket =  new DatagramPacket(sendData,sendData.length,IPaddress,port);
               serverSocket.send(sendPacket);
               System.exit(0);
       }
}
