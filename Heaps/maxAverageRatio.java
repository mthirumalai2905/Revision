import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double currentRatio = (double) pass / total;
            double improvement = ((double) (pass + 1) / (total + 1)) - currentRatio;
            pq.offer(new double[]{improvement, pass, total});
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            pass++;
            total++;
            double currentRatio = (double) pass / total;
            double improvement = ((double) (pass + 1) / (total + 1)) - currentRatio;
            pq.offer(new double[]{improvement, pass, total});
        }

        double totalRatio = 0.0;
        while (!pq.isEmpty()) {
            double[] cls = pq.poll();
            totalRatio += cls[1] / cls[2];
        }

        return totalRatio / classes.length;
    }
}
