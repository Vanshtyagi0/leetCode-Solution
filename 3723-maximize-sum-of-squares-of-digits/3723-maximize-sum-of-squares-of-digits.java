class Solution {
    public String maxSumOfSquares(int num, int sum) {
        
        if(sum > 9 * num) return "";
        StringBuilder good = new StringBuilder();
        for(int i = 0; i < num; i++){
            int digit = Math.min(9, sum);
            good.append(digit);
            sum -= digit;
        }

        return good.toString();
    }
}