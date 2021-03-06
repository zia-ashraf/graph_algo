import java.io.*;
import java.util.*;

public class CheckPath {
    static class Edge {
        int src;
          int nbr;
          int wt;
    
          Edge(int src, int nbr, int wt){
             this.src = src;
             this.nbr = nbr;        //denotes neighbour
             this.wt = wt;
          }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }
        
        System.out.println('s');
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

      // write your code here
      boolean visited[]=new boolean[vtces];
      System.out.println(hasPath(graph, 0, 6,visited));
      
      
      
    }
    static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited ){
        if(src==dest)
        {
            return true;
        }
        System.out.println('k');
        for(Edge edge: graph[src]){
            if(visited[edge.src]==true) continue;
            visited[edge.nbr]=true;
            if(edge.nbr==dest){
                return true;
                
            }
            else{
                return hasPath(graph, edge.nbr, dest, visited);
            }
             
        }
        return false;
    }
}