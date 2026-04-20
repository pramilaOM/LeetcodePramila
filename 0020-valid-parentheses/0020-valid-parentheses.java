class Solution {
    public boolean isValid(String s) {
        int prevLen;
        do {
            prevLen = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (s.length() != prevLen);

        return s.length() == 0;
    }
}