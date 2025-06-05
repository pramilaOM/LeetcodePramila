class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (level == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    TreeNode originalLeft = curr.left;
                    TreeNode originalRight = curr.right;

                    curr.left = new TreeNode(val);
                    curr.left.left = originalLeft;

                    curr.right = new TreeNode(val);
                    curr.right.right = originalRight;
                }
                break;
            }

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }

            level++;
        }

        return root;
    }
}
