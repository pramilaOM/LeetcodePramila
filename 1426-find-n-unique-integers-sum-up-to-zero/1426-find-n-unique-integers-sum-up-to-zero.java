class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int start = 1;
        int i = 0;
        while (i + 1 < n) {
            result[i] = start;
            result[i + 1] = -start;
            start++;
            i += 2;

        }
        return result;
    }
}