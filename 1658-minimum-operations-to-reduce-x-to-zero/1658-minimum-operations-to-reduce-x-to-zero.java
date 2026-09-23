class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        int target = totalSum - x;

        if(target < 0){
            return -1;
        }

        int left = 0;
        int maxLen = -1;
        int currSum = 0;

        for(int right = 0; right < n; right++){
            currSum += nums[right];

            while(currSum > target && left <= right){
                currSum -= nums[left];
                left++;
            }

            if(currSum == target){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return (maxLen == -1) ? -1 : n - maxLen;
    }
}