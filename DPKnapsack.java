
import java.util.Scanner;


public class DPKnapsack 
{
    void Knapsack(int n, int m, int w[], int p[])
    {
        int v[][]=new int[n+1][m+1];
        int i,j;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=m;j++)
            {
                if (j<w[i])
                    v[i][j]=v[i-1][j];
                else
                    v[i][j]= max(v[i-1][j], p[i]+ v[i-1][j-w[i]]);
                System.out.print(v[i][j]+"\t");
            }
            System.out.println();
        } 
        System.out.println("Optimal profit = "+ v[n][m]);
        
        while(m>0)
        {
            if (v[n][m]!= v[n-1][m])
            {
                System.out.println("Item "+n+ " is selected");
                m=m-w[n];
            }
            n--;
        }
    }
    
    int max(int a, int b)
    {
        return ((a>b)?a:b);
    }
    
    public static void main(String args[])
    {
        int n,m,i;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of items: ");
        n=sc.nextInt();
        System.out.println("Enter knapsack capacity: ");
        m=sc.nextInt();
        
        int p[]=new int[n+1];
        int w[]=new int[n+1];
        System.out.println("Enter the profits: ");
        for(i=1;i<=n;i++)
            p[i]=sc.nextInt();
        System.out.println("Enter the weights: ");
        for(i=1;i<=n;i++)
            w[i]=sc.nextInt();
        
        DPKnapsack obj=new DPKnapsack();
        obj.Knapsack(n, m, w, p);
    }
}
