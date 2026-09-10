class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int island = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    island++;
                    // bfs(grid, i, j);
                    // dfs(grid, i, j);
                    dfsUsingRecursion(grid, i, j);
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, int startRow, int startCol){
        
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        grid[startRow][startCol] = '0';
        queue.offer(new int[]{startRow, startCol});

        while(!queue.isEmpty()){
            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            for(int[] dir : directions){

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1'){

                        grid[newRow][newCol] = '0';
                        queue.offer(new int[]{newRow, newCol});
                    }
            }
        }
    }

    private void dfs(char[][] grid, int startRow, int startCol){
        
        int rows = grid.length;
        int cols = grid[0].length;

        Stack<int[]> stack = new Stack<>();

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        grid[startRow][startCol] = '0';
        stack.push(new int[]{startRow, startCol});

        while(!stack.isEmpty()){
            int[] cell = stack.pop();

            int row = cell[0];
            int col = cell[1];

            for(int[] dir : directions){

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1'){

                        grid[newRow][newCol] = '0';
                        stack.push(new int[]{newRow, newCol});
                    }
            }
        }
    }

    private void dfsUsingRecursion(char[][] grid, int row, int col){

        int rows = grid.length;
        int cols = grid[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols ||
            grid[row][col] == '0'){
                return;
            }

        grid[row][col] = '0';

        dfsUsingRecursion(grid, row - 1, col);
        dfsUsingRecursion(grid, row + 1, col);
        dfsUsingRecursion(grid, row, col - 1);
        dfsUsingRecursion(grid, row, col + 1);
    }
}