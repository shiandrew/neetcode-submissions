class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum = -float("infinity")
        curSum = 0

        for i in range(len(nums)):
            curSum = max(curSum + nums[i], nums[i])
            maxSum = max(curSum, maxSum)

        return maxSum


        