class Solution {
    //myself
    public String firstPalindrome(String[] words) {
        String ans = "";
        for (String s : words) {
            int len = s.length();
            int first = 0;
            int last = len - 1;
            if (isPalindrome(first, last, s)) {
                ans = s;
                break;
            }

        }
        return ans;
    }

    private static boolean isPalindrome(int first, int last, String s) {
        while (first < last) {
            if (s.charAt(first) == s.charAt(last)) {
                first++;
                last--;
            } else {
                return false;
            }
        }
        return true;
    }
}