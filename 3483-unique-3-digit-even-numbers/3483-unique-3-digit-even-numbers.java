class Solution {
    public int totalNumbers(int[] digits) {
        
        int result = 0;
        int[] freq = new int[10];
        for(int digit : digits){
            freq[digit]++;
        }
        for(int i = 100; i <= 998; i += 2){
            if(canForm(freq, i)){
                result++;
            }
        }

        return result;
    }

    private boolean canForm(int[] freq, int digit){
        int h = digit / 100;
        int t = (digit / 10) % 10;
        int o = digit % 10;

        int[] newFreq = new int[10];
        newFreq[h]++;
        newFreq[t]++;
        newFreq[o]++;

        for(int i = 0; i < 10; i++){
            if(newFreq[i] > freq[i]){
                return false;
            }
        }

        return true;
    }
}