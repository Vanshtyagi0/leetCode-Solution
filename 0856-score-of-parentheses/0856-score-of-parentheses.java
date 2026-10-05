class Solution {
    public int scoreOfParentheses(String s) {
        
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        st.push(0);

        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(0);
            }
            else{
                int inner = st.pop();
                int score = (inner == 0) ? 1 : inner * 2;
                int outer = st.pop();

                st.push(outer + score);
            }
        }

        return st.pop();
    }
}