class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for(int i=0;i<row;i++){
            Arrays.fill(dp[i], -1);
        }

        return recursive(row-1, col-1, grid, dp);
       //return tabulation(grid);
    }

    public int tabulation(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }else if(i == 0){
                    dp[i][j] = grid[i][j]+dp[i][j-1];
                }else{
                    dp[i][j] = grid[i][j];
                    if(j>0){
                        dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                    }else{
                        dp[i][j] += dp[i-1][j];
                    }
                }
            }
        }
        return dp[row-1][col-1];
    }

    public int recursive(int row, int col, int[][] grid, int[][] dp){
        if(row == 0 && col == 0){
            return grid[0][0];
        }

        if(row< 0 || col <0){
            return Integer.MAX_VALUE/2;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int left = grid[row][col] + recursive(row, col-1, grid,dp);
        int up = grid[row][col] + recursive(row-1, col, grid,dp);
       // System.out.println("row = "+row+", col = "+col+", left = "+left+", up = "+up);

        dp[row][col] = Math.min(left,up);
        return dp[row][col];
    }
}