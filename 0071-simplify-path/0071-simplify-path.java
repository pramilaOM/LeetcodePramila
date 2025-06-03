class Solution {
    public String simplifyPath(String path) {

        List<String> stack = new ArrayList<>();

        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size()-1);
                }

            } else if (token.equals("") || token.equals(".")) {
                continue;
            } else {
                stack.add(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }

        return sb.length() == 0 ? "/" : sb.toString();

    }
}