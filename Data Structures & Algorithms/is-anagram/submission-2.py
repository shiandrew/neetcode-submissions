class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        list1 = []
        list2 = []
        for c in s:
            list1.append(c)
        for c in t:
            list2.append(c)
        return sorted(list1) == sorted(list2)
        