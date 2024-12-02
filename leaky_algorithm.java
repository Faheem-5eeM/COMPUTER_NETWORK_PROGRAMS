import java.util.Scanner;
class leaky_algorithm 
{ 
       public static void main(String[] args)
       {
             int n;
             Scanner s = new Scanner(System.in);
             System.out.println("Enter the bucket size: ");
             n = s.nextInt();
             int num;
             System.out.println("Enter No of packets: ");
             num = s.nextInt();

             int a[] = new int[n];
             System.out.println("Enter each packet size: ");
             for(int i=0;i<num;i++)
             {
                  System.out.println("Enter packet size for : "+(i+1));
                  a[i] = s.nextInt();
             }

             System.out.println("Enter the Output rate: ");
             int out = s.nextInt();

             System.out.println("******Applying Leaky Algorithm******");
             for(int i=0;i<num;i++)
             {
                   if(a[i]>n)
                   {
                        System.out.println("Bucket Overflow : "+a[i]);
                   }
                   else
                   {
                        if(a[i] == out)
                        {
                             System.out.println("Packet Transmitted : "+a[i]);
                        }
                        else if(a[i]>out)
                        { 
                              while(a[i]!=0 && a[i]>out)
                              {
                                   System.out.println("Packet transmitted : "+out);
                                   a[i]  = a[i] - out;
                              }   
                              System.out.println("Packet Transmistted : "+a[i]);
                        }
                   }
             }
       }
}
