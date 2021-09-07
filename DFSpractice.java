import java.util.*;

import javax.swing.plaf.basic.BasicLookAndFeel;
class Edges{
    int src;
    int dest;
    int wt;
    Edges(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }

}
public class DFSpractice {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int vtces=6;
        int totalEdge=5;
        ArrayList<Edges>[]  graph=new ArrayList[vtces];
        for(int i=0;i<vtces;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<totalEdge;i++){//say undirected graph
            int src=sc.nextInt();
            int dest=sc.nextInt();
            int wt=sc.nextInt();
            graph[src].add(new Edges(src,dest,wt));
            graph[dest].add(new Edges(dest,src,wt));

        }
        int src=3;
        int dest=5;

        boolean visited[]=new boolean[vtces];
        getDFS(graph,src,dest,visited);
        

    }
    static void getDFS(ArrayList<Edges>[] graph, int src, int dest,boolean visited[]){
        if(visited[src]==true){
            return;
        }
        visited[src]=true;
        if(src==dest){
            System.out.println("yes the element is present");
        }
        for(Edges e: graph[src]){
            if(visited[e.dest]==true)
                continue;
            getDFS(graph, e.dest, dest, visited);
        }

    }
}
