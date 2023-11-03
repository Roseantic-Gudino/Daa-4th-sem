import java.util.*;
public class KruskalProgram 
{
    void Kruskal(int cost[][],int n)
    {
        int i,j,a=0,b=0,u=0,v=0,min,totalcost=0,ecounter=0;
        int par[] = new int[n];
        for(i=0;i<n;i++)
            par[i] = -1;
        while(ecounter<n-1)
        {
            min = 999;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    if(cost[i][j] <min)
                    {
                        min = cost[i][j];
                        a=u=i;
                        b=v=j;
                    }
                }
            }
            while(par[u]!= -1)
                u = par[u];
            while(par[v] != -1)
                v = par[v];
            if(u != v)
            {
               System.out.println("the edge from "+a+" to "+b+" is selected  with edge cost of "+min);
               ecounter++;
               if (par[b]==-1)
                   par[b]=a;
               else
                  par[a]=b;
               totalcost = totalcost+min;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.println("the minimum cost is: "+totalcost);
    }
    public static void main(String[]args)
    {
        int i,j,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size: ");
        n = sc.nextInt();
        KruskalProgram obj = new KruskalProgram();
        int cost[][] = new int[n][n];
        System.out.println("enter the cost matrix: ");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                cost[i][j] = sc.nextInt();
            }
        }
        obj.Kruskal(cost, n);
    }
}