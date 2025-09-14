class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] t = new int[height + 1][height + 1];

        for (int level = height - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {

                t[level][i] = triangle.get(level).get(i) + Math.min(t[level + 1][i], t[level + 1][i + 1]);

            }
        }

        return t[0][0];
    }
}