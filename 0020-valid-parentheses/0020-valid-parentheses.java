class Solution {
    public boolean isValid(String s) {
//Use a stack to track opening brackets.
// For every character in the string:
// If it's an opening bracket ((, [, {), push it onto the stack.
// If it's a closing bracket (), ], }), check:
// If the stack is empty, it's invalid (no matching open).
// Pop from stack and verify that it matches the closing bracket.
// At the end, the stack should be empty if all brackets were valid and matched.
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
}