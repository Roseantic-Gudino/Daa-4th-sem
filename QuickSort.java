import java.util.*;

public class QuickSort 
{   
    static int count=0;
    int partition(int a[], int l, int r)
    {
        int pivot=a[l],temp,i=l,j=r+1;
        do
        {
            do
            {
                i++;
                count++;                
            }while(i<r && a[i]<=pivot);
            
            do
            {
                j--;
                count++;            
            }while(j>l && a[j]>=pivot);
            
            if(i<j)
            {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }while(i<j);
        temp=a[l];
        a[l]=a[j];
        a[j]=temp;
            
        return j;                     
    }
    
    void quicksort(int a[], int l, int r)
    {
        int s;
        if(l<r)
        {
            s=partition(a,l,r);
            quicksort(a,l,s-1);
            quicksort(a,s+1,r);
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        //System.out.println("Enter the array elements: ");
        Random r=new Random();
        System.out.println("\nThe array elements are: ");
        for(int i=0;i<n;i++)
        {
            a[i]=r.nextInt(100);
            System.out.print(a[i]+" ");            
        }
        
        QuickSort obj=new QuickSort();
        obj.quicksort(a, 0, n-1);
               
        System.out.println("\nThe sorted array elements are: ");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
       
        System.out.println("\nThe basic operations count is="+count); 
    }
}
