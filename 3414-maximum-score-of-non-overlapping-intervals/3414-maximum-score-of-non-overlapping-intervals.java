class Solution {

    static class State {
        long weight;
        int[] indices;

        State(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // arr[i] = {left, right, weight, originalIndex}
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort according to starting point
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[3], b[3]);
        });

        // Store starting points for binary search
        int[] starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i][0];
        }

        // next[i] = first interval whose start > current end
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = upperBound(starts, arr[i][1]);
        }

        /*
         * dp[i][k]
         *
         * Best answer using intervals from i -> n-1
         * while selecting at most k intervals.
         */
        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new int[0]);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new int[0]);
        }

        // Build DP from right to left
        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: skip current interval
                State skip = dp[i + 1][k];

                // Option 2: take current interval
                State after = dp[next[i]][k - 1];

                long totalWeight = arr[i][2] + after.weight;

                int[] newIndices =
                        insertSorted(after.indices, arr[i][3]);

                State take =
                        new State(totalWeight, newIndices);

                dp[i][k] = better(take, skip);
            }
        }

        return dp[0][4].indices;
    }

    // First index such that starts[index] > target
    private int upperBound(int[] starts, int target) {

        int left = 0;
        int right = starts.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (starts[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Add original index while keeping indices sorted
    private int[] insertSorted(int[] arr, int value) {

        int[] result = new int[arr.length + 1];

        int i = 0;
        int j = 0;

        while (i < arr.length && arr[i] < value) {
            result[j++] = arr[i++];
        }

        result[j++] = value;

        while (i < arr.length) {
            result[j++] = arr[i++];
        }

        return result;
    }

    // Decide which state is better
    private State better(State a, State b) {

        // Higher weight is better
        if (a.weight > b.weight) {
            return a;
        }

        if (a.weight < b.weight) {
            return b;
        }

        // Same weight -> lexicographically smaller indices
        if (isLexicographicallySmaller(a.indices, b.indices)) {
            return a;
        }

        return b;
    }

    private boolean isLexicographicallySmaller(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] < b[i]) {
                return true;
            }

            if (a[i] > b[i]) {
                return false;
            }
        }

        // Example:
        // [1, 2] is smaller than [1, 2, 5]
        return a.length < b.length;
    }
}