class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else if (token.equals("") || token.equals(".")) {
                continue;
            } else {
                stack.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }

        return sb.length() == 0 ? "/" : sb.toString();

    }
}