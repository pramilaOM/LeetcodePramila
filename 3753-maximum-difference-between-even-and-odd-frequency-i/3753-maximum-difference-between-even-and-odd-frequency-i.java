class Solution {
    public int maxDifference(String s) {
        char[] c = s.toCharArray();
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        Map<Character, Integer> data = new HashMap<>();
        for (char ch : c) {
            data.put(ch, data.getOrDefault(ch, 0) + 1);
        }

        for (int n : data.values()) {
            if (n % 2 != 0) {
                maxOdd = Math.max(maxOdd, n);
            } else {
                minEven = Math.min(n, minEven);
            }
        }

        return maxOdd - minEven;
    }
}