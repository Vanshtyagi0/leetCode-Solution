class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[2 * n];

        int p1 = 0;
        int p2 = n;
        int k = 0;

        while(p2 < 2 * n){
            shuffled[k] = nums[p1];
            shuffled[k + 1] = nums[p2];

            k += 2;
            p1++;
            p2++;
        }

        return shuffled;
    }
}