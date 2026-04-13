class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        return s.equals(sb.toString());
    }
}