class Solution {
    public String reverseParentheses(String s) {
        
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {

                // Save the string built before '('
                stack.push(curr);

                // Start building inside parentheses
                curr = new StringBuilder();

            } else if (ch == ')') {

                // Reverse current parentheses content
                curr.reverse();

                // Get string before '('
                StringBuilder prev = stack.pop();

                // Append reversed content
                prev.append(curr);

                curr = prev;

            } else {

                curr.append(ch);
            }
        }

        return curr.toString();
    }
}