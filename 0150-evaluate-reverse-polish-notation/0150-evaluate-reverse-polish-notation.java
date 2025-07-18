class Solution {
    int operate(int a, int b, String token) {
        if (token.equals("+"))
            return a + b;
        if (token.equals("-"))
            return a - b;
        if (token.equals("*"))
            return a * b;
        if (token.equals("/"))
            return a / b;
        return -1;
   
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.peek();
                stack.pop();

                int a = stack.peek();
                stack.pop();

                int result = operate(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}