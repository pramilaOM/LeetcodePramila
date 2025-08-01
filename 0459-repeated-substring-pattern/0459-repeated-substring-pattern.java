class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int l = n / 2; l >= 1; l--) {
            if (n % l == 0) {
                int times = n / l;
                String pattern = s.substring(0, l);
                StringBuilder sb = new StringBuilder();
                while (times > 0) {
                    sb.append(pattern);
                    times--;
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}