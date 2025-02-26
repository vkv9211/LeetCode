class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currMax = 0, currMin = 0;
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        for(int i :nums){
            currMax = Math.max(i, currMax+i);
            currMin = Math.min(i, currMin+i);
            
            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);
            
           // System.out.println("i = "+i+", currMax = "+currMax+", currMin = "+currMin+", globalMax = "+globalMax+", globalMin = "+globalMin);
        }
        return Math.max(Math.abs(globalMax), Math.abs(globalMin));
    }
}