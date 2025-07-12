class Solution {
    public boolean validPalindrome(String s) {

        int end = s.length() - 1;
        int start = 0;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(start + 1, end, s) || isPalindrome(start, end - 1, s);
            }
        }

        return true;
    }

    boolean isPalindrome(int first, int last, String s) {
        while (first < last) {
            if (s.charAt(first) != s.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}