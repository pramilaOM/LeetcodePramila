class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 0, sum = 0, l = 0;
        for (int r = 0; r < fruits.length; r++) {
            sum += fruits[r][1];
            while (l <= r && !canReach(fruits[l][0], fruits[r][0], startPos, k)) {
                sum -= fruits[l][1];
                l++;
            }
            max = Math.max(max, sum);
        }
        return max;

    }

    public boolean canReach(int left, int right, int start, int k) {

        if (right <= start)
            return start - left <= k;
        if (left >= start)
            return right - start <= k;
        int leftDist = start - left, rightDist = right - start;
        int min = Math.min(2 * leftDist + rightDist, 2 * rightDist + leftDist);
        if (min <= k) {
            return true;
        }
        return false;
    }
}