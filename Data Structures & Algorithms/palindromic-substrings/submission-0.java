class Solution {
    public int countSubstrings(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            //odd center
            int left = i, right = i;
            while(left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    num++;
                    left--; right++;
                } else {
                    break;
                }
                
            }
            //even center
            left = i; right = i + 1;
            while(left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    num++;
                    left--; right++;
                } else {
                    break;
                }
            }
        }
        return num;
    }
}
