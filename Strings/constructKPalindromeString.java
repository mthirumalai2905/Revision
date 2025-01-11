import java.util.HashMap;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int freq : charCount.values()) {
            if (freq % 2 != 0) oddCount++;
        }

        return oddCount <= k;
    }
}
