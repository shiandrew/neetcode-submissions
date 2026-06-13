class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, new ArrayList<Integer>(), 0, nums, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList(cur));
            return;
        }
        if (total > target || i >= nums.length) {
            return;
        }
        cur.add(nums[i]);
        dfs(i, cur, total + nums[i], nums, target);
        cur.remove(cur.size() - 1);
        dfs(i + 1, cur, total, nums, target);
    }
}
