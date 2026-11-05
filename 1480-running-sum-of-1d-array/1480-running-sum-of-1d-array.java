class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0){
                prefixSum[i] = nums[i];
                continue;
            }
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return prefixSum;
    }
}