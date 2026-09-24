class Solution {
    public int smallestIndex(int[] nums) {
        
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(isEqual(nums[i], i)){
                return i;
            }
        }

        return -1;
    }

    private boolean isEqual(int num, int i){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }

        return sum == i;
    }
}