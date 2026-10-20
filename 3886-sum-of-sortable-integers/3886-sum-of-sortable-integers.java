class Solution {
    public int sortableIntegers(int[] nums) {

        int n = nums.length;
        int ans = 0;

        // Find every divisor of n
        for (int k = 1; k <= n; k++) {

            if (n % k != 0) {
                continue;
            }

            if (isSortable(nums, k)) {
                ans += k;
            }
        }

        return ans;
    }

    private boolean isSortable(int[] nums, int k) {

        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        // Process blocks of length k
        for (int start = 0; start < n; start += k) {

            int end = start + k;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            int descents = 0;

            for (int i = start; i < end; i++) {

                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);

                // Circular next index
                int next = (i + 1 == end) ? start : i + 1;

                if (nums[i] > nums[next]) {
                    descents++;
                }

                if (descents > 1) {
                    return false;
                }
            }

            // Check global sorted order
            if (prevMax > min) {
                return false;
            }

            prevMax = max;
        }

        return true;
    }
}
