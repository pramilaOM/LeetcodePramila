class Solution {
    public String simplifyPath(String path) {
        //https://www.youtube.com/watch?v=ZV-Hi1e1KL8

        Stack<String> st = new Stack<>();
        
        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) continue;

            if (!token.equals("..")) {
                st.push(token);
            } else if (!st.isEmpty()) {
                st.pop();
            }
        }

        String result = "";

        while (!st.isEmpty()) {
            result = "/" + st.pop() + result;
        }

        return result.isEmpty() ? "/" : result;
    }
}