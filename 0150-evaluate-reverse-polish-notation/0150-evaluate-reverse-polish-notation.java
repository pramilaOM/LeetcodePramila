class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();

                result = operator(b, a, token);
                stack.push(result);

            } else {
                stack.push(Integer.parseInt(token));

            }
        }
        return stack.pop();

    }

    public static int operator(int b, int a, String token) {
        // TODO Auto-generated method stub
        if (token.equals("+")) {
            return b + a;
        }

        if (token.equals("-")) {
            return b - a;
        }

        if (token.equals("*")) {
            return b * a;
        }

        if (token.equals("/")) {
            return b / a;
        }

        return -1;
    }
}