class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;

        for(char ch : s.toCharArray()){
           if(ch != '(' && ch != ')'){
            continue;
           }
           if(ch == '('){
            depth++;
            maxDepth = Math.max(maxDepth, depth);
           }
           else{
            depth--;
           }
        }

        return maxDepth;
    }
}