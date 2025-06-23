class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }
        }
        return result;
    }
}