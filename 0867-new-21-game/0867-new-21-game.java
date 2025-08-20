class Solution {
    public double new21Game(int n, int k, int maxPts) {
                double[] P = new double[n + 1];   // P[i] = probability of total score == i
        P[0] = 1.0;

        double windowSum = (k > 0) ? 1.0 : 0.0;  // sum of last maxPts probabilities for states < k
        for (int i = 1; i <= n; i++) {
            P[i] = windowSum / maxPts;

            if (i < k) {                 // while still drawing, include P[i] in the window
                windowSum += P[i];
            }
            // remove P[i - maxPts] from window if it was part of the “drawing” range
            if (i - maxPts >= 0 && i - maxPts < k) {
                windowSum -= P[i - maxPts];
            }
        }

        double ans = 0.0;
        for (int i = k; i <= n; i++) ans += P[i];  // sum probabilities of terminal states
        return ans;
    }
}