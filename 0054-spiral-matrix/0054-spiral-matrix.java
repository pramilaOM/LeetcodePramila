class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, left = 0, down = m - 1, right = n - 1;
        List<Integer> result = new ArrayList<>();
        int dir = 0;

        while (left <= right && top <= down) {
            if (dir == 0) {
                //l to right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);

                }
                top++;

            }

            if (dir == 1) {
                //top down
                for (int i = top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;

            }

            if (dir == 2) {
                //right to  left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;

            }

            if (dir == 3) {
                //down to top
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;

        }
        return result;
    }
}