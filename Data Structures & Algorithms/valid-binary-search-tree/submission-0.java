/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        int[] interval = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        return dfs(root, interval);
    }
    private boolean dfs(TreeNode root, int[] interval) {
        if (root == null) {
            return true;
        }
        if (root.val <= interval[0] || root.val >= interval[1]) {
            return false;
        }
        return dfs(root.left, new int[]{interval[0], root.val})
        && dfs(root.right, new int[]{root.val, interval[1]});
    }
}
