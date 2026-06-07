class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int l = 0, r = 1;
        int result = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(l));
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                while (set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
