class Solution {
    //https://www.youtube.com/watch?v=BM-bu4tJz7U
    public int operate(int a, int b, String s) {
        if (s.equals("+"))
            return a + b;

        if (s.equals("-"))
            return a - b;

        if (s.equals("*"))
            return (int) ((long) a * (long) b);

        if (s.equals("/"))
            return a / b;

        return -1;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = st.pop();
                int a = st.pop();

                result = operate(a, b, s);
                st.push(result);
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
}