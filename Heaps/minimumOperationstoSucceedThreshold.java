class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(num < k) pq.offer(num);
        }

        int ops = 0;

        while(!pq.isEmpty()){
            int x = pq.poll();
            ops++;

            if(pq.isEmpty()) break;

            int y = pq.poll();
            long newVal = 2L * x + y;

            if(newVal < k) pq.offer((int) newVal);
        }

        return ops;
    }
}
