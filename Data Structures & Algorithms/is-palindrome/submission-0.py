class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        s2 = ''
        for c in s:
            if c.isalpha() or c.isdigit():
                s2 += c
        #print(s2)
        for i in range(len(s2)):
            if s2[i] != s2[len(s2) - 1 - i]:
                return False
        return True