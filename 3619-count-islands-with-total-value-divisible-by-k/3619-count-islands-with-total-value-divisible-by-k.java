class Solution {
    public int countIslands(int[][] grid, int k) {
        
        int ans = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                int value = grid[r][c];
                int remainder = dfs(grid, r, c, k);
                if(value != 0 && remainder == 0){
                    ans++;
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int r, int c, int k){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
        || grid[r][c] == 0) return 0;

        int num = grid[r][c];
        grid[r][c] = 0;

        int down = dfs(grid, r + 1, c, k);
        int right = dfs(grid, r, c + 1, k);
        int up = dfs(grid, r - 1, c, k);
        int left = dfs(grid, r, c - 1, k);

        return (down + right + up + left + num) % k;
    }
}