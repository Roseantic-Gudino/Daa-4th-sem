import java.util.Scanner;
public class GreedyKS {
    void greedyknapsack(int n, int u, float p[], float w[])
    {
        int i,j,k = 0;
        float profit = 0, max;
        for(i=0;i<n;i++)
        {
            if(u!=0)
            {
                max = 0;
                for(j=0;j<n;j++)
                {
                    if((p[j]/w[j])>max)
                    {
                        max = p[j]/w[j];
                        k = j;
                    }
                }
                if(w[k]<=u)
                {
                   System.out.println(k+" item is selcted with fraction 1");
                   profit = profit + p[k];
                   u = (int)(u-w[k]);
                   p[k] = 0;
                }
                else
                {
                    System.out.println("Item"+k+"is selected with fraction "+(u/w[k]));
                    profit = profit + (p[k]*(u/w[k]));
                    break;
                }
            }
        }
        System.out.println("the optimal profit is "+ profit);
    }
    public static void main(String[] args) {
        int n,i,j,u;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of items : ");
        n = sc.nextInt();
        System.out.println("enter the knapsack capacity : ");
        u = sc.nextInt();
        float p[] = new float[n];
        float w[] = new float[n];
        System.out.println("enter the weights : ");
        for(i=0;i<n;i++)
            w[i] = sc.nextFloat();
        System.out.println("enter the profits : ");
        for(j=0;j<n;j++)
            p[j] = sc.nextFloat();
        GreedyKS obj = new GreedyKS();
        obj.greedyknapsack(n, u, p, w);
    }
}