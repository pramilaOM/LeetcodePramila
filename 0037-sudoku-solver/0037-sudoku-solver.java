class Solution {
    private boolean isPossible(int x,int y,char[][] board,char k){
        for(int i=0;i<9;i++){
            if(board[i][y]==k) return false;
            if(board[x][i]==k) return false;
            if(board[3*(x/3)+i/3][3*(y/3)+i%3]==k) return false;
        }
        return true;
    }
    private boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isPossible(i,j,board,c)){
                            board[i][j]=c;
                            if(solve(board)) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}