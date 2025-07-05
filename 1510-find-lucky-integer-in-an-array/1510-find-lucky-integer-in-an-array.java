class Solution {
    public int findLucky(int[] arr) {
        int result = -1;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            if (arr[i] == count) {
                result = Math.max(result, arr[i]);
            }
        }

        return result;

    }
}