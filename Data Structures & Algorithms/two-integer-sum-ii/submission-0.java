class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            int diff = target - numbers[i];
            if (map.containsKey(diff)) {
                return new int[]{i + 1, map.get(diff)};
            }
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], i + 1);
            }
        }
        return null;
    }
}
