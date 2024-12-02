import java.util.*;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;

class RSA
{
       private BigInteger phi;
       private BigInteger p;
       private BigInteger q;
       private BigInteger N;
       private BigInteger d;
       private BigInteger e;
       private int bitlength = 1024;
       public RSA()
       {
              Random r = new Random();
              p = BigInteger.probablePrime(bitlength,r);
              q = BigInteger.probablePrime(bitlength,r);

              N = p.multiply(q);

              phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

              e = BigInteger.probablePrime(bitlength/2,r);

              while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
              {
                    e.add(BigInteger.ONE);
              }
              d = e.modInverse(phi);
       }      

       public static void main(String args[]) throws Exception
       {
               RSA rsa = new RSA();

               System.out.println("Enter the text String: ");
               Scanner in = new Scanner(System.in);

               String text;
               text = in.nextLine();
               
               System.out.println("The encrypt string is :"+text);

               System.out.println("Text string in bytes : "+ bytesToString(text.getBytes()));
               byte[] encrypted = rsa.encrypt(text.getBytes());

               System.out.println("Encrypted String to bytes : "+bytesToString(encrypted));

               byte[] decrypted = rsa.decrypt(encrypted);

               System.out.println("Decrypted String to bytes : "+bytesToString(decrypted));

               System.out.println("Decrypted String is "+ new String(decrypted));
       }

       public static String bytesToString(byte[] encrypted)
       {
              String text = "";
              for(byte b : encrypted)
              {
                   text = text + Byte.toString(b);
              }
              return text;
       }

       public byte[] encrypt(byte[] message)
       {
             return (new BigInteger(message)).modPow(e,N).toByteArray();
       }

       public byte[] decrypt(byte[] cipher)
       {
           return (new BigInteger(cipher)).modPow(d,N).toByteArray();
       }

}
