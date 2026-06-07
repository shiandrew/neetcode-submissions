class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int diff = 0 - nums[i] - nums[j];
                if (count.getOrDefault(diff, 0) > 0) {
                    result.add(Arrays.asList(nums[i], nums[j], diff));
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }
        return result;
    }
}
