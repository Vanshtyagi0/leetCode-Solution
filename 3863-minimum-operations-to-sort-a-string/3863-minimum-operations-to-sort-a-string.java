class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char min = 'z';
        char max = 'a';
        boolean sorted = true;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);

            if (i > 0 && s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
            }
        }

        // Case 1: Already sorted
        if (sorted) {
            return 0;
        }

        // Case 2: Length 2 cannot be sorted
        if (n == 2) {
            return -1;
        }

        // Case 3: One operation
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Case 4: Check unique maximum at start
        // and unique minimum at end
        boolean uniqueMax = true;
        boolean uniqueMin = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == max) {
                uniqueMax = false;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == min) {
                uniqueMin = false;
            }
        }

        if (s.charAt(0) == max &&
            s.charAt(n - 1) == min &&
            uniqueMax &&
            uniqueMin) {
            return 3;
        }

        // Case 5: Two operations
        return 2;
    }
}
