class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[]{-1, -1};
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);
        return ans;
    }

    private int search(int[] nums, int target, boolean isStartIndex){
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(target == nums[mid]){
                index = mid;

                if(isStartIndex){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return index;
    }
}