class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int result = 0;
        Map<Character, Integer> count = new HashMap<>();
        int freq = 0;

        while (r < s.length()) {
            char cr = s.charAt(r);
            count.put(cr, count.getOrDefault(cr, 0) + 1);
            if (count.get(cr) > freq) {
                freq = count.get(cr);
            }
            while(r - l + 1 > freq + k){
                char cl = s.charAt(l);
                count.put(cl, count.getOrDefault(cl, 0) - 1);
                l++;
            }
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
