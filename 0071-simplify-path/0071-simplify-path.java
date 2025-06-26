class Solution {
    public String simplifyPath(String path) {
        //BF: Time Complexity: O(n) n = length of path,  Space Complexity: O(n) for storing path components in the list

        // .split("/") breaks the path at slashes, automatically handling //.
        // "." is ignored as it means current directory.
        // ".." removes the last valid directory from the list (goes up).
        // Any other string is treated as a valid directory name (like "...").
        // Finally, join the parts with '/' and prefix with '/' to form the canonical path.

        String[] arr = path.split("/");
        List<String> ans = new ArrayList<>();

        for (String a : arr) {
            if (a.equals(".") || a.equals("")) {
                continue;
            } else if (a.equals("..")) {
                if (!ans.isEmpty()) {
                    ans.remove(ans.size() - 1);
                }
            } else {
                ans.add(a);
            }
        }
        return "/" + String.join("/", ans);

    }
}