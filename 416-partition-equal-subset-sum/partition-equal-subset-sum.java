class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        int sum = 0;

        for(int i : nums){
            sum += i;
        }

        if(sum %2 !=0){
            return false;
        }

        sum = sum/2;
       // int[][] dp = new int[len][sum+1];
       // for(int i=0;i<len;i++){
        //    Arrays.fill(dp[i],-1);
        //}

        // for(int i=0;i<len;i++){
        //     dp[i][0] = 1;
        // }
        // for(int i=0;i<=sum;i++){
        //     if(nums[0] == sum){
        //         dp[0][nums[i]] = 1;
        //     }
        // }

       // return recursion(len-1,sum,nums,dp)==1;

        return tabulation(nums,sum);
    }

    public boolean tabulation(int[] nums, int sum){
        int len = nums.length;

        boolean[][] dp = new boolean[len][sum+1];
        for(int i=0;i<len;i++){
            dp[i][0] = true;
        }

        for(int i=0;i<len;i++){
            if(nums[i] == sum){
                dp[0][i] = true;
            }
        }

        for(int i=1;i<len;i++){
            for(int j=1;j<=sum;j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(j>=nums[i]){
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }

        return dp[len-1][sum];
    }

    public int recursion(int index, int sum, int[] nums,int[][] dp){
        if(sum == 0){
            return 1;
        }
        if(index == 0){
            if(sum == nums[index]){
                return 1;
            }

            return 0;
        }

        if(dp[index][sum] != -1){
            return dp[index][sum];
        }

        int notTake = recursion(index-1,sum,nums,dp);
        int take = 0;
        if(sum >= nums[index]){
            take = recursion(index-1, sum-nums[index], nums,dp);
        }

        return dp[index][sum] = (take==1 || notTake == 1) ? 1:0;
    }
}