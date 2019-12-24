class CountNumberOfWaysToReachScoreInGame {
    public int getWays(int n) {

        int [] dp = new int[n + 1];

        for (int i = 3; i <= n; i++) {
            dp[i] += dp[i - 3];
        }

        for (int i = 5; i <= n; i++) {            
            dp[i] += dp[i - 5];
        }

        for (int i = 10; i <= n; i++) {
            dp[i] += dp[i - 10];
        }

        return dp[n];
    }
}
