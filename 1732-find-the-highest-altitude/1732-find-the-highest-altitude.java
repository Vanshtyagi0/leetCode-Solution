class Solution {
    public int largestAltitude(int[] gain) {
        int ha = 0;
        int altitude = 0;
        for(int val : gain){
            altitude += val;
            ha = Math.max(ha, altitude);
        }

        return ha;
    }
}