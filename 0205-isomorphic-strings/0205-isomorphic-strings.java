class Solution {
    public boolean isIsomorphic(String s, String t) {
        //brute force

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char chS = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == chS) {
                    if (t.charAt(i) != t.charAt(j)) {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            char chT = t.charAt(i);
            for (int j = i + 1; j < n; j++) {
                if (t.charAt(j) == chT) {
                    if (s.charAt(i) != s.charAt(j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}