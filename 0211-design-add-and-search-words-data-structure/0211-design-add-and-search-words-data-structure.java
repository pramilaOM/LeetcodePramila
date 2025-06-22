class WordDictionary {
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;

        }
    }

    private TrieNode root;

    private TrieNode getNode() {
        return new TrieNode();
    }

    public WordDictionary() {
        root = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = getNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;

    }

    boolean searchUtil(TrieNode root, String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            if(ch =='.'){
                for(int j = 0;j<26;j++){
                    if (crawler.children[j] != null) {
                 if(searchUtil(crawler.children[j], word.substring(i+1))){
                    return true;
                 }
            }
                }
                return false;
            }
            else{
if (crawler.children[ch -'a'] == null) {
                return false;
            }
            
            
            crawler = crawler.children[ch-'a'];
        }
        }
        return crawler != null && crawler.isEndOfWord;
    }

    public boolean search(String word) {
        return searchUtil(root, word);

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */