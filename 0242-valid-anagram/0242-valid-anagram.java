class Solution {
    public boolean isAnagram(String s, String t) {
        ArrayList<Character> s1 = new ArrayList<>();
        ArrayList<Character> t1 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            s1.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            t1.add(t.charAt(i));
        }
        Collections.sort(s1);
        Collections.sort(t1);
        return s1.equals(t1);

    }
}