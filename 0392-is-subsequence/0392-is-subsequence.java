class Solution {
    public boolean isSubsequence(String s, String t) {
        //http://youtube.com/watch?v=r51_ZifUdvU
        int m = s.length();
        int n = t.length();
        //follow up question
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(t.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int prev = -1;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            List<Integer> indices = map.get(c);
            int index = Collections.binarySearch(indices, prev + 1);

            if (index < 0) {
                index = -index - 1;
            }

            if (index == indices.size()) {
                return false;
            }

            prev = indices.get(index);

        }
        return true;
    }
}