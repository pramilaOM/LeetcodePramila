class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length; int[] word = new int[n]; word[0] = 0;  

        for (int i = 1; i < n; i++) {
            int forbidden_mask = 0, assigned = -1;
            for (int j = 0; j < i; j++) {
                if (lcp[i][j] > 0) {
                    assigned = word[j];
                    break;
                } else if (lcp[i][j] == 0) {
                    forbidden_mask |= 1 << word[j];
                }
            }

            if (assigned != -1) {
                word[i] = assigned;
            } else {
                int letter = 0;
                while (letter < 26 && ((forbidden_mask >> letter) & 1) == 1) letter++;
                if (letter >= 26) return "";
                word[i] = letter;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] != word[j]) {
                    if (lcp[i][j] != 0) return "";
                } else {
                    if (i == n - 1 || j == n - 1) {
                        if (lcp[i][j] != 1) return "";
                    } else {
                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) return "";
                    }
                }
            }
        }

        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            res[i] = (char)('a' + word[i]);
        }
        
        return new String(res);
    }
}