class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
      int n = nums.length;
        if (k == n)
            return nums;

        // Pair: index and value
        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = i;      // index
            vec[i][1] = nums[i]; // value
        }

        // Sort by value descending
        Arrays.sort(vec, (a, b) -> Integer.compare(b[1], a[1]));

        // Then sort the top-k by original index to maintain order
        Arrays.sort(vec, 0, k, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = vec[i][1];
        }

        return result;  

    }
}