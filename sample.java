import java.util.*;

class sample {
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void main(String args[]){
        // boolean a=solve("abcdefghijklmnopqrstuvwxyz","bcdefghijklmnopqrstuvwxyza");
        boolean a=solve("ab","ba");
        System.out.println(a);
    }
    public static boolean solve(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int vtces=26;
        ArrayList<Edge>[] graph=new ArrayList[vtces];
        for(int i=0;i<vtces;i++){
            graph[i]=new ArrayList<Edge>();

        }
        outer: for(int i=0;i<s.length();i++){
            int v1=(int)s.charAt(i)-97;
            int v2=(int)t.charAt(i)-97;
            for(Edge e:graph[v1]){
                                                                 
                if(e.src==v1 && e.dest==v2){
                    continue outer;
                }

            }
            graph[v1].add(new Edge(v1,v2));
        }
        boolean cycle=false;
        for(int i=0;i<vtces;i++){

            if(graph[i].size()>1){
                return false;
            }
            if(graph[i].size()>0){

            cycle=checkcycle(graph,graph[i].get(0).src);
            if(cycle){
                return false;
            }
  
            
            }

        }
        System.out.println("cycle"+cycle);
        return true;
        
    }
    static boolean  checkcycle(ArrayList<Edge>[] graph,int src){
        
        Queue<Integer> q=new LinkedList<Integer>();
        // boolean visited[]=new boolean[graph.length];
        HashSet<Integer> h=new HashSet<Integer>();
        q.add(src);
        while(!q.isEmpty()){
            int curr=q.poll();
            if(h.contains(curr) ){
                if(h.size()<26){
                    return false;
                }
                return true;
            }
            // if(visited[curr]==true){
            //     System.out.println("ok");
            //     System.out.println("here is the current val"+curr);
            //     return true;
                
            // }
            // visited[curr]=true;
            h.add(curr);
            for(Edge e:graph[curr]){
                // System.out.println(e.src+" to"+ e.dest);
                // if(visited[e.dest]==true){
                //     continue;
                // }
                if(e.src==e.dest){
                    return false;
                }
                System.out.println(e.src+"adds"+e.dest);
                
                q.add(e.dest);
            }
        }
        return false;

    }
}