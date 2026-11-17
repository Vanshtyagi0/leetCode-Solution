class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        for(int[] cord : indices){
            int row = cord[0];
            int col = cord[1];

            for(int i = 0; i < n; i++){
                matrix[row][i]++;
            }
            for(int i = 0; i < m; i++){
                matrix[i][col]++;
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] % 2 == 1) count++;
            }
        }

        return count;
    }
}