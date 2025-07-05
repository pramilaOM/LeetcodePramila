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
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return max;
    }

    void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null)
            return;
        max = Math.max(max, length);
        if (isLeft) {
            dfs(node.right, false, length + 1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.left, true, length + 1);
            dfs(node.right, false, 1);
        }
    }
}