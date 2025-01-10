class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int n = words1.length;
        int m = words2.length;

        int[] bMaxFreq = new int[26];

        for (int i = 0; i < m; i++) {
            int[] bArr = new int[26];
            for (char ch : words2[i].toCharArray()) {
                int idx = ch - 'a';
                bArr[idx]++;
                bMaxFreq[idx] = Math.max(bMaxFreq[idx], bArr[idx]);
            }
        }

        for (int i = 0; i < n; i++) {
            int[] aArr = new int[26];
            for (char ch : words1[i].toCharArray()) {
                aArr[ch - 'a']++;
            }

            if (checkSubset(bMaxFreq, aArr)) {
                list.add(words1[i]);
            }
        }

        return list;
    }

    boolean checkSubset(int[] bArr, int[] aArr) {
        for (int i = 0; i < 26; i++) {
            if (bArr[i] > aArr[i]) {
                return false;
            }
        }
        return true;
    }
}
