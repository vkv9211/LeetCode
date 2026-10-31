class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len][amount+1];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }

        return recursion(0,len,amount,coins,dp);
    }

    public int recursion(int index, int len, int amount, int[] coins, int[][] dp){
       // System.out.println("index = "+index+", amount = "+amount);
        if(amount <0){
            return 0;
        }
        if(index == len){
            if(amount == 0){
                return 1;
            }
            return 0;
        }
        

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int notTake, takeOnce, takeMul;
        notTake=takeOnce=takeMul = 0;
        notTake = recursion(index+1, len, amount,coins,dp);
        if(amount >= coins[index]){
           // takeOnce = recursion(index+1,len, amount-coins[index], coins, dp);
            takeMul = recursion(index,len,amount-coins[index], coins,dp);
        }

      //  System.out.println("notTake = "+notTake+", takeOnce = "+takeOnce+", takeMul = "+takeMul);

        return dp[index][amount] = takeOnce+takeMul+notTake;
    }
}