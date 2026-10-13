class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[] sq = new long[n];

        for(int i = 0; i < n; i++){
            sq[i] = (long)nums[i] * nums[i];
        }

        Arrays.sort(sq);

        int ng = n / 2;
        long score = 0;

        for(int i = 0; i < n; i++){
            if(i < ng) score -= sq[i];
            else score += sq[i];
        }

        return score;
    }
}