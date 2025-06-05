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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        collectPaths(root, targetSum, result, temp);
        return result;

    }

    private void collectPaths(TreeNode root, int targetSum, List<List<Integer>> result,
            List<Integer> temp) {
        if (root == null) {
            return;
        }

        temp.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(temp));
        }
        collectPaths(root.left, targetSum - root.val, result, temp );
        collectPaths(root.right, targetSum - root.val, result,temp );

        temp.remove(temp.size() - 1);

    }

}