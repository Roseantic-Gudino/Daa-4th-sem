
import java.util.Scanner;

public class APSP 
{
    void floyds( int D[][], int n)
    {
        int i,j,k;
        for(k=0;k<n;k++)
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                    D[i][j]= min(D[i][j], D[i][k]+ D[k][j]);
    }
    int min(int a, int b)
    {
        return ((a<b)?a:b);
    }
    
    public static void main(String args[])
    {
        int n,i,j;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of elements: ");
        n=sc.nextInt();
        int cost[][]=new int[n][n];
        System.out.println("Enter cost matrix: ");
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                cost[i][j]= sc.nextInt();
        APSP obj=new APSP();
        obj.floyds(cost, n);
        System.out.println("The all pair shortest path is");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
                System.out.print(cost[i][j]+ " ");
            System.out.println();
        }
    }
}
