import java.net.*;
import java.io.*;
class TCPC
{
          public static void main(String[] args)throws Exception
          {
                Socket sock = new Socket("127.0.01",4000);
                System.out.println("Enter the filename");

                BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                String fname = keyRead.readLine();

                InputStream istream = sock.getInputStream();
                OutputStream ostream = sock.getOutputStream();

                PrintWriter pwrite = new PrintWriter(ostream,true);
                pwrite.println(fname);
                
                BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
                String str;

                while((str = socketRead.readLine())!=null){
                  System.out.println(str);
                }
                
                pwrite.close();
                socketRead.close();
                keyRead.close();
          }
}