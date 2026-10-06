class Solution {
    public int minAddToMakeValid(String s) {
        int operation = 0;
        int insertOpen = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(') operation++;
            else if(ch == ')' && operation > 0) operation--;
            else insertOpen++;
        }

        return insertOpen + operation;
    }
}