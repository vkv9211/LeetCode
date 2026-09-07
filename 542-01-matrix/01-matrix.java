import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        calDist(row, col, mat, dir, q);

        return mat;
    }

    public void calDist(int row, int col, int[][] mat, int[][] dir, Queue<int[]>q){
        
        while(!q.isEmpty()){
            
           // System.out.println("size = "+size+", count = "+count);
            
                int[] temp = q.poll();

                int x = temp[0];
                int y = temp[1];
                for(int i =0;i<4;i++){
                    int new_x = x+dir[i][0];
                    int new_y = y+dir[i][1];

                    if(new_x >=0 && new_x <row && new_y >=0 && new_y <col && mat[new_x][new_y] == -1){
                        mat[new_x][new_y] = mat[x][y] +1;
                        q.add(new int[]{new_x, new_y});
                    }
                
                }
        }
    }
}