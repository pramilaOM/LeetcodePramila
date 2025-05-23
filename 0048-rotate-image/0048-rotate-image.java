class Solution {
            public static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i < j) {
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }
        for (int[] i : matrix) {
            reverse(i);
        }
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        // TODO Auto-generated method stub
        System.out.print('[');
        for (int i = 0; i < matrix.length; i++) {

            System.out.print(Arrays.toString(matrix[i]));
            if (i < matrix.length - 1) {
                System.out.print(",");
            }

        }
        System.out.print(']');
    }

    private static void reverse(int[] matrix) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }

    }
        
    }
