class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] result = new int[rows * cols][2];

        int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int r = rStart;
        int c = cStart;

        int i = 0;
        int steps = 1;
        int dir = 0;

        result[i++] = new int[]{rStart, cStart};

        while(i < rows * cols){
            for(int repeat = 0; repeat < 2; repeat++){
                int dr = directions[dir][0];
                int dc = directions[dir][1];

                for(int j = 0; j < steps; j++){
                    r += dr;
                    c += dc;

                    if(r >= 0 && r < rows && c >= 0 && c < cols){
                        result[i++] = new int[]{r, c};
                    }

                    if(rows * cols == i){
                        return result;
                    }
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }

        return result;
    }
}