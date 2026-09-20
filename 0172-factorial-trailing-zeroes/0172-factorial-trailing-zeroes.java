class Solution {
    public int trailingZeroes(int n) {
        
        int zero = 0;

        while(n > 0){
            int power = n / 5;
            zero += power;
            n /= 5;
        }

        return zero;
    }
}