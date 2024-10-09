class Solution {
    public int compress(char[] chars) {
         int idx = 0;
         int i = 0;

         while(i < chars.length){
            char currentChar = chars[i];
            int count = 0;

            while(i < chars.length && chars[i] == currentChar){
                i++;
                count++;
            }

            chars[idx++] = currentChar;

            if(count > 1){
                String currStr = String.valueOf(count);
                for(int j = 0; j < currStr.length(); j++){
                    chars[idx++] = currStr.charAt(j);
                }
            }
         }
         return idx;
    }
}
