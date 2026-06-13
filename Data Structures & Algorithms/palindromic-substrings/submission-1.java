class Solution {
    int res = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return res;
    }

    private void extend(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            res++;
            l--;
            r++;
        }
    }
}
