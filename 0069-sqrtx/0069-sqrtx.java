class Solution {
    public int mySqrt(int n) {
        if(n == 0) return 0;
        double x = n;
        double root;
        while(true){
            root = 0.5 * (x + n / x);
            if(Math.abs(root - x) < 0.2){
                break;
            }

            x = root;
        }

        return (int) root;
    }
}
