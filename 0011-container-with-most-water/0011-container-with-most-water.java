class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxHeight = 0;
        while (i < j) {
            int width = j - i;
            int h = Math.min(height[i], height[j]);
            int area = width * h;
            maxHeight = Math.max(area, maxHeight);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxHeight;

    }
}