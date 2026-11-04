class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n + n];

        for(int i = 0; i < 2 * n; i++){
            ans[i] = nums[(n + i) % n];
        }

        return ans;
    }
}