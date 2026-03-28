class Solution {
    public boolean isIsomorphic(String s, String t) {
        //https://www.youtube.com/watch?v=2ISNCDJEgqQ
        //https://www.youtube.com/watch?v=j5FQ4xEP3wY
        Map<Character, Character> mp1 = new HashMap<>();
        Map<Character, Character> mp2 = new HashMap<>();

        int m = s.length();

        for (int i = 0; i < m; i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if ((mp1.containsKey(ch1) && mp1.get(ch1) != ch2) ||
                    (mp2.containsKey(ch2) && mp2.get(ch2) != ch1)) {
                return false;
            }

            mp1.put(ch1, ch2);
            mp2.put(ch2, ch1);
        }

        return true;

    }
}