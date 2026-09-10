class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 1];
        dp[0] = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < n; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            dp[i + 1] = Math.max(currSum, dp[i]);
        }
        return dp[n];
    }
}