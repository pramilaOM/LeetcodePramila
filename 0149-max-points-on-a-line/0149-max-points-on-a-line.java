class Solution {
    public int maxPoints(int[][] points) {

        if (points.length <= 2)
            return points.length;
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> mp = new HashMap<>();
            int dup = 1, curr = 0;

            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];

                if (x == 0 && y == 0) {
                    dup++;
                    continue;
                }
                int gcd = gcd(y, x);
                x /= gcd;
                y /= gcd;

                if (x < 0) {
                    x = -x;
                    y = -y;
                }
                String slope = y + "/" + x;
                mp.put(slope, mp.getOrDefault(slope, 0) + 1);
                curr = Math.max(curr, mp.get(slope));
            }
            max = Math.max(max, curr + dup);

        }
        return max;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}