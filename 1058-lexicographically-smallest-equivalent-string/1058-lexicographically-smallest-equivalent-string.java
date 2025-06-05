class Solution {

    private char DFS(Map<Character, List<Character>> adj, char curr, boolean[] visited) {
        visited[curr - 'a'] = true;
        char minChar = curr;

        for (char neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visited[neighbor - 'a']) {
                char nextMin = DFS(adj, neighbor, visited);
                if (nextMin < minChar) {
                    minChar = nextMin;
                }
            }
        }
        return minChar;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, List<Character>> adj = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            boolean[] visited = new boolean[26];
            result.append(DFS(adj, ch, visited));
        }

        return result.toString();
    }
}