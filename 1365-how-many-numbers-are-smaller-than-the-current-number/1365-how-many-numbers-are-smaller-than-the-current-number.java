class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];

        for(int num : nums){
            freq[num]++;
        }

        for(int i = 1; i < 101; i++){
            freq[i] += freq[i - 1];
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = nums[i] == 0 ? 0 : freq[nums[i] - 1];
        }

        return result;
    }
}