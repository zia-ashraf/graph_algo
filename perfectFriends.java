/*
1. You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.
     */
import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;
public class perfectFriends {
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

      System.out.print("the pair of friends from different clubs are");
      int count=0;
      for(int i=0;i<item_box.size();i++){
          for(int j=i+1;j<item_box.size();j++){
              count+=item_box.get(i).size()*item_box.get(j).size();

          }
      }
      System.out.println(count);


    }
    static void getConnected(ArrayList<Edge> graph[],int vtces,ArrayList<ArrayList<Integer>> item_box){
        boolean visited[]=new boolean[vtces];
        for(int i=0;i<vtces;i++){
            ArrayList<Integer> innerbox=new ArrayList<Integer>();
            if(visited[i]==true)
            continue;
            getEachComponent(graph,i,visited,innerbox);
            item_box.add(innerbox);


        }
    }
    static void getEachComponent(ArrayList<Edge> graph[],int src,boolean visited[],ArrayList<Integer> innerbox){

        visited[src]=true;
        innerbox.add(src);
        for(Edge e:graph[src]){
            if(visited[e.nbr]==true)
            continue;
            getEachComponent(graph,e.nbr,visited,innerbox);
            
        }

    }
    
}
