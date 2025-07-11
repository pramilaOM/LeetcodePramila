class Solution {
    public boolean isPalindrome(String s) {
        //myself
        String withoutws = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = withoutws.length()  - 1;
        while (start < end) {
            if (withoutws.charAt(start) == withoutws.charAt(end)) {
                start++;
                end--;
            } else {

                return false;
            }
        }
        return true;
    }
}