class Solution {
    int[] stairs = new int[101];

    public Solution(){
        stairs[0] = 0;
        stairs[1] = 1;
        stairs[2] = 2;

        for(int i=3;i<101;i++){
            stairs[i] = stairs[i-1]+stairs[i-2];
        }
    }
    public int climbStairs(int n) {

        if(n<0){
            return 0;
        }
         
        return stairs[n];
    }
}