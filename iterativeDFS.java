//iterative DFS is nothing but using BFS on a stack ,it uses reverse euler
import java.io.*;
import java.util.*;


class Pairss {
    int val;
    String psr;
    Pairss(int val,String psr){
        this.val=val;
        this.psr=psr;
    }



}
public class iterativeDFS{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vtces=Integer.parseInt(br.readLine());
        int edges=Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph=new ArrayList[vtces];   //check why!!
        for(int i=0;i<vtces;i++){
            graph[i]=new ArrayList<Edge>();
        }

        for(int i=0;i<edges;i++){
            String[] parts=br.readLine().split(" ");
            int src=Integer.parseInt(parts[0]);
            int dest=Integer.parseInt(parts[1]);

            graph[src].add(new Edge(src,dest,1));
            graph[dest].add(new Edge(dest,src,1));

        }
        int src=Integer.parseInt(br.readLine());
        int dest=Integer.parseInt(br.readLine());
        
        Stack<Pairss> s=new Stack<Pairss>();
        boolean visited[]=new boolean[graph.length];
        s.add(new Pairss(src,src+" "));
        while(!s.isEmpty()){
            Pairss curr=s.pop();
            if(visited[curr.val]==true){
                continue;
            }
            visited[curr.val]=true;
            System.out.println(curr.val+"via "+curr.psr);
            for(Edge e:graph[curr.val]){
                s.add(new Pairss(e.nbr,curr.psr+e.nbr+" "));
            }
        }
    }


}