import java.io.*;
import java.util.*;

 class Pair{
    int val;
    int level;

    Pair(int val,int level){
        this.val=val;
        this.level=level;
    }

}

public class spreadInfection {
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
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
    //   int dest = Integer.parseInt(br.readLine());
    findInfectedPeople(graph, src, 3);

      
    }
    static int findInfectedPeople(ArrayList<Edge>[] graph, int src ,int time){
        Queue<Pair> q=new LinkedList<>();
        
        boolean[] visited=new boolean[graph.length];
        q.add(new Pair(graph[src].get(0).src,1));
        Pair current;
        int counter=0;
        int answer=0;
        while(!q.isEmpty()){
            current=q.poll();
            if(visited[current.val]==true){
                // System.out.println(current);
                continue;
            }
            // System.out.println(current.val+"__"+current.level);
            ++counter;
            if(current.level==time){
                answer=counter;


            }
            visited[current.val]=true;
            for(Edge e:graph[current.val]){
                if(visited[e.nbr]==true){
                    continue;
                }
                q.add(new Pair(e.nbr,current.level+1));
            }


        }
        System.out.println("total no of people infected-"+answer);
        return 1;
    }
}
