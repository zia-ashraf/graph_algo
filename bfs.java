import java.io.*;
import java.util.*;

public class bfs {
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
  
  boolean[] visited=new boolean[vtces];

    Queue<Integer> q=new LinkedList<>();
    q.add(graph[src].get(0).src);   //a random pair in the index

    //ONE WAY
    // visited[src]=true;
    // while(!q.isEmpty()){

    //     int current=q.poll();
    //     System.out.println(current);
    //     for(Edge e:graph[current]){
    //         if(!visited[e.nbr]){

    //             visited[e.nbr]=true;
    //             q.add(e.nbr);
    //         }
    //     }
    // }

    //SECOND WAY-- remove-mark-work-add
    //used by pepcoding but leads to a bit of duplicacy in the queue
 
    while(!q.isEmpty()){

        int current=q.poll();
    
        if(visited[current]==true){
            System.out.println(current);
        continue;
        }
        visited[current]=true;
        for(Edge e:graph[current]){
            if(!visited[e.nbr]){

                q.add(e.nbr);
            }
        }
    }

   }


    
}
