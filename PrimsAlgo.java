import java.util.Scanner;
public class PrimsAlgo 
{
  void prims(int cost[][],int source,int n)
  {
      int i,j,min,totalcost=0,a=0,b=0,ecounter=0;
      int tvertex[]=new int[n];
      tvertex[source]=1;
      while (ecounter<n-1)
      {
          min=999;
          for(i=0;i<n;i++)
          {
              if(tvertex[i]==1)
              {
                  for(j=0;j<n;j++)
                  {
                      if(tvertex[j]==0&&cost[i][j]<min)
                      {
                          min=cost[i][j];
                          a=i;
                          b=j;
                      }
                  }
              }
          }
          System.out.println("the edge from"+a+"to"+b+"="+min);
          tvertex[b]=1;
          ecounter++;
          totalcost=totalcost+min;
      
      }
    System.out.println("the totalcost="+totalcost);  
  }
  public static void main(String[] args) 
  {    
      
       Scanner s=new Scanner(System.in);
       System.out.println("enter the value of n");
       int n=s.nextInt();
       int c[][]=new int[n][n];
       System.out.println("enter the cost matrix");
       for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                c[i][j]=s.nextInt();
        System.out.println("enter the source vertex");
        int source=s.nextInt();
        PrimsAlgo obj=new PrimsAlgo();
        obj.prims(c,source,n);
       
                    
           
    }
    
}