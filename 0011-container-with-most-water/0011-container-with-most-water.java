class Solution {
    public int maxArea(int[] height) {
        //https://www.youtube.com/watch?v=KVU4JNNJkVg

        int area = Integer.MIN_VALUE;

        int start = 0, end = height.length - 1;
        while (start <= end) {

            int h = Math.min(height[start], height[end]);
            int width = end - start;
            area = Math.max(area, h * width);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }

        }

        return area;

    }
}