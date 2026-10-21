import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return recMemoized(m-1,n-1,dp);
    }

    public int recMemoized(int row, int col, int[][] dp){
        if(row<0 || col <0){
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int up = recMemoized(row-1, col, dp);
        int left = recMemoized(row, col-1, dp);

        dp[row][col] = up+left;

        return dp[row][col];
    }

    public void recursion(int row, int col, int m,int n, StringBuilder sb, Set<String> set){
        if(row >= m || col>= n){
            return;
        }
        if(row ==m-1 && col == n-1){
            set.add(sb.toString());
            return;
        }
        sb.append('D');
        recursion(row+1,col,m,n,sb,set);
        sb.deleteCharAt(sb.length()-1); 
        sb.append('R');
        recursion(row,col+1,m,n,sb,set);
        sb.deleteCharAt(sb.length()-1);
    }
}