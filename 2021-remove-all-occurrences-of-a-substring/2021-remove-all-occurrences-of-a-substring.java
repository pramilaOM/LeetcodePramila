class Solution {
    public String removeOccurrences(String s, String part) {

        int partLen = part.length();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= partLen) {
                boolean ismatch = true;
                for (int i = 0; i < partLen; i++) {
                    if (stack.get(stack.size() - partLen + i) != part.charAt(i)) {
                        ismatch = false;
                        break;
                    }
                }

                if (ismatch) {
                    for (int i = 0; i < partLen; i++) {
                        stack.pop();
                    }
                }

            }
        }
        StringBuilder str = new StringBuilder();
        for (char c : stack) {
            str.append(c);
        }

        return str.toString();
    }
}