import java.util.*;
import java.io.*;


class PairHolder  implements Comparable<PairHolder>{
    int val;
    int wtsum;
    String psr;

    PairHolder(int val,String psr,int wtsum){
        this.val=val;
        this.psr=psr;
        this.wtsum=wtsum;
    }
    public int compareTo(PairHolder o) {
        // TODO Auto-generated method stub

        return this.wtsum-o.wtsum;
     }
     

}
public class dijkstraAlgo {
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
  int src=Integer.parseInt(br.readLine());
  int dest=Integer.parseInt(br.readLine());
  fun(graph,src,dest);

    }

    static void fun(ArrayList<Edge>[] graph, int src, int dest){
        boolean visited[]=new boolean[graph.length];
        PriorityQueue<PairHolder> q=new PriorityQueue<>();
        q.add(new PairHolder(graph[src].get(0).src,graph[src].get(0).src+"->",0));
        while(!q.isEmpty()){
            PairHolder current=q.remove();
            if(visited[current.val]==true){
                continue;
            }
            visited[current.val]=true;
            System.out.println(current.val+" via "+current.psr +" @"+current.wtsum);
            // if(current.val==dest){  // WE WILL NOT REQUIRE THIS, THE LAST ONES WILL BE ALREADY VISITED
            //     break;
            // }
            for(Edge e :graph[current.val]){
                if(visited[e.nbr]==true ){// addon
                    continue;
                } 
                q.add(new PairHolder(e.nbr,current.psr+e.nbr+"->", e.wt+current.wtsum));
            }
        }
        


    }

    
}
