class Solution {
    public int findMinArrowShots(int[][] points) {

        int n = points.length;
        if (n == 0)
            return 0;
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int[] prev = Arrays.copyOf(points[0], 2);
        int count = 1;

        for (int i = 1; i < n; i++) {
            int currStart = points[i][0];
            int currEnd = points[i][1];

            int prevStart = prev[0];
            int prevEnd = prev[1];

            if (currStart > prevEnd) {
                count++;
                prev = points[i];
            } else {
                prev[0] = Math.max(prevStart, currStart);
                prev[1] = Math.min(prevEnd, currEnd);
            }
        }
        return count;

    }
}