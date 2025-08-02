class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;

    int getChildrenCount() {
        int count = 0;
        for (TrieNode child : children) {
            if (child != null)
                count++;
        }
        return count;
    }

    TrieNode getSingleChild() {
        for (TrieNode child : children) {
            if (child != null)
                return child;
        }
        return null;
    }

    int getSingleChildIndex() {
        for (int i = 0; i < 26; i++) {
            if (children[i] != null)
                return i;
        }
        return -1;
    }
}

class Solution {
    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        for (String word : strs) {
            insert(word);
        }

        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        while (node.getChildrenCount() == 1 && !node.isEndOfWord) {
            int index = node.getSingleChildIndex();
            node = node.children[index];
            prefix.append((char) (index + 'a'));
        }
        return prefix.toString();
    }
}