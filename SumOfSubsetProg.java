import java.util.Scanner;
public class SumOfSubsetProg 
{
    static int x[],w[],d,count;
    static void SumOfSubset(int s, int k, int rem)
    {
        x[k]=1;
        if (s+w[k] == d)
        {
            count++;
            System.out.print("Subset "+ count+ " = ");
            for (int i=0;i<=k; i++)
            {
                if (x[i] == 1)
                    System.out.print(w[i]+" ");
            }
            System.out.println();
            return;
        }
        
        if (s+w[k]+w[k+1] <= d)
            SumOfSubset(s+w[k], k+1, rem-w[k]);
        if (s+rem-w[k] >= d && s+w[k+1] <= d)
        {
            x[k]=0;
            SumOfSubset(s, k+1, rem-w[k]);
        }
       
    }
    
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int sum=0, i;
        System.out.println("Enter no. of elements in the set: ");
        int n=sc.nextInt();
        w = new int[n];
        x = new int[n];
        
        System.out.println("Enter elements of set W: ");
        for( i=0; i<n; i++)
        {
            w[i] = sc.nextInt();
            sum = sum+w[i];
        }
        
        System.out.print("Enter the d value: ");
        d = sc.nextInt();
        
        if (sum < d || w[0] > d)
        {
            System.out.println("Invalid input/no solution.");
            System.exit(0);
        }
        
        SumOfSubset(0,0,sum);
        if(count == 0)
            System.out.println("No subset can be found");
    }
    
}
