class Solution {
    public int uniquePaths(int m, int n) {
        // Formula: C(m+n-2, m-1) = (m+n-2)! / ((m-1)! * (n-1)!)
        long res = 1;
        int total = m + n - 2;
        int k = Math.min(m - 1, n - 1); // choose the smaller to reduce iterations

        for (int i = 1; i <= k; i++) {
            res = res * (total - k + i) / i;
        }

        return (int) res;
    }
}
