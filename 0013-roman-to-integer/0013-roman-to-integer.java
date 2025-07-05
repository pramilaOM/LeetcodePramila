class Solution {
    public int romanToInt(String s) {
        // ⏱ Time Complexity:
        // O(n) — where n = s.length() (scan each character once)

        // \U0001f9e0 Space Complexity:
        // O(1) — uses a fixed-size map (at most 7 Roman characters)

        // Step 1: Map Roman symbols to values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int total = 0;
        int i = 0;

        // Step 2: Traverse the string from left to right
        while (i < s.length()) {
            int curr = roman.get(s.charAt(i));

            // Step 3: Check if a subtraction pair exists
            if (i + 1 < s.length()) {
                int next = roman.get(s.charAt(i + 1));

                if (next > curr) {
                    total += (next - curr); // subtractive pair
                    i += 2; // skip next char
                    continue;
                }
            }

            // Step 4: Add normal value
            total += curr;
            i++;
        }

        return total;
    }
}