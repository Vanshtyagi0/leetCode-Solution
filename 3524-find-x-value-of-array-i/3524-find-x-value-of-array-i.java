class Solution {
    public long[] resultArray(int[] nums, int k) {
        
         int n = nums.length;

        long[][] dp = new long[n][k];
        long[] result = new long[k];

        for (int i = 0; i < n; i++) {

            int val = nums[i] % k;

            // Subarray containing only nums[i]
            dp[i][val]++;

            // Extend subarrays ending at i - 1
            if (i > 0) {
                for (int r = 0; r < k; r++) {

                    if (dp[i - 1][r] == 0) {
                        continue;
                    }

                    int newRemainder =
                        (int) (((long) r * val) % k);

                    dp[i][newRemainder] += dp[i - 1][r];
                }
            }

            // Add all subarrays ending at i
            for (int r = 0; r < k; r++) {
                result[r] += dp[i][r];
            }
        }

        return result;
    }
}