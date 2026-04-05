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
        //Level Order Traversal BFS  
        //https://www.youtube.com/watch?v=-Qs1T_xfzLo&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=1

        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeNode rightNode = null;
            while (n-- > 0) {
                rightNode = queue.poll();
                if (rightNode.left != null) {
                    queue.offer(rightNode.left);
                }

                if (rightNode.right != null) {
                    queue.offer(rightNode.right);
                }
            }
            result.add(rightNode.val);
        }
        return result;

    }
}