class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<row;i++){
            if(board[i][0] == 'O'){
                System.out.println("row = "+i+", col = "+ "0");
                q.add(new int[]{i,0});
            }
            if(board[i][col-1] == 'O'){
                System.out.println("row = "+i+", col = "+ (col-1));
                q.add(new int[]{i,col-1});
            }
        }

        for(int i=0;i<col;i++){
            if(board[0][i] == 'O'){
                System.out.println("row = "+'0'+", col = "+ i);
                q.add(new int[]{0,i});
            }
            if(board[row-1][i] == 'O'){
               // System.out.println("row = "+(row-1)+", col = "+ i);
                q.add(new int[]{row-1,i});
            }
        }

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
           // System.out.println("r = "+r+", c = "+c);
            board[r][c] = 'S';
            for(int i =0;i<4;i++){
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];

                if(nr >=0 && nr <row && nc >=0 && nc <col && board[nr][nc] =='O'){
                    q.add(new int[]{nr,nc});
                }
            }
        }

        // for(int i=0;i<row;i++){
        //     for(int j=0;j<col;j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

   // return board;
}