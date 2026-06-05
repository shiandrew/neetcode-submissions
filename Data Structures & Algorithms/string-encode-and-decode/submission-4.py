class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded = ''
        for s in strs:
            encoded = encoded + str(len(s)) + '#' + s
        return encoded
        

    def decode(self, s: str) -> List[str]:
        decoded = []
        #print(s)
        while s:
            l = ''
            while s[0] != '#':
                l += s[0]
                s = s[1:]
            l = int(l)
            s = s[1:]
            decoded.append(s[:l])
            s = s[l:]
            print(s)
        return decoded


