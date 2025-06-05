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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        dfs(root, 1, result);
        return result;

    }

    public void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null)
            return;

        if (result.size() < level) {
            result.add(node.val);
        }

        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}