class Solution {
    int n;
    int[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        n = events.length;
        dp = new int[n][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(events, 0, k);
    }

    int solve(int[][] events, int i, int k) {
        if (k == 0 || i == n) {
            return 0;
        }

        if (dp[i][k] != -1) {

            return dp[i][k];
        }

        int nextIndex = findNext(events, events[i][1]);

        int take = events[i][2] + solve(events, nextIndex, k - 1);
        int skip = solve(events, i + 1, k);

        dp[i][k] = Math.max(take, skip);
        return dp[i][k];
    }

    int findNext(int[][] events, int endTime) {
        int low = 0, high = n;
        while (low < high) {
            int mid = (low + high) / 2;

            if (events[mid][0] <= endTime) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}