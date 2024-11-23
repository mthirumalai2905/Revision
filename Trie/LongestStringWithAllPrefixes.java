import java.util.*;
import java.io.*;

class Solution {
  static class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
      children = new TrieNode[26];
      isEndOfWord = false;
    }
  }

  private static void insert(TrieNode root, String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      int idx = ch - 'a'; 
      if (current.children[idx] == null) {
        current.children[idx] = new TrieNode();
      }
      current = current.children[idx];
    }
    current.isEndOfWord = true;
  }

  private static boolean hasAllPrefixes(TrieNode root, String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      int idx = ch - 'a';
      if (current.children[idx] == null) {
        return false; 
      }
      current = current.children[idx];
      if (!current.isEndOfWord) {
        return false; 
      }
    }
    return true; 
  }

  public static String completeString(int n, String[] a) {
    TrieNode root = new TrieNode();

    for (String str : a) {
      insert(root, str);
    }

    String result = "";

    for (String str : a) {
      if (hasAllPrefixes(root, str) && str.length() > result.length()) {
        result = str; 
      }
    }

    if (result.isEmpty()) {
      return "None";
    } else {
      return result;
    }
  }

  public static void main(String[] args) {
    String[] a = {"ab", "abc", "a", "bp"};
    System.out.println(completeString(a.length, a)); 
  }
}
