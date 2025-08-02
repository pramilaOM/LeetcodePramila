class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char mag : magazine.toCharArray()) {
            map.put(mag, map.getOrDefault(mag, 0) + 1);
        }
        for (char ran : ransomNote.toCharArray()) {
            map2.put(ran, map2.getOrDefault(ran, 0) + 1);
        }
        return map.equals(map2);

    }
}