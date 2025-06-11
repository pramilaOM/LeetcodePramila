class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;

        int[] prefiXSum = new int[arr.length];
        prefiXSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefiXSum[i] = prefiXSum[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j += 2) {
                if (i - 1 >= 0) {
                    sum = prefiXSum[j] + sum - prefiXSum[i - 1];
                } else {
                    sum = prefiXSum[j] + sum;
                }

            }
        }
        return sum;

    }
}