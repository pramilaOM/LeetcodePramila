class Solution {
    public int minDeletionSize(String[] strs) {
        int size = strs.length;
        int eachWord = strs[0].length();
        int count = 0;
        for (int i = 0; i < eachWord; i++) {
            for (int j = 1; j < size; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    count++;
                    break;
                }
            }

        }
        return count;
    }
}