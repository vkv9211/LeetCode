class Solution {
    public void solveSudoku(char[][] board) {
        int len = board.length;

        List<Set<Integer>>rowList = new ArrayList<>();
        List<Set<Integer>>colList = new ArrayList<>();
        List<Set<Integer>>gridList = new ArrayList<>();

        for(int i=0;i<len;i++){
            rowList.add(new HashSet<Integer>());
            colList.add(new HashSet<Integer>());
            gridList.add(new HashSet<Integer>());
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                rowList.get(i).add(board[i][j]-'0');
                colList.get(j).add(board[i][j]-'0');
                int rowValue = (i/3)*3;
                int colValue = (j/3);
                gridList.get(rowValue+colValue).add(board[i][j]-'0');
            }
        }

        // System.out.println("Printing row List");
        // printList(len,rowList);
        // System.out.println("Printing col List");
        // printList(len,colList);
        // System.out.println("Printing grid List");
        // printList(len,gridList);

        //main algo.

        solveSudokuUtil(0,0,len,board,rowList,colList,gridList);
        
    }

    public boolean solveSudokuUtil(int row, int col, int len,char[][] board,List<Set<Integer>> rowList,List<Set<Integer>> colList,List<Set<Integer>> gridList )
    {
        if(row == 9){
            return true;
        }

        if(col == 9){
            return solveSudokuUtil(row+1, 0, len ,board,rowList, colList, gridList);
        }
        if (board[row][col] != '.') {
            return solveSudokuUtil(row, col+1, len,board, rowList, colList, gridList);
        }
        for(int x =1;x<=9;x++){
            //System.out.println("row = "+row+", col = "+col+", x = "+x);
            if(checkForValue(row,col,x,rowList,colList,gridList)){
                
                board[row][col] = (char)(x+'0');
                rowList.get(row).add(x);
                colList.get(col).add(x);
                gridList.get(((row/3)*3)+(col/3)).add(x);
                if(solveSudokuUtil(row, col+1, len,board,rowList,colList,gridList)){
                    return true;
				}else{
					board[row][col] = '.';
					rowList.get(row).remove(x);
					colList.get(col).remove(x);
					gridList.get(((row/3)*3)+(col/3)).remove(x);
                    
				}
			}
		}
		return false;
	}

    public boolean checkForValue(int i, int j,int x, List<Set<Integer>> rowList,List<Set<Integer>> colList,List<Set<Integer>> gridList ){

        //System.out.println("row check  = "+(!rowList.get(i).contains(x)));
        //System.out.println("col check  = "+(!colList.get(j).contains(x)));
        //System.out.println("grid check  = "+(!gridList.get((3*(i/3))+(j/3)).contains(x)));
        return !rowList.get(i).contains(x) && !colList.get(j).contains(x) && !gridList.get((3*(i/3))+(j/3)).contains(x);
    }

    public void printList(int len, List<Set<Integer>> list){
        for(Set<Integer> set : list){
            System.out.println(set);
        }
    }
}