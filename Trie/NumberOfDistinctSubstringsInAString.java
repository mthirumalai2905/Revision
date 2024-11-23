import java.util.ArrayList;

public class Solution 
{
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];  
            isEndOfWord = false;
        }
    }

    private static void insertSuffix(TrieNode root, String suffix) {
        TrieNode current = root;
        for (char ch : suffix.toCharArray()) {
            int idx = ch - 'a'; 
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEndOfWord = true;  
    }

    public static int countDistinctSubstrings(String s) {
        TrieNode root = new TrieNode();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            TrieNode current = root;
            for (char ch : suffix.toCharArray()) {
                int idx = ch - 'a';  
                if (current.children[idx] == null) {
                    current.children[idx] = new TrieNode();
                    cnt++;  
                }
                current = current.children[idx];
            }
            current.isEndOfWord = true; 
        }
        return cnt + 1;  
    }
}
