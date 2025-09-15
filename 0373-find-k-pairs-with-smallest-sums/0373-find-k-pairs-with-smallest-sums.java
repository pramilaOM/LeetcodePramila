class Solution {
    static class Node {
        long sum;
        int i, j;

        Node(long sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0 || k <= 0)
            return result;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(b.sum, a.sum));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long sum = (long) nums1[i] + nums2[j];
                if (pq.size() < k) {
                    pq.offer(new Node(sum, i, j));
                } else if (pq.peek().sum > sum) {
                    pq.poll();
                    pq.offer(new Node(sum, i, j));
                } else {
                    break;
                }
            }
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            result.add(Arrays.asList(nums1[node.i], nums2[node.j]));
        }
        return result;
    }
}