class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int n = startTime.length;
        int[] freeArray = new int[n + 1];

        freeArray[0] = startTime[0];

        for (int i = 1; i < n; i++) {
            freeArray[i] = startTime[i] - endTime[i - 1];
        }

        freeArray[n] = eventTime - endTime[n - 1];

        int maxSum = 0;
        int currSum = 0;
        int left = 0;

        for (int right = 0; right < freeArray.length; right++) {
            currSum += freeArray[right];

            while (right - left + 1 > k + 1) {
                currSum -= freeArray[left];
                left++;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}