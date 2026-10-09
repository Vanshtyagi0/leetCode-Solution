class Solution {
    public int minInsertions(String s) {
        
        int n = s.length();
        int ans = 0;
        int open = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{

                if(i + 1 < n && s.charAt(i + 1) == ')') i++;
                else ans++;

                if(open > 0) open--;
                else ans++;
            }
        }
        ans += open * 2;
        return ans;
    }
}