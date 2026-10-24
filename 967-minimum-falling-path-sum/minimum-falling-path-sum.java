class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // int len = matrix.length;

        // int[][] dp = new int[len][len];
        // for(int i=0;i<len;i++){
        //     Arrays.fill(dp[i], Integer.MIN_VALUE/2);
        // }

        // if(len ==1){
        //     return matrix[0][0];
        // }
        // int min = Integer.MAX_VALUE/2;
        // for(int i=0;i<len;i++){
            
        //     min = Math.min(min, recursion(0,i,len,matrix,dp));

        //   //  System.out.println("i = "+i+", left = "+left+", center = "+center+", right = "+right+", min = "+min);
        // }

        // return min;
        //return tabulation(matrix);
        return tabOpt(matrix);
    }

    public int recursion(int row, int col, int len, int[][] matrix, int[][] dp){
        if(row <0 || col <0 || row >= len || col >= len){
            return Integer.MAX_VALUE/2;
        }

        if(row == len-1){
            return matrix[row][col];
        }

        if(dp[row][col] != Integer.MIN_VALUE/2){
            return dp[row][col];
        }

        int left = matrix[row][col] + recursion(row+1, col-1, len, matrix, dp);
        int center = matrix[row][col] + recursion(row+1, col, len, matrix, dp);
        int right = matrix[row][col] + recursion(row+1, col+1, len, matrix, dp);

        dp[row][col] =  Math.min(left, Math.min(center, right));
        return dp[row][col];
    }

    public int tabulation(int[][] matrix){
        int len = matrix.length;

        int[][] dp = new int[len][len];

        for(int i=0;i<len;i++){
            dp[len-1][i] = matrix[len-1][i];
        }

        for(int i=len-2;i>=0;i--){
            for(int j=0;j<len;j++){
                int left, center, right;
                left = center = right = Integer.MAX_VALUE / 2;

                
                if(j-1 >=0){
                    left = dp[i+1][j-1];
                }
                center = dp[i+1][j];
                if((j+1) < len){
                    right =  dp[i+1][j+1];               
                }

                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(center, right));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<len;i++){
            min = Math.min(min, dp[0][i]);
        }

        return min;
    }

    int tabOpt(int[][] matrix){
        int len = matrix.length;

        int[] front = new int[len];

        for(int i=0;i<len;i++){
            front[i] = matrix[len-1][i];
        }

        for(int i=len-2;i>=0;i--){
            int[] curr = new int[len];
            for(int j=0;j<len;j++){
                int left, center, right;
                left = center = right = Integer.MAX_VALUE / 2;

                
                if(j-1 >=0){
                    left = front[j-1];
                }
                center = front[j];
                if((j+1) < len){
                    right =  front[j+1];               
                }

                curr[j] = matrix[i][j] + Math.min(left, Math.min(center, right));
            }

            front = curr;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            min = Math.min(min, front[i]);
        }

        return min;
    }
}