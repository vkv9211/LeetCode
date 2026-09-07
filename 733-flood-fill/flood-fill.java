class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int init = image[sr][sc];
        int row = image.length;
        int col = image[0].length;

        if(init == color){
            return image;
        }

        //System.out.println("init = "+init+", color = "+color);
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        dfs(sr,sc,color, init,row, col, image, dir);

        return image;
        
    }

    public void dfs(int sr, int sc, int color, int init, int row, int col, int[][] image, int[][] dir){
       // System.out.println("sr= "+sr+", sc = "+sc+", init = "+init+", color = "+color);
        image[sr][sc] = color;

        for(int i=0;i<4;i++){
            int new_x = sr+dir[i][0];
            int new_y = sc+dir[i][1];

            if(new_x <0 || new_x >= row || new_y <0 || new_y >= col|| image[new_x][new_y] != init){
                continue;
            }
            dfs(new_x, new_y, color, init,row, col, image, dir);
        }
    }
}