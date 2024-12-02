import java.util.Scanner;
class crc
{
       public static void main(String args[])
       {
               int n,m;
               Scanner s = new Scanner(System.in);
               System.out.println("Enter no of data bit :");
               n = s.nextInt();
               System.out.println("Enter no of generator bit : ");
               m = s.nextInt();
               int d[] = new int[n+m];
               int g[] = new int[m];

               System.out.println("Enter the data bits : ");
               for(int i=0;i<n;i++)
               {
                   d[i] = s.nextInt();
               }   
                  
               System.out.println("Enter the generator bits : ");
               for(int i=0;i<m;i++)
               {
                   g[i] = s.nextInt();
               }

               for(int i=1;i<m;i++)
               {
                  d[n+i] = 0; 
               }

               int r[] = new int[m+n];
               int z[] = new int[m+n];

               for(int i=0;i<m;i++)
               {
                   r[i] = d[i];
               }

               for(int i=0;i<m;i++)
               {
                   z[i] = 0;
               }

               for(int i=0;i<n;i++)
               {
                    int k = 0;
                    int msb = r[i];
                    for(int j=i;j<m+i;j++)
                    {
                         if(msb == 0)
                           r[i] = xor(r[j],z[k]);
                        else
                           r[j] = xor(r[j],z[k]);
                        
                        k++;
                    }
               }
              
               System.out.println("\nThe code bit added is : ");
               for(int i=n;i<m+n-1;i++)
               {
                   d[i] = r[i];
                   System.out.print(d[i]);
               }
               System.out.println("\nThe code data is : ");
               for(int i=0;i<m+n-1;i++)
               {
                   System.out.print(d[i]+" ");
               }
       }
       public static int xor(int x,int y)
               {
                    if(x==y)
                      return 0;
                    else 
                      return 1;
               }
}