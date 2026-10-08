class Solution {
    public String removeOuterParentheses(String s) {
        
        int open = 0;
        int close = 0;
        StringBuilder result = new StringBuilder();

        int start = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(') open++;
            else close++;

            if(open == close){
                result.append(s.substring(start + 1, i));
                start = i + 1;
                open = 0;
                close = 0;
            }
        }

        return result.toString();
    }
}