class Solution {
    public int hIndex(int[] citations) {
         // bf Time Complexity: O(n²)
        // For each of n possible h values, we scan the array (another n) to count valid
        // papers.

        // Space Complexity: O(1)
        // Only a few variables used for tracking.

        // Let n be the number of papers (length of the citations array).
        int n = citations.length;
        int max = 0;
        // h loops from 1 to n
        for (int i = 1; i <= n; i++) {//IMP
            // For each h, you count how many values in citations[] are ≥ h
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (citations[j] >= i) {
                    count++;
                }

            }
            // If count ≥ h, it's a valid H-index candidate
            if (count >= i) {
                max = i;
            }
        }

        return max;
        
    }
}