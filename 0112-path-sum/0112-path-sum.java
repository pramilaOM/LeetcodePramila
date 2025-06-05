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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return collectPaths(root, targetSum, 0);

    }

    private boolean collectPaths(TreeNode root, int targetSum, int curr) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return ((curr + root.val) == targetSum);
        }
        boolean left = collectPaths(root.left, targetSum, curr + root.val);
        boolean right = collectPaths(root.right, targetSum, curr + root.val);

        return left || right;

    }
}