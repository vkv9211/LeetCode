class Solution {
    public int jump(int[] nums) {
        int len = nums.length-1;
        int[] dp = new int[len+1];
        Arrays.fill(dp,-1);

        return util(0,len,nums, dp);
    }

    public int util(int index, int len, int[] nums, int[] dp){
        if(index >= len){
            return 0;
        }

        if((index+nums[index]) >= len){
            return 1;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int minValue = Integer.MAX_VALUE/2;

        int k = index+nums[index];

        //System.out.println("index = "+index+", len = "+len+", k = "+k);

        for(int i=index+1;i<=k;i++){
            dp[i] = util(i,len,nums,dp);
           minValue = Math.min(minValue,1+ dp[i]);
        }

        return minValue;
    }
}