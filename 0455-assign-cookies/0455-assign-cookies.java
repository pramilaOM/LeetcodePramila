class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0, count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                count++;
            }
            j++;

        }
        return count;
    }
}