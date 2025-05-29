class Solution {
    public boolean closeStrings(String word1, String word2) {
        
          int s1 = word1.length();
        int s2 = word2.length();
        if (s1 != s2) {
            return false;
        }

        HashMap<Character, Integer> word1Map = new HashMap<>();
        HashMap<Character, Integer> word2Map = new HashMap<>();

        for (char c : word1.toCharArray()) {

            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);

        }
        for (char c : word2.toCharArray()) {
            word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);

        }

        if (!word1Map.keySet().equals(word2Map.keySet())) {
            return false;
        }

        ArrayList<Integer> fre1 = new ArrayList<>(word1Map.values());
        ArrayList<Integer> fre2 = new ArrayList<>(word2Map.values());

        Collections.sort(fre1);
        Collections.sort(fre2);

        return fre1.equals(fre2);

    }
}