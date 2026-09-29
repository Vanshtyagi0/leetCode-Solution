class Solution {
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int len = m + n - 1;

        if(len % 2 != 0){
            return false;
        }

        if(grid[0][0] == ')'){
            return false;
        }

        if(grid[n - 1][m - 1] == '('){
            return false;
        }

        dp = new Boolean[n][m][len + 1];

        return helper(grid, 0, 0, 0);
    }

    private boolean helper(char[][] grid, int r, int c, int balance){
        int n = grid.length;
        int m = grid[0].length;

        if(r >= n || c >= m) return false;

        if(grid[r][c] == '(') balance++;
        else balance--;

        if(balance < 0) return false;

        if(r == n - 1 && c == m - 1){
            return balance == 0;
        }

        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        boolean down = helper(grid, r + 1, c, balance);
        boolean right = helper(grid, r, c + 1, balance);

        dp[r][c][balance] = down || right;

        return down || right;
    }
}