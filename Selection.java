import java.util.*;
public class Selection 
{
    void selectionsort(int a[],int n)
    {
        int i,count=0,j,pos,temp;
        for(i=0;i<n-2;i++)
        {
            pos=i;
            for(j=i+1;j<=n-1;j++)
            {
                count++;
                if(a[j]<a[pos])
                    pos = j;
            }
            if(pos != i)
            {
                temp = a[i];
                a[i] = a[pos];
                a[pos] = temp;
            }
        }
        System.out.println("basic operation count is:"+count);
    }
    public static void main(String[] args) {
       int i,n;
       Scanner sc = new Scanner(System.in);
       System.out.println("enter the size of the array: ");
       n = sc.nextInt();
       Selection obj = new Selection();
       int a[] = new int[n];
       Random r = new Random();
       System.out.println("the array elemeents are: ");
       for(i=0;i<n;i++)
       {
           a[i] = r.nextInt(100);
       }
       for(i=0;i<n;i++)
           System.out.print(a[i]+" ");
       obj.selectionsort(a, n);
       System.out.print(" the sorted array is : ");
       for(i=0;i<n;i++)
           System.out.print(a[i]+" ");
    }
    
}