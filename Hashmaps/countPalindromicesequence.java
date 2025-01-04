class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        Set<Character> uniq = new HashSet<>();
        for(char ch : s.toCharArray()){
            uniq.add(ch);
        }
        for(char ch : uniq){
            int start = s.indexOf(ch);
            int end =  s.lastIndexOf(ch);

            if(start < end){
                Set<Character> set = new HashSet<>();
                for(int i = start + 1; i < end; i++){
                    set.add(s.charAt(i));
                }
                res += set.size();
            }
        }
        return res;
    }
}
