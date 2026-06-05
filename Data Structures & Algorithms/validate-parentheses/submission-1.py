class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        open = "({["
        close = ")}]"
        for c in s:
            if c in open:
                stack.append(c)
            if c in close:
                if not stack:
                    return False
                d = stack.pop()
                if open.index(d) != close.index(c):
                    return False
        return not stack