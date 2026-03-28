class Solution {
    public void setZeroes(int[][] matrix) {
        //https://www.youtube.com/watch?v=A0_hEzQFP9U
        int m = matrix.length;
        int n = matrix[0].length;

         boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true; //mark it for zero
                    col[j] = true; //mark it for zero
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}