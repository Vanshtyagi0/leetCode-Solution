class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        long total = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        if (total <= k) {
            return 0;
        }

        int low = 0;
        int high = maxDiff;

        while (low < high) {

            int mid = low + (high - low) / 2;
            long required = 0;

            for (int d : diff) {
                if (d > mid) {
                    required += d - mid;
                }
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int target = low;

        // Reduce all values greater than target
        for (int i = 0; i < n; i++) {
            if (diff[i] > target) {
                k -= diff[i] - target;
                diff[i] = target;
            }
        }

        // Use remaining operations
        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] == target) {
                diff[i]--;
                k--;
            }
        }

        long ans = 0;

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}
