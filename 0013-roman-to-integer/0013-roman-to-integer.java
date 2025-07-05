class Solution {
    public int romanToInt(String s) {
        // ⏱ Time Complexity: O(n)
        // — One pass through the string of length n

        // \U0001f9e0 Space Complexity: O(1)
        // — Only a fixed-size array of 26 characters (no dynamic structures)

        // Map each Roman numeral to its integer value
        int[] values = new int[26]; // 'A' to 'Z'
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int total = 0;
        int prev = 0;

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = values[s.charAt(i) - 'A'];

            if (curr < prev) {
                total -= curr; // Subtractive case
            } else {
                total += curr; // Normal addition
            }

            prev = curr;
        }

        return total;
    }
}