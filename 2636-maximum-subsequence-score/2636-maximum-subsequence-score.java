class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long maxScore = 0;
        
        // Step 1: Build (nums2, nums1) pairs and sort by nums2 DESC
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];  // as key for min
            pairs[i][1] = nums1[i];  // to use in sum
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]); // sort by nums2 desc

        // Step 2: Use min heap to keep top k nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int currNum1 = pairs[i][1];
            int currNum2 = pairs[i][0];

            minHeap.offer(currNum1);
            sum += currNum1;

            if (minHeap.size() > k) {
                sum -= minHeap.poll();  // remove smallest from sum
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * currNum2);
            }
        }

        return maxScore;
    }
}