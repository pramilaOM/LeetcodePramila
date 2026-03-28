class Solution {
    public boolean wordPattern(String pattern, String s) {
        //https://www.youtube.com/watch?v=n0cn5tJwkaE
        //https://www.youtube.com/watch?v=b_pNf56VIqY
        String[] temp = s.split(" ");
        int n = pattern.length();

        if (temp.length != n) {
            return false;
        }

        HashMap<String, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(temp[i]) && !used.contains(pattern.charAt(i))) {
                used.add(pattern.charAt(i));
                map.put(temp[i], pattern.charAt(i));
            } else if (!map.containsKey(temp[i]) || map.get(temp[i]) != pattern.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}