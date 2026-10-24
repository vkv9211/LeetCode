class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;

        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE/2);
        }

        if(len ==1){
            return matrix[0][0];
        }
        int min = Integer.MAX_VALUE/2;
        for(int i=0;i<len;i++){
            
            min = Math.min(min, recursion(0,i,len,matrix,dp));

          //  System.out.println("i = "+i+", left = "+left+", center = "+center+", right = "+right+", min = "+min);
        }

        return min;
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
}