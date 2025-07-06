import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // Step 1: Sort potions for binary search
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];

            // Step 2: Binary search the first index where spell * potion >= success
            int left = 0, right = m - 1;
            int idx = m; // default: no potion is valid
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];
                if (product >= success) {
                    idx = mid;       // candidate found, look left
                    right = mid - 1;
                } else {
                    left = mid + 1;  // go right
                }
            }

            // Step 3: Count successful pairs = potions from idx to end
            result[i] = m - idx;
        }

        return result;
    }
}
