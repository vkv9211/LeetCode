import java.util.*;

class Solution {

    int count = 0;
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2){
                    System.out.println("i = "+i+", j = "+j);
                    q.add(new int[]{i,j});
                    
                }
            }
            
        }
        q.add(null);

        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(temp == null){
                
               // System.out.println("count = "+count);
                if(!q.isEmpty()){
                    q.add(null);
                    count++;
                }
                continue;
            }

            int x = temp[0];
            int y = temp[1];
            
            System.out.println("x = "+x+", y = "+y);
            for(int i =0;i<4; i++){
                int new_x = x+dir[i][0];
                int new_y = y+dir[i][1];

                if(new_x <0 ||new_x >= row || new_y<0 || new_y >=col || grid[new_x][new_y] == 0 || grid[new_x][new_y] == 2){
                    continue;
                }
                System.out.println("new_x = "+new_x+", new_y = "+new_y+", grid[new_x][new_y] = "+grid[new_x][new_y]);
                q.add(new int[]{new_x, new_y});
                grid[new_x][new_y] = 2;
                
            }
            
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
            
        }

        return count;
    }

    public void bfs(int row, int col, int count, int[][] grid, Queue<int[]> q, int[][] dir){
        

        
    }
}