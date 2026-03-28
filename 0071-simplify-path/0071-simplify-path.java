class Solution {
    public String simplifyPath(String path) {
        //https://www.youtube.com/watch?v=ZV-Hi1e1KL8

        List<String> st = new ArrayList<>();
        
        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) continue;

            if (!token.equals("..")) {
                st.add(token);
            } else if (!st.isEmpty()) {
                st.remove(st.size() - 1);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : st) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}