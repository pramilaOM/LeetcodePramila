class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;

        // Step 2: Check for x and x+1 pairs
        for (int num : freq.keySet()) {
            if (freq.containsKey(num + 1)) {
                int len = freq.get(num) + freq.get(num + 1);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
        
    }
}