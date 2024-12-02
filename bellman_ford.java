import java.util.Scanner;
class bellman_ford 
{
       int dist[];
       int n;
       public static final int MAX_VALUE = 999;
       public bellman_ford(int n)
       {
           this.n = n;
           dist = new int[n+1];
       }
       public void bellman_ford_eval(int source,int adj[][])
       {
               for(int i=1;i<=n;i++)
               {
                    dist[i] = MAX_VALUE;
               }
                
              dist[source] = 0;
               for(int i=1;i<=n-1;i++)
               {
                   for(int j=1;j<=n;j++)
                   {
                       for(int k=1;k<=n;k++)
                       {
                           if(adj[j][k] != MAX_VALUE)
                           {
                               if(dist[k] > dist[j]+adj[j][k])
                               {
                                     dist[k] = dist[j] + adj[j][k];
                               }
                           }
                       }
                   }
               }

               for(int i=1;i<=n;i++)
               {
                   for(int j=1;j<=n;j++)
                   {
                       if(adj[i][j] != MAX_VALUE)
                       {
                           if(dist[j] > dist[i]+adj[i][j])
                           {
                                System.out.println("\nThe graph contains Negative elements");
                           }
                       }
                   }
               }


               for(int i=1;i<=n;i++)
               {
                    System.out.println("Distance from source "+source+" to vertex "+i+" is : "+dist[i]);
               }
       }


       public static void main(String[] args)
       {
            int n;
            int source;
            int adj[][];
            Scanner s = new Scanner(System.in);
            System.out.println("Enter no of vertices : ");
            n = s.nextInt();

            adj = new int[n+1][n+1];

            System.out.println("Enter the Adjacency Matrix elements : ");
            for(int i=1;i<=n;i++)
            {
                 for(int j=1;j<=n;j++)
                 {
                      adj[i][j] = s.nextInt();
                      if(i == j)
                      {
                        adj[i][j] = 0;
                        continue;
                      }
                      if(adj[i][j] == 0)
                      {
                           adj[i][j] = MAX_VALUE;
                      }
                 }
            }

            System.out.println("Enetr the source element : ");
            source = s.nextInt();

            bellman_ford bel = new bellman_ford(n);
            bel.bellman_ford_eval(source,adj);
       }
}
