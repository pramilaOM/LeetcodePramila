class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501]; // because max value = 500

        for (int num : arr) {
            freq[num]++;
        }

        int result = -1;
        for (int i = 1; i <= 500; i++) {
            if (freq[i] == i) {
                result = i;
            }
        }

        return result;

    }
}