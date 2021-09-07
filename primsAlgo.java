import java.io.*;
import java.util.*;

public class primsAlgo {
    static class Pairs implements Comparable<Pairs>{
        int curr;
        int pre;
        int wtsum;
        Pairs(int curr,int pre,int wt) {
            this.curr=curr;
            this.pre=pre;
            this.wtsum=wt;

        }
        public int compareTo(Pairs o){
            return this.wtsum-o.wtsum;
        }
        
    }
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
      primfun(graph, src, dest);
    }
    static void primfun(ArrayList<Edge> graph[],int src,int dest){
        boolean visited[]=new boolean[graph.length];
       PriorityQueue<Pairs> q=new PriorityQueue<>();
       q.add(new Pairs(graph[src].get(0).src,-1,0));
       while(!q.isEmpty()){
           Pairs curr=q.poll();
           if(visited[curr.curr]==true){
               continue;
           }
           visited[curr.curr]=true;
           if(curr.pre!=-1){

               System.out.println(curr.pre+"-"+curr.curr+" @"+curr.wtsum);
           }
           for(Edge e:graph[curr.curr]){
               if(visited[e.nbr]==true){
                   continue;
               }
               q.add(new Pairs(e.nbr,e.src,e.wt));
           }

       }

    
}
}