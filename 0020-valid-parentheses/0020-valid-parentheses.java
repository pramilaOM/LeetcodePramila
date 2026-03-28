class Solution {
    public boolean isValid(String s) {
        //https://www.youtube.com/watch?v=3ssh_mk4LqY
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(')');
            } else if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            } else if (st.isEmpty() || st.peek() != ch) {
                return false;
            } else {
                st.pop();
            }
        }

        return st.isEmpty();
    }
}