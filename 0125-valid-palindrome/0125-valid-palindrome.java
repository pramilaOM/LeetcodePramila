//https://www.youtube.com/watch?v=rYyn9Vc-dBQ

class Solution {
    public boolean isPalindrome(String s) {
        //two pointers

        //Remove unwanted characters (spaces, punctuation, symbols).Keep only letters and digits fixedString = "AMANAPLANACANALPANAMA"
        String fixedString = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                fixedString += c;
            }
        }

        fixedString = fixedString.toUpperCase();

        int start = 0;
        int end = fixedString.length() - 1;

        while (start <= end) {
            if (fixedString.charAt(start) != fixedString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}