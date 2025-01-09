class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int start = 0;
        int curr = 0;

        for (int end = 0; end < arr.length; end++) {
            curr += arr[end]; 
            
            while (curr > target && start <= end) {
                curr -= arr[start];
                start++;
            }

            if (curr == target) {
                return new ArrayList<>(Arrays.asList(start + 1, end + 1));
            }
        }

        return new ArrayList<>(Arrays.asList(-1));
    }
}
