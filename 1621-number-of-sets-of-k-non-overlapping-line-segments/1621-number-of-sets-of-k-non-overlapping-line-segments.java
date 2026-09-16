class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[n][k + 1];
        long[][] prefix = new long[n][k + 1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 1;

            if(i == 0)
            prefix[i][0] = 1;
            else
            prefix[i][0] = prefix[i - 1][0] + dp[i][0];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){

                dp[i][j] = (dp[i - 1][j] + prefix[i - 1][j - 1]) % MOD;
                prefix[i][j] = (dp[i][j] + prefix[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[n -1][k]);

        return (int)dp[n - 1][k];
    }
}