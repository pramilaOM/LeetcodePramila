class Solution {
    public int lengthOfLongestSubstring(String s) {
        //https://www.youtube.com/watch?v=VvS_CtSIeiQ
        int i = 0, j = 0;
        int n = s.length();
        int maxLen = 0;
        List<Character> list = new ArrayList<Character>();
        while (j < n) {

            if (!list.contains(s.charAt(j))) {
                list.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen, list.size());

            } else {
                list.remove(Character.valueOf(s.charAt(i)));
                i++;

            }

        }
        return maxLen;
    }
}