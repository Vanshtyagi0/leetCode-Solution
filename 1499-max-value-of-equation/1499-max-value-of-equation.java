class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int j = 0; j < points.length; j++) {

            int x = points[j][0];
            int y = points[j][1];

            // Remove points outside the valid window
            while (!dq.isEmpty() &&
                   x - points[dq.peekFirst()][0] > k) {
                dq.pollFirst();
            }

            // Calculate answer using the best previous point
            if (!dq.isEmpty()) {
                int i = dq.peekFirst();

                max = Math.max(max,
                    points[i][1] - points[i][0] + y + x);
            }

            // Maintain decreasing order of (y - x)
            while (!dq.isEmpty() &&
                   points[dq.peekLast()][1] -
                   points[dq.peekLast()][0] <= y - x) {
                dq.pollLast();
            }

            // Add current point
            dq.offerLast(j);
        }

        return max;
    }
}
