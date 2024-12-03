public class KMPAlgorithm {
    public static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0, i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }

    public static boolean kmpSearch(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                return true;
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        System.out.println(kmpSearch(text, pattern));
    }
}


// Follow-up Give the index of the matching
import java.util.ArrayList;

class Solution {

    ArrayList<ArrayList<Integer>> search(String pat, String txt) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] lps = computeLPS(pat);
        int i = 0, j = 0;
        
        while (i < txt.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == pat.length()) {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i - j + 1);
                indices.add(i);
                result.add(indices);
                j = lps[j - 1];
            } else if (i < txt.length() && txt.charAt(i) != pat.charAt(j)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    private int[] computeLPS(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        int len = 0, i = 1;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}
