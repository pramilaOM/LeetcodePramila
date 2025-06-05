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
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        boolean past = false;

        while (!que.isEmpty()) {
            TreeNode node = que.poll();

            if (node == null) {
                past = true;
            } else {
                if (past) {
                    return false;
                }
                que.offer(node.left);
                que.offer(node.right);
            }

        }
        return true;
    }
}