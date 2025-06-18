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

    TreeNode buildBT(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int root_candidate = root.val;
        int i = inStart;

        for (; i <= inEnd; i++) {
            if (inorder[i] == root_candidate) {
                break;
            }
        }
        int leftSize = i - inStart;
        int rightSize = inEnd - i;

        root.left = buildBT(inorder, postorder, inStart, i - 1, postStart, postStart + leftSize - 1);
        root.right = buildBT(inorder, postorder, i + 1, inEnd, postEnd - rightSize, postEnd - 1);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode root = null;
        int n = postorder.length;
        int inStart = 0;
        int inEnd = n - 1;
        int postStart = 0;
        int postEnd = n - 1;
        root = buildBT(inorder, postorder, inStart, inEnd, postStart, postEnd);
        return root;

    }
}