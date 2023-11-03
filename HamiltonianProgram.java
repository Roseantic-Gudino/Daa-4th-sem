import java.util.Scanner;
public class HamiltonianProgram 
{
    static int a[][], n , source;
    
    static void Hamiltonian(int st, int succ[], int count)
    {
        if ( count==n && a[st][source]==1 )
        {
            path(succ);
            return;
        }
        
        int temp[]=new int[n];
        for (int i=0; i<n; i++)
        {
            if ((a[st][i]==1) && (succ[i]==-1))
            {
                succ[st] = i;
                System.arraycopy(succ, 0, temp,0 ,n);
                Hamiltonian(i, temp, count+1);
            }
        }
    }
    
    static void path(int s[])
    {
        //System.out.print("\nThe path is ");
        System.out.print(source+" -> ");
        for (int i=s[source]; i!=-1; i=s[i])
            System.out.print(i+" -> ");
        
        System.out.print(source);
        System.out.println();
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter no.of vertices: ");
        n = sc.nextInt();
        
        a = new int[n][n];
        
        int succ[] = new int[n];
        for (int i=0;i<n;i++)
            succ[i] = -1;
        
        System.out.println("Enter the adjacency matrix: ");
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                a[i][j]= sc.nextInt();
        
                
        System.out.println("Enter source: ");
        source = sc.nextInt();
        
        Hamiltonian(source,succ,1);
        
        
    }
}
