class Solution {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;

        for(int[] banks : accounts){
            int moneyHave = 0;
            for(int money : banks){
                moneyHave += money;
            }

            richest = Math.max(richest, moneyHave);
        }

        return richest;
    }
}