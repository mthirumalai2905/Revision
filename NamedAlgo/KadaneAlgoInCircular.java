class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currentMin = 0;

        for (int num : nums) {
            // Standard Kadane for max sum
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane for min sum
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            // Total sum of the array
            totalSum += num;
        }

        // If all elements are negative, return the maxSum
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of non-wrap and wrap cases
        return Math.max(maxSum, totalSum - minSum);
    }
}
