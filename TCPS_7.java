import java.net.*;
import java.io.*;
class TCPS
{
	public static void main(String[] args) throws Exception
	{
				ServerSocket sersock = new ServerSocket(4000);
				System.out.println("Server ready for connection");

				Socket sock = sersock.accept();
				System.out.println("Connection is successful and waiting for chatting");

				InputStream istream = sock.getInputStream();
				OutputStream ostream = sock.getOutputStream();

				BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
				String fname = fileRead.readLine();
				BufferedReader ContentRead = new BufferedReader(new FileReader(fname));
				
				PrintWriter pwrite = new PrintWriter(ostream,true);
				String str;
				while((str = ContentRead.readLine())!=null)
				{
				    	pwrite.println(str);
				}
				sock.close();
				sersock.close();
				pwrite.close();
				fileRead.close();
				ContentRead.close();
	}
}