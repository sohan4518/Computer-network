package bellmandemofinal;
import java.util.Scanner;
public class BellmanDemoFinal {
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        int V,e=1,cheknegative=0;
        int w[][]=new int[20][20];
        int edge[][]=new int[50][50];
        System.out.println("Enter the number of vertices:");
        V=in.nextInt();
        System.out.println("Enter the weight matrix:");
        for(int i=1;i<=V;i++)
            for(int j=1;j<=V;j++){
                w[i][j]=in.nextInt();
                if(w[i][j]!=0)
                {
                    edge[e][0]=i;
                    edge[e++][1]=j;
                    
                }
            }
        cheknegative=bellmanford(w,V,e,edge);
        if(cheknegative==1)
            System.out.println("\n No negative weight cycle\n");
        else
            System.out.println("\n Negative weight cycle exists\n");
      
    }
    public static int bellmanford(int w[][],int V,int e,int edge[][]){
        int u,v,s,flag=1;
        int distance[]=new int[20];
        int parent[]=new int[20];
        for(int i=1;i<=V;i++){
            distance[i]=999;
            parent[i]=-1;
            
        }
        System.out.println("Enter the source vertex:");
        s=in.nextInt();
        distance[s]=0;
        for(int i=1;i<=V-1;i++)
        {
            for(int k=1;k<=e;k++)
            {
                u=edge[k][0];
                v=edge[k][1];
                if(distance[u]+w[u][v]<distance[v])
                {
                    distance[v]=distance[u]+w[u][v];
                    parent[v]=u;
                }
            }
        }
         for(int k=1;k<=e;k++)
            {
                u=edge[k][0];
                v=edge[k][1];
                if(distance[u]+w[u][v]<distance[v])
                   flag=0;
            }
         if(flag==1)
             for(int i=1;i<=V;i++)
                 System.out.println("Vertex"+i+"->cost="+distance[i]+"parent="+(parent[i]));
         return flag;
    }
    
}
/*run:
Enter the number of vertices:
3
Enter the weight matrix:
0 1 0
0 0 -2
-2 0 0
Enter the source vertex:
1

 Negative weight cycle exists
*/
