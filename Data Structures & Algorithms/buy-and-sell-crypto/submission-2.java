class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int[] leftMin = new int[prices.length];
        Arrays.fill(leftMin, Integer.MAX_VALUE);

        for (int i = 1; i < prices.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], prices[i - 1]);
            profit = Math.max(profit, prices[i] - leftMin[i]);
        }

        return profit;
    }
}
