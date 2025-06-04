class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        HashSet<Integer> freq = new HashSet<>();

        for (int a : map.values()) {
            if (freq.contains(a)) {
                return false;
            }
            freq.add(a);
        }

        return true;
    }
}