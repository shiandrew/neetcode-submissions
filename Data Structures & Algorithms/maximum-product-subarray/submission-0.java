class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        int largest = Integer.MIN_VALUE;
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len;
                if (j >= n) continue;
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = dp[i][j - 1] * nums[j];
                }
                largest = Math.max(largest, dp[i][j]);
            }
        }
        return largest;

    }
}
