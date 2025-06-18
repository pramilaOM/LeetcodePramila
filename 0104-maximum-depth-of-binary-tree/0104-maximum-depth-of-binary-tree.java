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
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.add(root);
        int leveles = 0;

        while (!nodes.isEmpty()) {
            leveles++;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poppedNode = nodes.poll();
                if (poppedNode.left != null)
                    nodes.add(poppedNode.left);

                if (poppedNode.right != null)
                    nodes.add(poppedNode.right);
            }
        }

        return leveles;
    }
}