import java.util.Arrays;

class Solution {
    public int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceCows(stalls, cows, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean canPlaceCows(int[] stalls, int cows, int dist) {
        int count = 1, lastCowPos = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCowPos >= dist) {
                count++;
                lastCowPos = stalls[i];
                if (count == cows) {
                    return true;
                }
            }
        }
        return false;
    }
}
