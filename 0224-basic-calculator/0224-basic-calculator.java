class Solution {
    public int calculate(String s) {
        //https://www.youtube.com/watch?v=3AEKyHx3tzU
         Stack<Integer> st = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = 10 * number + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;

                int top = st.pop();   // sign before '('
                result *= top;

                top = st.pop();       // result before '('
                result += top;
            }
        }

        result += sign * number;
        return result;
    }
}