class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len][amount+1];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }

        return recursion(len-1,amount,coins,dp);
    }

    public int recursion(int index,  int amount, int[] coins, int[][] dp){
        
        if(index == 0){
            if(amount == 0 || amount%coins[index] == 0){
                return 1;
            }
            return 0;
        }
        

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int notTake, take;
        notTake=take = 0;
        notTake = recursion(index-1, amount,coins,dp);
        if(amount >= coins[index]){
            take = recursion(index,amount-coins[index], coins,dp);
        }

        return dp[index][amount] = notTake+take;
    }
}