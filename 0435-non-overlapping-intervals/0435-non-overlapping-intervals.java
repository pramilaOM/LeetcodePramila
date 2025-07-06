class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

         Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = Integer.MIN_VALUE;

        // Step 2: Greedily select non-overlapping intervals
        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                // No overlap, keep the interval
                prevEnd = interval[1];
                count++;
            }
            // Else, overlapping → skip (counted for removal)
        }

        // Total intervals - non-overlapping ones = number to remove
        return intervals.length - count;
        
    }
}