import java.util.HashMap;

class Solution {
    public int maxLen(int[] arr) {
        int n = arr.length;
        int curr = 0;
        int mx = 0;  
        HashMap<Integer, Integer> map = new HashMap<>();

      
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {
            curr += arr[i]; 

            if (curr == 0) {
                mx = i + 1;
            }

            if (map.containsKey(curr)) {
                mx = Math.max(mx, i - map.get(curr));
            } else {
                map.put(curr, i);
            }
        }

        return mx;
    }
}
