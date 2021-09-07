//very cool algo 
//now looks to be like use of DFS (goes into depths) but not 100% sure
import java.io.*;
import java.util.*;
public class PrintAllPaths {
    static int answer=Integer.MIN_VALUE; //stores the answer to the threshold value
    static int threshold;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }
        
        // System.out.println('s');
      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());
      
      System.out.println("enter the number which will act as a ceil value to the weight--");
      threshold= Integer.parseInt(br.readLine());
      

      // write your code here
      boolean visited[]=new boolean[vtces];
      printPaths(graph, src, dest, visited, src+"",0);
      System.out.println(answer);

    }
    static void printPaths(ArrayList<Edge>[] graph,int src,int dest, boolean visited[],String chain,int wt){
        if(src==dest)
    {
        if(wt<threshold && wt>answer){
            System.out.println("djfklsd");
            answer=wt;
        }

        System.out.println(chain+",the cost: "+wt);
        return;
    }
    visited[src]=true;
    for( Edge edge: graph[src]){
        if(visited[edge.nbr]!=true){
            printPaths(graph, edge.nbr, dest, visited, chain+" "+edge.nbr,edge.wt+wt);
        }

    }
    visited[src]=false;
    }

}
