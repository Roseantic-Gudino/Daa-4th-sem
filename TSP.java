import java.util.*;

public class TSP 
{
    static int cost[][], n;
    static int g(int i,int s[])
    {
        int temp[] = new int[n];
        int path[] = new int[n];
        int minval = 999, flag=0, val;
        s[i] = 1;
        int j;
        for(j=0 ; j< n; j++)
        {
            if( j != i && s[j] == 0)
            {
                flag=1;
                System.arraycopy(s, 0, temp, 0, n);
                val = cost[i][j] + g(j,temp);
                
                if (val < minval)
                {
                    minval = val;
                    System.arraycopy(temp, 0 , path, 0,n);
                    path[i] = j;
                }
            }
        }
        if (flag == 0)
            minval = cost[i][0];
        System.arraycopy(path, 0, s, 0, n);
        return minval;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter no of vertices: ");
         n = sc.nextInt();
        
        int s[] = new int[n];
        cost = new int[n][n];
        
        System.out.println("Enter the cost matrix: ");
        
        for(int i=0 ; i< n; i++)
            for(int j=0; j<n; j++)
                cost[i][j] = sc.nextInt();
          
        System.out.println("Total trip cost is " + g(0,s));
        System.out.print("0 -> ");
        for(int i= s[0] ; i != 0; i = s[i])
            System.out.print(i + " -> ");
        System.out.print("0");
    }
}
