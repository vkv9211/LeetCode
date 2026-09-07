class Solution {
    public int numEnclaves(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0;i<row;i++){
            if(grid[i][0] == 1){
                q.add(new int[]{i,0});
                grid[i][0] = 2;
               // System.out.println("row = "+i+",col = 0");
            }
            if(grid[i][col-1] == 1){
                q.add(new int[]{i,col-1});
                grid[i][col-1] = 2;
              //  System.out.println("row = "+i+",col = "+(col-1));
            }
        }

        for(int i=0;i<col;i++){
            if(grid[0][i] == 1){
                q.add(new int[]{0,i});
                grid[0][i] = 2;
                //System.out.println("row = 0"+",col = "+i);
            }
            if(grid[row-1][i] == 1){
                q.add(new int[]{row-1, i});
                grid[row-1][i] = 2;
               // System.out.println("row = "+(row-1)+",col = "+i);
            }
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            
            for(int i =0;i<4;i++){
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];

                if(nr >=0 && nr <row && nc >=0 && nc < col && grid[nr][nc] == 1){
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = 2;
                }
            }
        }

        int count = 0;
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    count++;
                }else if(grid[i][j] == 2){
                    grid[i][j] = 1;
                }
            }
        }

        return count;
    }
}