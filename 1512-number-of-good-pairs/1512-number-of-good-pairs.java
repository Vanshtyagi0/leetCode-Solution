class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[100];
        for(int num : nums){
            freq[num - 1]++;
        }

        int good = 0;
        for(int count : freq){
            if(count == 0 || count == 1) continue;
            good += (count * (count - 1) / 2);
        }
        return good;
    }
}