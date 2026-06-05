class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        sorted_list = []
        for strn in strs:
            sorted_list.append(sorted(strn))
        for i in range(len(strs)):
            if sorted_list[i] == None:
                continue
            sublist = [strs[i]]
            for j in range(i + 1, len(strs)):
                if sorted_list[i] == sorted_list[j]:
                    sublist.append(strs[j])
                    sorted_list[j] = None
            sorted_list[i] = None
            result.append(sublist)
        return result
            
        