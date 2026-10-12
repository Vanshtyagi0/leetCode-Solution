class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;

        int[] count = new int[32];

        // Step 1: Count set bits at every position
        for (int num : nums) {
            for (int bit = 0; bit < 32; bit++) {
                if ((num & (1L << bit)) != 0) {
                    count[bit]++;
                }
            }
        }

        long ans = 0;

        // Step 2: Construct k largest possible numbers
        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int bit = 0; bit < 32; bit++) {
                if (count[bit] > 0) {
                    num |= (1L << bit);
                    count[bit]--;
                }
            }

            // Step 3: Add square to the answer
            ans = (ans + (num * num) % MOD) % MOD;
        }

        return (int) ans;
    }
}
