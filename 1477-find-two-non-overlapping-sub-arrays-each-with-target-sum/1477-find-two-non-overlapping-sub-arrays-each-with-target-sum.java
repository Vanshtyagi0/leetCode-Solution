import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;

        // best[i] = minimum length of a target-sum subarray
        // completely contained in arr[0...i]
        int[] best = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        // prefix sum 0 exists before the array starts
        map.put(0, -1);

        int prefixSum = 0;
        int minLength = INF;
        int answer = INF;

        for (int i = 0; i < n; i++) {

            prefixSum += arr[i];

            /*
             If:
                 prefixSum[i] - prefixSum[j] = target

             then:
                 prefixSum[j] = prefixSum[i] - target
            */
            int required = prefixSum - target;

            if (map.containsKey(required)) {

                int j = map.get(required);

                // Current target-sum subarray:
                // j + 1 ... i
                int currentLength = i - j;

                /*
                 We need another target-sum subarray
                 completely before j + 1.

                 Therefore it must end at or before j.
                */
                if (j >= 0 && best[j] != INF) {
                    answer = Math.min(
                        answer,
                        currentLength + best[j]
                    );
                }

                minLength = Math.min(
                    minLength,
                    currentLength
                );
            }

            best[i] = minLength;

            /*
             Store latest index for this prefix sum.

             Latest index gives shorter subarrays and
             best[i] can only improve as i increases.
            */
            map.put(prefixSum, i);
        }

        return answer == INF ? -1 : answer;
    }
}