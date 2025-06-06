class Solution {
    public String robotWithString(String s) {

        int[] charCount = new int[26];
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        char minChar = 'a';

        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']--;

            while (minChar < 'z' && charCount[minChar - 'a'] == 0) {
                minChar++;
            }

            stack.push(ch);

            while (!stack.isEmpty() && stack.peek() <= minChar) {
                answer.append(stack.pop());
            }
        }
        return answer.toString();

    }
}