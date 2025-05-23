class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> data = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            data.computeIfAbsent(key, k -> new ArrayList<>()).add(s);

        }

        return new ArrayList<>(data.values());

    }
}