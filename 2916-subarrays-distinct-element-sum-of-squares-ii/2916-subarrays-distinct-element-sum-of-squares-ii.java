class Solution {
    static final long MOD = 1_000_000_007L;
    
    long[] sum;
    long[] squareSum;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();

        long ans = 0;

        for (int r = 0; r < n; r++) {
            int prev = lastSeen.getOrDefault(nums[r], -1);

            // Increment distinct counts for starts
            // in the range [prev + 1, r].
            update(1, 0, n - 1, prev + 1, r);

            // Sum of squares for all subarrays
            // ending at index r.
            ans = (ans + squareSum[1]) % MOD;

            lastSeen.put(nums[r], r);
        }

        return (int) ans;
    }

    private void apply(int node, int left, int right,
                       long val) {
        long len = right - left + 1;

        squareSum[node] = (
            squareSum[node]
            + 2L * val % MOD * sum[node] % MOD
            + len * val % MOD * val % MOD
        ) % MOD;

        sum[node] = (sum[node] + len * val) % MOD;

        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        apply(node * 2, left, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }

    private void update(int node, int left, int right,
                        int ql, int qr) {

        if (qr < left || right < ql) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr);
        update(node * 2 + 1, mid + 1, right, ql, qr);

        sum[node] = (
            sum[node * 2] + sum[node * 2 + 1]
        ) % MOD;

        squareSum[node] = (
            squareSum[node * 2]
            + squareSum[node * 2 + 1]
        ) % MOD;
    }
}
