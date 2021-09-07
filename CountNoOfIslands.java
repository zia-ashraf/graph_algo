import java.util.*;
public class CountNoOfIslands {

    public int numIslands(char[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int counter=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    connectIslands(grid,i,j,visited); 
                    System.out.println(Arrays.toString(visited));
                    ++counter;
                }
                
            }
        }
        return counter;
        
    }
     public void connectIslands(char[][] grid,int i, int j,int[][] visited){
        if(i<0 || i>=grid.length || j>=grid[0].length || j<0 || grid[i][j]=='0' || visited[i][j]==1)
            return;
        
        visited[i][j]=1;
        connectIslands(grid,i+1,j,visited);
        connectIslands(grid,i-1,j,visited);
        connectIslands(grid,i,j+1,visited);
        connectIslands(grid,i,j-1,visited);
        
    }
}
    

