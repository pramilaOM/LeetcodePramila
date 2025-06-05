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

    public boolean checkOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }
        return checkOne(root.left) || checkOne(root.right);
    }

    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (!checkOne(root.left))
            root.left = null;
        if (!checkOne(root.right))
            root.right = null;

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;

    }
}