class Solution {
    private final int[][] serves = { {100, 0}, {75, 25}, {50, 50}, {25, 75} };
    private double[][] t;

    private double solve(double A, double B) {
        if (A <= 0 && B <= 0) return 0.5;
        if (A <= 0) return 1.0;
        if (B <= 0) return 0.0;

        int iA = (int) A, iB = (int) B; // indices for memo table
        if (t[iA][iB] != -1.0) return t[iA][iB];

        double probability = 0.0;
        for (int[] p : serves) {
            double aServe = p[0];
            double bServe = p[1];
            probability += 0.25 * solve(A - aServe, B - bServe);
        }
        return t[iA][iB] = probability;
    }

    public double soupServings(int n) {
        if (n >= 5000) return 1.0;

        t = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(t[i], -1.0);
        }
        return solve(n, n);
    }
}
