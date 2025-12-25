class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        Arrays.sort(happiness);
        reverseArray(happiness);
        int count = 0;
        long result = 0;
        for (int i = 0; i < k; i++) {
            result += Math.max(happiness[i] - count, 0);
            count++;

        }

        return result;

    }

    private void reverseArray(int[] happiness) {
        int start = 0;
        int end = happiness.length - 1;
        while (start < end) {
            int temp = happiness[end];
            happiness[end] = happiness[start];
            happiness[start] = temp;
            start++;
            end--;

        }

    }
}