class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int len = triangle.size();
        // int min = Integer.MAX_VALUE;

        // int[][] dp = new int[len][len];

        // for(int i=0;i<len;i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // //System.out.println("len = "+len);
        // if(len == 1){
        //     return triangle.get(0).get(0);
        // }

        // int down = triangle.get(0).get(0) + recursion(0,  1, triangle, dp);
        // int downG = triangle.get(0).get(0) + recursion(1,1,triangle, dp);

        // return Math.min(down, downG);
        return tabulation(triangle);
    }

    public int recursion(int index, int row, List<List<Integer>> triangle, int[][] dp){
        if(row == triangle.size()-1){
            return triangle.get(row).get(index);
        }
        if(dp[row][index] != -1){
            return dp[row][index];
        }
        int down = triangle.get(row).get(index) + recursion(index+0,row+1, triangle, dp);
        int downG = triangle.get(row).get(index) + recursion(index+1,row+1,triangle, dp);

        dp[row][index] =  Math.min(down, downG);
        return dp[row][index];
    }

    public int tabulation(List<List<Integer>> triangle){
        int row = triangle.size();
        System.out.println("row = "+row);

        int[][] dp = new int[row][row];

        for(int i=0;i<row;i++){
            dp[row-1][i] = triangle.get(row-1).get(i);
           // System.out.println("row = "+(row-1)+", col = "+i+", dp[row-1][i] = "+dp[row-1][i]);
        }

        for(int i=row-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
              //  System.out.println("row = "+i+", col = "+j+", d = "+dp[i+1][j]+", dg = "+dp[i+1][j+1]+", dp[i][j] = "+dp[i][j]);
            }
        }

        return dp[0][0];
    }

    
}