class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int p = 0;

        // Find the index of 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                p = i;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Case 1: Circularly increasing
        boolean inc = true;

        for (int i = 0; i < n; i++) {
            if (nums[(p + i) % n] != i) {
                inc = false;
                break;
            }
        }

        if (inc) {
            ans = Math.min(ans,
                    Math.min(p, n - p + 2));
        }

        // Case 2: Circularly decreasing
        boolean dec = true;

        for (int i = 0; i < n; i++) {
            if (nums[(p - i + n) % n] != i) {
                dec = false;
                break;
            }
        }

        if (dec) {
            ans = Math.min(ans,
                    1 + Math.min(n - 1 - p, p + 1));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
