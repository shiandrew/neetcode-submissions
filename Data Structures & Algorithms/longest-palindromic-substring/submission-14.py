class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) == 1:
            return s[0]
        res, resLen = -1, 0
        
        def checkPalindrome(i, s, flag, res, resLen):
            if flag: # odd number palindrome
                left, right = i - 1, i + 1
                length = 1
                if length > resLen:
                        resLen = length
                        res = i
            else: # even number palindrome
                left, right = i, i + 1
                length = 0
            #print(s[left : right + 1])
            
            while left >= 0 and right < len(s):
                if s[left] != s[right]:
                    break
                else:
                    length += 2
                    if length > resLen:
                        resLen = length
                        res = left
                        
                left -= 1
                right += 1
            
            return(res, resLen)
                    

        for i in range(len(s)):
            res1, resLen1 = checkPalindrome(i, s, True, res, resLen)
            print(resLen1, resLen, res1, res)
            if resLen1 > resLen:
                res = res1
                resLen = resLen1
            res1, resLen1 = checkPalindrome(i, s, False, res, resLen)
            print(resLen1, resLen, res1, res)
            if resLen1 > resLen:
                res = res1
                resLen = resLen1
        print(res, resLen)
        
        if res == -1:
            return ""
        else:
            return s[res : res + resLen]