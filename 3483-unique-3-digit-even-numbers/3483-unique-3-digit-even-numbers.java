class Solution {
    public int totalNumbers(int[] digits) {
        
        int n = digits.length;
        HashSet<Integer> seen = new HashSet<>();

        for(int i = 0; i < n; i++){

            if(digits[i] == 0) continue;
            for(int j = 0; j < n; j++){

                if(i == j) continue;
                for(int k = 0; k < n; k++){

                    if(k == i || k == j) continue;
                    if(digits[k] % 2 != 0) continue;

                    int digit = (digits[i] * 100) + (digits[j] * 10) + digits[k];
                    System.out.println(digit);

                    seen.add(digit);
                }
            }
        }
        return seen.size();
    }
}