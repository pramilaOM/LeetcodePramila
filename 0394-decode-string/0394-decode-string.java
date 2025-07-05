class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10  +(c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(current);
                }
                current = prev;
            } else {
                current.append(c);
            }
        }
        return current.toString();

    }
}