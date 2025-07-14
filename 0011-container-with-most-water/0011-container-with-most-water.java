class Solution {
    public int maxArea(int[] height) {
        //optimized
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int left = 0, right = n - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(area,max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return max;
    }
}