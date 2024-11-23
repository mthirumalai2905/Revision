import java.util.*;

public class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int countEnd = 0;
        int countPrefix = 0;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
            node.countPrefix++;
        }
        node.countEnd++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) return 0;
            node = node.children[ch - 'a'];
        }
        return node.countEnd;
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) return 0;
            node = node.children[ch - 'a'];
        }
        return node.countPrefix;
    }

    public void erase(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) return;
            node = node.children[ch - 'a'];
            node.countPrefix--;
        }
        node.countEnd--;
    }
}
