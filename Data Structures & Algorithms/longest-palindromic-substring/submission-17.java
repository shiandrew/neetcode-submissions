class Solution {
    int resLen = 0;
    String res = new String();

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return res;
    }

    private void extend(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
            } else {
                break;
            }
            l--;
            r++;
        }
    }
}
