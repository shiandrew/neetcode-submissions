class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0


        d = defaultdict(int)
        min = max = None
        for num in nums:
            d[num] += 1
            if min is None:
                min = num
            if max is None:
                max = num
            if min > num:
                min = num
            if max < num:
                max = num
        res = 0
        length = 0
        for i in range(min, max + 1):
            if d[i]:
                length += 1
                if length > res:
                    res = length
            else:
                length = 0
        return res
        
        