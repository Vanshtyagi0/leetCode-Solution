class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] check = new boolean[26];

        for(char ch : sentence.toCharArray()){
            check[ch - 'a'] = true;
        }

        for(boolean isPangram : check){
            if(!isPangram) return false;
        }

        return true;
    }
}