class Solution {
    public int hIndex(int[] citations) {
          /**
         * Optimized Bucket Sort-based solution for H-Index problem.
         *
         * ✅ Logic to Remember:
         * - H-index = maximum h such that at least h papers have ≥ h citations.
         * - Citations range: 0 to 1000 → use counting instead of sorting.
         * - Bucket citations into a count array: count[i] = number of papers with i
         * citations.
         * - Group all citations ≥ n (number of papers) into count[n].
         * - Accumulate from high to low (n to 0) until you find the largest h
         * such that total papers with ≥ h citations is ≥ h.
         *
         * ✅ Time Complexity: O(n)
         * - One pass to count frequencies
         * - One reverse pass to find h-index
         *
         * ✅ Space Complexity: O(1)
         * - Uses fixed size count array (size 1001, due to constraint: 0 ≤ citations[i]
         * ≤ 1000)
         */
        int[] count = new int[5001]; // count[i] = number of papers with i citations
        int n = citations.length;

        // Step 1: Count how many papers have each citation count
        for (int citation : citations) {
            if (citation >= n) {
                count[n]++; // Group all values ≥ n into count[n]
            } else {
                count[citation]++;
            }
        }

        // Step 2: Accumulate from right to left to find the maximum h
        int total = 0; // Total papers with ≥ i citations
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i; // h-index found
            }
        }

        return 0; // No valid h-index found
        
    }
}