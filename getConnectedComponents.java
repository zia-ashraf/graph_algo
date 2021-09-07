import java.util.*;



import java.io.*;
public class getConnectedComponents {
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

    //  getConnected(graph, vtces);
      ArrayList<ArrayList<Integer>> item_box=new ArrayList<>();
      getConnected(graph, vtces, item_box);

      System.out.println(item_box);
    }
    static void getConnected(ArrayList<Edge>[] graph,int vtces,ArrayList<ArrayList<Integer>> item_box){
        boolean[] visited=new boolean[vtces];
        for(int i=0;i<vtces;i++){
            if(visited[i]==true) continue;
            ArrayList<Integer> item=new ArrayList<Integer>();

            // System.out.println("for the vertex:"+i);
            printAllVertices(graph, i, visited,item);
            // System.out.println();
                item_box.add(item);
        }


    }
    static void printAllVertices(ArrayList<Edge>[] graph,int start,boolean visited[],ArrayList<Integer> item){
        visited[start]=true;
        // System.out.print(start+" ");
        item.add(start);
        for(Edge e: graph[start]){
            if(visited[e.nbr]){
                continue;
            }
            printAllVertices(graph, e.nbr, visited,item);
        }
    }
}
