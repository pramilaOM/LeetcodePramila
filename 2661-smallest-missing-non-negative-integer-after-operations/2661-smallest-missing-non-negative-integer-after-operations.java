class Solution {
    public int findSmallestInteger(int[] nums, int value) {
         Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            int remainder = num % value;
            // Handle negative remainders to ensure they are in [0, value-1]
            if (remainder < 0) {
                remainder += value;
            }
            counts.put(remainder, counts.getOrDefault(remainder, 0) + 1);
        }

        // Greedily try to form 0, 1, 2, ...
        int mex = 0;
        while (true) {
            int requiredRemainder = mex % value;
            if (counts.containsKey(requiredRemainder) && counts.get(requiredRemainder) > 0) {
                // If we have an element with the required remainder, use it
                counts.put(requiredRemainder, counts.get(requiredRemainder) - 1);
                mex++;
            } else {
                // If we can't form the current 'mex', then it's the smallest missing non-negative integer
                break;
            }
        }
        return mex;
    }
}