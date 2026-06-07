class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int l = 0, r = s1.length() - 1;
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        while (r < s2.length()) {
            if (Arrays.equals(count1, count2)) {
                return true;
            }
            count2[s2.charAt(l) - 'a']--;
            l++;
            r++;
            if (r < s2.length()) {
                count2[s2.charAt(r) - 'a']++;
            }
        }
        return false;
    }
}
