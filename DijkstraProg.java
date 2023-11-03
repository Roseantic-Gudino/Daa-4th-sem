import java.util.Scanner;
public class DijkstraProg {
    void dijkstras(int source, int cost[][],int n)
    {
        int min,u = 0,v;
        int tvertex[] = new int[n];
        int dist[] = new int[n];
        System.arraycopy(cost[source], 0, dist, 0, n);
        tvertex[source] = 1;
        dist[source] = 0;
        for(int count = 0;count<n;count++)
        {
            min = 999;
            for(int i=0;i<n;i++)
            {
                if(tvertex[i] == 0 && dist[i]<min)
                {
                    min = dist[i];
                    u = i;
                }
            }
            tvertex[u] = 1;
            for(v=0;v<n;v++)
            {
                if(tvertex[v] == 0 && cost[u][v]!=999 )
                {
                    if(dist[v]>(dist[u]+cost[u][v]))
                        dist[v] = dist[u] + cost[u][v];
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("the shortest path from "+source+ " to "+i+" vertex is"+dist[i]);
        }
    }
    public static void main(String[]args)
    {
        int n , i,j,source;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter the number of vertices: ");
        n = sc.nextInt();
        int cost[][] = new int[n][n];
        System.out.println("enter th cost matrix: ");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
                cost[i][j] = sc.nextInt();
        }
        System.out.println("Enter the source ");
        source = sc.nextInt();
        DijkstraProg obj = new DijkstraProg();
        obj.dijkstras(source, cost, n);
    }
}