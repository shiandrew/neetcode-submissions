class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
            
        nums1 = nums[:-1]
        nums2 = nums[1:]

        def dp(nums, mp = {}):
            print(nums)
            mp[0] = nums[0]

            for i in range(1, len(nums)):
                mp[i] = max(nums[i] + mp.get(i - 2, 0), mp[i - 1])

            return mp[len(mp) - 1]

        return max(dp(nums1), dp(nums2))
                
