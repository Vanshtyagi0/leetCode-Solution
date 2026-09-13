class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int row = 0; row < m; row++){
            if(board[row][0] == 'O'){
                dfs(board, row, 0);
            }

            if(board[row][n - 1] == 'O'){
                dfs(board, row, n - 1);
            }
        }

        for(int col = 0; col < n; col++){
            if(board[0][col] == 'O'){
                dfs(board, 0, col);
            }

            if(board[m - 1][col] == 'O'){
                dfs(board, m - 1, col);
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }

                if(board[r][c] == '#'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c){

        int m = board.length;
        int n = board[0].length;

        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O'){
            return;
        }
        
        board[r][c] = '#';

        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
}