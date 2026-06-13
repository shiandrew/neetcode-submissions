class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            if (wordDict.contains(s.substring(i, n))) {
                dp[i][n - 1] = true;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (wordDict.contains(s.substring(i, j + 1))
                && j + 1 < n) {
                    dp[i][n - 1] = dp[i][n - 1] || dp[j + 1][n - 1];
                }
            }
        }
        return dp[0][n - 1];
    }
}
