import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class selfdfs {
    static int var=0;
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

      boolean visited[]=new boolean[vtces];
    //   find(graph,src,dest,visited,""+src);
      Arrays.fill(visited, false);
      boolean check=hasPath(graph, src, dest, visited);
      System.out.println(check);


    }
    //a few changes can be made in the code right below to convert it into hasPath
    static void find(ArrayList<Edge> graph[],int src,int dest,boolean visited[],String path){
        visited[src]=true;
        if(src==dest){
            System.out.println(path);
        }
        for(Edge e: graph[src]){
            if(visited[e.nbr]==true) continue;
            visited[e.nbr]=true;
            find(graph, e.nbr, dest, visited,path+e.nbr);

        }
        

    }
    static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean visited[]){
   
        visited[src]=true;
        boolean check=false;
        for(Edge e: graph[src]){
            if(visited[e.nbr]==true) continue;
            if(e.nbr==dest){
                
                return true;
            }
            visited[e.nbr]=true;
            check= hasPath(graph, e.nbr, dest, visited);

        }

        return check;
        

    }
    
}
