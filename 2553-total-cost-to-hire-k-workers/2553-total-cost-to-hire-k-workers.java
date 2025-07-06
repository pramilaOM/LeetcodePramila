class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int n = costs.length, i = 0, j = n - 1;

        while (left.size() < candidates && i <= j) {
            left.add(costs[i++]);
        }

        while (right.size() < candidates && i <= j) {
            right.add(costs[j--]);
        }

        long totalCost = 0;
        for (int hired = 0; hired < k; hired++) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                totalCost += left.poll();
                if (i <= j) {
                    left.add(costs[i++]);
                }
            } else {
                totalCost += right.poll();
                if (i <= j) {
                    right.add(costs[j--]);
                }
            }
        }
        return totalCost;
    }
}