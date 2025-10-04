class Solution {
    public int maxArea(int[] height) {
        //bf
        int n = height.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > max) {
                    max =area;
                }

            }
        }
        return max;
    }
}