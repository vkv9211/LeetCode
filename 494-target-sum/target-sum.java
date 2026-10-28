class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;

        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        if(sum < target || (sum+target) <0 || (sum+target)%2 !=0){
            return 0;
        }
        int nTarget = (sum+target)/2;

        int[][] dp = new int[len][nTarget+1];

        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }
        return recursion(0,len,nTarget,nums,dp);
    }

    public int recursion(int index, int len,int nTarget, int[] nums, int[][] dp){
        if(index >= len){
            if(nTarget == 0){
                return 1;
            }
            return 0;
        }
        if(nTarget <0){
            return 0;
        }

        if(dp[index][nTarget] != -1){
            return dp[index][nTarget];
        }
        int notTake = recursion(index+1, len, nTarget, nums,dp);
        int take = 0;
        if(nTarget >=nums[index]){
            take = recursion(index+1,len, nTarget-nums[index], nums, dp);
        }
        
        return dp[index][nTarget] = take+notTake;
    }
}