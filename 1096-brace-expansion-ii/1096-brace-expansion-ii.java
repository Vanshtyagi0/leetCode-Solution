class Solution {

    private int index = 0;

    public List<String> braceExpansionII(String expression) {

        Set<String> set = parse(expression);

        List<String> answer = new ArrayList<>(set);

        Collections.sort(answer);

        return answer;
    }

    private Set<String> parse(String s) {

        // Stores union result
        Set<String> result = new HashSet<>();

        // Stores current concatenation
        Set<String> current = new HashSet<>();
        current.add("");

        while (index < s.length() && s.charAt(index) != '}') {

            char ch = s.charAt(index);

            // UNION
            if (ch == ',') {

                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                index++;
            }

            // Nested expression
            else if (ch == '{') {

                index++; // skip '{'

                Set<String> next = parse(s);

                index++; // skip '}'

                current = multiply(current, next);
            }

            // Letter
            else {

                Set<String> next = new HashSet<>();

                next.add(String.valueOf(ch));

                current = multiply(current, next);

                index++;
            }
        }

        // Add final concatenation group
        result.addAll(current);

        return result;
    }

    // Cartesian product / concatenation
    private Set<String> multiply(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}