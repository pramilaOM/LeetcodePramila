class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int max = 0;
        for (int i = 1; i <= len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (citations[j] >= i) {
                    count++;
                }
            }
            if (count >= i) {
                max = i;
            }
        }
        return max;
    }
}