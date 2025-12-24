class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        Arrays.sort(capacity);
        int totalApple = 0;
        for (int a : apple) {
            totalApple += a;
        }
        int i = capacity.length - 1, count = 0;
        while (totalApple > 0) {
            totalApple -= capacity[i];
            i--;
            count++;
        }
        return count;
    }
}