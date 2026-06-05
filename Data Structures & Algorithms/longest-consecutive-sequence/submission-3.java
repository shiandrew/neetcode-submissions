class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            }
        }
        
        for (int n : nums) {
            if (set.contains(n - 1)) {
                continue;
            }
            int count = 1;
            int i = n;
            while (set.contains(i++)) {
                result = Math.max(result, count++);
            }
        }
        return result;
    }
}
