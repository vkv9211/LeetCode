class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][][] dp = new int[row][col][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<col;k++){
                    dp[i][j][k] = -1;
                }
                
            }
        }

        return recursion(0,0,col-1,row,col,grid,dp);
    }

    public int recursion(int crow, int col1, int col2, int row, int col, int[][] grid, int[][][] dp){
        if(col1 <0 || col1 >= col || col2<0 || col2 >= col){
            return Integer.MIN_VALUE/2;
        }

        if(crow == row-1){
            if(col1 == col2){
                return grid[crow][col1];
            }
            return grid[crow][col1] + grid[crow][col2];
        }

        if(dp[crow][col1][col2] != -1){
            
            return dp[crow][col1][col2];
        }
        int max = Integer.MIN_VALUE/2;
        for(int dj1=-1;dj1<2;dj1++){
            for(int dj2=-1;dj2<2;dj2++){
                int curr = 0;
                if(col1 == col2){
                    curr = grid[crow][col1];
                }else{
                    curr = grid[crow][col1] + grid[crow][col2] ;
                }
                max = Math.max(max, curr+recursion(crow+1,col1+dj1,col2+dj2,row,col,grid,dp));
            
            }
        }

        return dp[crow][col1][col2] = max;
    }
}