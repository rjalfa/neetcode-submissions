class Solution {
    public int integerBreak(int n) {
        // dp[i] = for all j where i % j == 0: do max(dp[i], j * dp[i - j])

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n ; i ++) {
            dp[i] = 0;
            for (int j = 0; j < i; j ++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }
}