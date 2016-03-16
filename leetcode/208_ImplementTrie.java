class TrieNode {
    public String val;
    public TrieNode[] next;
    // Initialize your data structure here.
    public TrieNode() {
        //val = 0;
        next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = insert(root, word, 0);
    }
    
    private TrieNode insert(TrieNode node, String word, int d){
        if(node == null) node = new TrieNode();
        if(d == word.length()) {
            node.val = word;
            return node; //all the characters in word are inserted in trie
        }
        int c = word.charAt(d);
        node.next[c-97] = insert(node.next[c-97], word, d+1);
        return node;
    } 
    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word, 0);
    }
    private boolean search(TrieNode node, String word, int d){
        if(node == null) return false;//word is too long
        if(d == word.length() && node.val != null) return true;//word has the exact length
        if(d == word.length() && node.val == null) return false;//word is too short
        int c = word.charAt(d);
        return search(node.next[c-97], word, d+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        //same logic with search, except return true even if prefix is too short
        return startsWith(root, prefix, 0);
    }
    private boolean startsWith(TrieNode node, String prefix, int d){
        if(node == null) return false;
        if(d == prefix.length()) return true;
        int c = prefix.charAt(d);
        return startsWith(node.next[c-97], prefix, d+1);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");