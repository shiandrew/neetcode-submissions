class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        buy = prices[0]
        for i, sell in enumerate(prices):
            if buy > sell:
                buy = sell
            profit = sell - buy
            #print(buy, sell)
            res = max(res, profit)
        return res

