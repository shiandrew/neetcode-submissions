class Solution {

    public boolean compareFreq(Map<Character, Integer> sFreq, Map<Character, Integer> tFreq) {
            for (char c : tFreq.keySet()) {
                if (sFreq.getOrDefault(c, 0) < tFreq.get(c)) {
                    return false;
                }
            }
            return true;
        }
    
    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        while (r < s.length()) {
            sFreq.put(s.charAt(r), sFreq.getOrDefault(s.charAt(r), 0) + 1);
            if (sFreq.get(s.charAt(r)) < tFreq.getOrDefault(s.charAt(r), 0)
            || !compareFreq(sFreq, tFreq)) {
                r++;
                continue;
            }

            while (sFreq.get(s.charAt(l)) - 1 >= tFreq.getOrDefault(s.charAt(l), 0)) {
                sFreq.put(s.charAt(l), sFreq.get(s.charAt(l)) - 1);
                l++;
            }
            
            if (minLen > r - l + 1) {
                minLen = r - l + 1;
                result = s.substring(l, r + 1);
            }
            
            r++;
        }

        return result;
    }
}
