import java.util.*;
import java.io.*;
public class topologicalSort{   //WE USE DFS FOR THIS ONE   
    public static void main(String args[])throws IOException{
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
         
      }
      int src=Integer.parseInt(br.readLine());
      int dest=Integer.parseInt(br.readLine());
      Stack<Integer> s=new Stack<Integer>();
      boolean visited[]=new boolean[graph.length];
      for(int i=0;i<graph.length;i++){
          topofun(graph, i, s, visited);
           
  
      }
      while(!s.isEmpty()){
          System.out.println(s.pop());
      }
    }
    static void topofun(ArrayList<Edge>[] graph,int src,Stack<Integer> s,boolean[] visited){
        if(visited[src]==true){
            return;
        }
        visited[src]=true;
        for(Edge e: graph[src]){
            topofun(graph, e.nbr, s, visited);

        }
        s.add(src);

    }

    
}