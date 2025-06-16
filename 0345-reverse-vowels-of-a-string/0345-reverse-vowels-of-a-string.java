class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int len = s.length();
        int start = 0, end = len - 1;
        while (start < end) {
            if (!isVowel(c[start])) {
                start++;
            } else if (!isVowel(c[end])) {
                end--;
            } else {
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }

        }
        return new String(c);

    }
    private static boolean isVowel(char charAt) {
        // TODO Auto-generated method stub
        if (charAt == 'a' || charAt == 'e' || charAt == 'i' || charAt == 'o' || charAt == 'u' || charAt == 'A'
                || charAt == 'E' || charAt == 'I' || charAt == 'O' || charAt == 'U') {
            return true;
        }
        return false;
    }
}