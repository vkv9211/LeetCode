class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        System.out.println("len = "+len);
        int[] dp = new int[len+1];
        
       dp[len] = 0;
       dp[len-1] = cost[len-1];
       for(int i=len-2;i>=0;i--){
        dp[i] = cost[i] +Math.min(dp[i+2],dp[i+1]);
       }
    
       return Math.min(dp[0], dp[1]);
    }

}