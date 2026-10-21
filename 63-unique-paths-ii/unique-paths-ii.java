class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[] prev = new int[col];
        prev[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i=1;i<col;i++){
            if(obstacleGrid[0][i] == 1){
                prev[i] = 0;
            }else{
                prev[i] = prev[i-1];
            }
        }

        for(int i=1;i<row;i++){
            int[] temp = new int[col];
            temp[0] = obstacleGrid[i][0] == 0 ? prev[0] : 0;
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j] == 1){
                    temp[j] = 0;
                }else{
                    temp[j] = prev[j]+temp[j-1];
                }
            }
            prev = temp;
        }
        return prev[col-1];
    }
}