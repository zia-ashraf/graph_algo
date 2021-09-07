import java.io.*;
import java.util.*;
public class hamiltonianPaths {
    static int originalsrc=0;
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

      int src=Integer.parseInt(br.readLine());
      int dest=Integer.parseInt(br.readLine());
      originalsrc=src;
    //   int visited[]=new int[vtces];
      HashSet<Integer> visited=new HashSet<>(); //a boolean array can also be taken but then we will have to search using loop so more time complexity
      printHamiltonianPath(graph, src, dest, visited, src+"");




    }
    static void printHamiltonianPath(ArrayList<Edge>[] graph,int src,int dest,HashSet<Integer> visited,String path){
        visited.add(src);
        if(src==dest && visited.size()==graph.length){    //all the nodes should be visited already in a hamiltonian path
                System.out.println(path);
                //now to check hamiltonian cycle
              
                for(Edge e: graph[dest]){
                    if(e.nbr==originalsrc)
                        System.out.println("Yes it forms a cycle too");
                }
        }
        for(Edge e: graph[src]){
            if(visited.contains(e.nbr)==true){
                continue;
            }
            printHamiltonianPath(graph, e.nbr, dest, visited, path+" "+e.nbr);
        }
        visited.remove(src);

            
        }
        static boolean search(int[] visited,int a){
            for(int i:visited){
                if(i==a){
                    return true;
                }
            }
            return false;
        }

    
    
}
