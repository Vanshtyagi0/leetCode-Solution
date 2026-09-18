class Solution {

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Step 1: first and last occurrence
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<String> result = new ArrayList<>();

        int previousEnd = -1;

        // Step 2: Try to create a valid interval
        // only from a character's first occurrence
        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] != i) {
                continue;
            }

            int end = getValidEnd(s, i, first, last);

            if (end == -1) {
                continue;
            }

            // No overlap
            if (i > previousEnd) {

                result.add(s.substring(i, end + 1));
            } else {

                // Replace previous interval because
                // this one finishes earlier
                result.set(
                    result.size() - 1,
                    s.substring(i, end + 1)
                );
            }

            previousEnd = end;
        }

        return result;
    }

    private int getValidEnd(
        String s,
        int start,
        int[] first,
        int[] last
    ) {

        int end = last[s.charAt(start) - 'a'];

        for (int i = start; i <= end; i++) {

            int c = s.charAt(i) - 'a';

            // This character appeared before start.
            // Therefore we cannot include all occurrences.
            if (first[c] < start) {
                return -1;
            }

            // Expand interval if necessary
            end = Math.max(end, last[c]);
        }

        return end;
    }
}