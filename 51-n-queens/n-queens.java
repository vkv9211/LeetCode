class Solution {
    public List<List<String>> solveNQueens(int n) {
        StringBuilder s = new StringBuilder();
        for(int i =0;i<n;i++){
            s.append('.');
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for(int i =0;i<n;i++){
            board.add(s.toString());
        }

        int col =0;
        int row = 0;
        for(int i =col;i<n;i++){
            StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(i,'Q');
                board.set(row,sb.toString());
               // System.out.println("********************");
               // System.out.println(board);
                utilFunc(row+1,n,board,ans);
                sb.setCharAt(i,'.');
                board.set(row,sb.toString());
        }
        return ans;
    }

    public void utilFunc(int row, int n, List<String> board, List<List<String>> ans){
        if(row == n){
            List<String> temp = new ArrayList<>(board);
            ans.add(temp);
            return ;
        }

        for(int i=0;i<n;i++){
            if(isValidCell(row,i,n,board)){
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(i,'Q');
                board.set(row,sb.toString());
              //  System.out.println(board);
                utilFunc(row+1,n,board,ans);
                sb.setCharAt(i,'.');
                board.set(row,sb.toString());
            }
        }
    }

    public boolean isValidCell(int row, int col, int n, List<String> board){
        //System.out.println("In valid cell check row = "+row+", col = "+col);
        return rowCheck(row, n, board) && colCheck(col, n, board) && leftDiagCheck(row, col, n, board) && rightDiagCheck(row, col, n, board);
    }

    public boolean rowCheck(int row, int n,List<String> board){
        int count = 0;
        for(int i=0;i<n;i++){
            if(board.get(row).charAt(i) == 'Q'){
                count++;
            }
        }
      //  System.out.println("rowCheck row = "+row+", count = "+count);
        return count == 0;
    }

    public boolean colCheck(int col, int n, List<String> board){
        int count = 0;
        for(int i=0;i<n;i++){
            if(board.get(i).charAt(col) == 'Q'){
                count++;
            }
        }
       // System.out.println("colCheck col = "+col+", count = "+count);
        return count == 0;
    }

    public boolean leftDiagCheck(int row, int col, int n, List<String> borad){
        int diff = row - col;
        int count = 0;
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i-j == diff) && borad.get(i).charAt(j) == 'Q'){
                    count++;
                }
            }
        }
       // System.out.println("leftDiagCheck row = "+row+", col = "+col+", count = "+count);
        return count == 0;
    }

    public boolean rightDiagCheck(int row, int col, int n, List<String> borad){
        int sum = row + col;
        int count =0;
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i+j == sum) && borad.get(i).charAt(j) == 'Q'){
                    count++;
                }
            }
        }
      //  System.out.println("rightDiagCheck row = "+row+", col = "+col+", count = "+count);
        return count == 0;
    }
}