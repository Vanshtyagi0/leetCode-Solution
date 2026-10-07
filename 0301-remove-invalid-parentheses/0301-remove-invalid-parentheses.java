class Solution {

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum number of '(' and ')' that must be removed
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                leftRemove++;
            }
            else if (ch == ')') {

                if (leftRemove > 0) {
                    // Match this ')' with a previous '('
                    leftRemove--;
                }
                else {
                    // No '(' available to match this ')'
                    rightRemove++;
                }
            }
        }

        Set<String> result = new HashSet<>();

        backtrack(
            s,
            0,
            leftRemove,
            rightRemove,
            0,
            new StringBuilder(),
            result
        );

        return new ArrayList<>(result);
    }


    private void backtrack(
        String s,
        int index,
        int leftRemove,
        int rightRemove,
        int openCount,
        StringBuilder current,
        Set<String> result
    ) {

        // Processed entire string
        if (index == s.length()) {

            // We removed exactly the required parentheses
            // and every '(' has been matched
            if (leftRemove == 0 &&
                rightRemove == 0 &&
                openCount == 0) {

                result.add(current.toString());
            }

            return;
        }

        char ch = s.charAt(index);


        // -----------------------------
        // Option 1: Remove current char
        // -----------------------------

        if (ch == '(' && leftRemove > 0) {

            backtrack(
                s,
                index + 1,
                leftRemove - 1,
                rightRemove,
                openCount,
                current,
                result
            );
        }

        if (ch == ')' && rightRemove > 0) {

            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove - 1,
                openCount,
                current,
                result
            );
        }


        // ---------------------------
        // Option 2: Keep current char
        // ---------------------------

        int lengthBefore = current.length();

        if (ch == '(') {

            current.append(ch);

            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                openCount + 1,
                current,
                result
            );

            current.setLength(lengthBefore);
        }

        else if (ch == ')') {

            // We can only add ')' if there is
            // an unmatched '(' before it.
            if (openCount > 0) {

                current.append(ch);

                backtrack(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove,
                    openCount - 1,
                    current,
                    result
                );

                current.setLength(lengthBefore);
            }
        }

        else {

            // Letters cannot be removed
            current.append(ch);

            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                openCount,
                current,
                result
            );

            current.setLength(lengthBefore);
        }
    }
}