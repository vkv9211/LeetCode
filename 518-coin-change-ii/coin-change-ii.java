class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len][amount+1];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }

        //return recursion(len-1,amount,coins,dp);
        return tabulation(amount,coins);
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

    public int tabulation(int amount, int[] coins){
        int len = coins.length;
        int[][] dp = new int[len][amount+1];

        for(int i=0;i<len;i++){
            dp[i][0] = 1;
        }

        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0){
                dp[0][i] = 1;
            }
        }

        for(int i =1;i<len;i++){
            for(int j=0;j<=amount;j++){
                int notTake , take;
                notTake = dp[i-1][j];
                take = 0;
                if(j>=coins[i]){
                    take = dp[i][j-coins[i]];
                }
                dp[i][j] = take+notTake;
            }
        }

        return dp[len-1][amount];
    }
}