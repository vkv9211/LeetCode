class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] dp = new boolean[m][n];

        int[][] dir = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]== '1'){
                    num++;
                    dp(i,j,m,n,grid,dir);
                }
            }
        }
        return num;
    }

    public void dp(int x, int y, int m, int n, char[][] grid,int[][] dir){
        grid[x][y] = '0';
        for(int i =0;i<4;i++){
            int new_x = x+dir[i][0];
            int new_y = y+dir[i][1];

            if(new_x <0 || new_x >=m || new_y <0 || new_y >= n || grid[new_x][new_y] == '0'){
                continue ;
            }
            if(grid[new_x][new_y] == '1'){
                dp(new_x, new_y, m, n,grid, dir );
            }
        }
    }
}