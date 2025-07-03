class Solution {
    public char kthCharacter(int k) {
        // Start with word = "a"
        StringBuilder sb = new StringBuilder("a");

        // Keep applying the operation:
        // For each character in word, shift it to next letter (with wrap-around from z
        // to a)
        while (sb.length() < k) {
            StringBuilder shifted = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                char nextChar = (char) ((ch - 'a' + 1) % 26 + 'a'); // wrap-around
                shifted.append(nextChar);
            }

            // Append the shifted version to word
            sb.append(shifted);
        }
        // Stop once word.length() ≥ k

        // Return word.charAt(k - 1)
        return sb.charAt(k - 1);

    }
}