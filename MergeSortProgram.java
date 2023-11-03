import java.util.*;
public class MergeSortProgram 
{
    static int count = 0;
    void Merge(int b[], int c[], int a[])
    {
        int p = b.length, q = c.length;
        int i=0,k=0,j=0;
        while(i<p && j<q)
        {   count++;
            if(b[i]<c[j])
            a[k++] = b[i++];
            else
                a[k++] = c[j++];
        }
        if(i==p)
                System.arraycopy(c,j,a,k,q-j);
        else
                System.arraycopy(b, i, a, k, p-i);
    }
    void mergesort(int a[],double n)
    {
        int p,q;
        if(n>1)
        {
            p = (int)Math.floor(n/2);
            q = (int)Math.ceil(n/2);
            int b[] = new int[p];
            int c[] = new int[q];
            System.arraycopy(a,0,b,0,p);
            System.arraycopy(a, p, c, 0, q);
            mergesort(b,p);
            mergesort(c,q);
            Merge(b,c,a);
        }
    }
    public static void main(String[]args)
    {
        int i,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size: ");
        n = sc.nextInt();
        MergeSortProgram obj = new MergeSortProgram();
        Random r = new Random();
        int a[] = new int[n];
        System.out.println("the array elements are: ");
        for(i=0;i<n;i++)
        {
            a[i] = r.nextInt(100);
            System.out.print(a[i]+" ");
        }
        obj.mergesort(a, n);
        System.out.println("the sorted array is: ");
        for(i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("the basic operation count = " + count);
    }
}