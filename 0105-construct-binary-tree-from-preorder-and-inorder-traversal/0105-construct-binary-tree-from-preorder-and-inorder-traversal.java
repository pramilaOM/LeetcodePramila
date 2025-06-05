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
    private int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return solve(preorder, inorder, 0, inorder.length - 1);

    }

    private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[idx++];
        TreeNode root = new TreeNode(rootVal);

        int i = start;
        while (i <= end && inorder[i] != rootVal) {
            i++;
        }

        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);

        return root;

    }
}