class Solution:
    def rob(self, nums: List[int]) -> int:
        mp = {}
        
        for i in range(len(nums) - 1, -1, -1):
            if i == len(nums) - 1:
                mp[i] = nums[i]
                continue
            
            mp[i] = max(nums[i] + mp.get(i + 2, 0), mp[i + 1])

        return mp[0]
            
            