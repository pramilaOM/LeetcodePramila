class Solution {
    public int maxFrequencyElements(int[] nums) {

        int[] arr = new int[101];
        int maxFreq = 0;
        for (int num : nums) {
            arr[num]++;
            maxFreq = Math.max(maxFreq, arr[num]);
        }
        final int finalMaxFreq = maxFreq;
        return (int) Arrays.stream(arr).filter(count -> count == finalMaxFreq).count() * finalMaxFreq;
    }
}