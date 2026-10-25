class Solution {
    public int cherryPickup(int[][] grid) {
        // int row = grid.length;
        // int col = grid[0].length;

        // int[][][] dp = new int[row][col][col];

        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         for(int k=0;k<col;k++){
        //             dp[i][j][k] = -1;
        //         }
                
        //     }
        // }

        // return recursion(0,0,col-1,row,col,grid,dp);
        return tabulation(grid);
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

    public int tabulation(int[][] grid){
        int row= grid.length;
        int col = grid[0].length;

        int[][][] dp = new int[row][col][col];

        for(int j1=0;j1<col;j1++){
            for(int j2=0;j2<col;j2++){
                if(j1 == j2){
                    dp[row-1][j1][j2] = grid[row-1][j1];
                }else{
                    dp[row-1][j1][j2] = grid[row-1][j1] + grid[row-1][j2];
                }
            }
        }

        for(int i=row-2;i>=0;i--){
            for(int j1=0;j1<col;j1++){
                for(int j2=0;j2<col;j2++){
                    int maxi = Integer.MIN_VALUE/2;
                    for(int dj1=-1;dj1<2;dj1++){
                        for(int dj2=-1;dj2<2;dj2++){
                            int value = 0;
                            if(j1 == j2){
                                value += grid[i][j1];
                            }else{
                                value += grid[i][j1] + grid[i][j2];
                            }
                            if(j1+dj1 >=0 && j1+dj1 < col && j2+dj2 >=0 && j2+dj2 <col){
                                value += dp[i+1][j1+dj1][j2+dj2];
                            }else{
                                value += Integer.MIN_VALUE/2;
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][col-1];
    }
}