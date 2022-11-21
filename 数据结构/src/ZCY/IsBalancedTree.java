package ZCY;

public class IsBalancedTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;


        }

        public boolean isBalanced(TreeNode root) {
            return process(root).isBalanced;
        }

        public ReturnType process(TreeNode root) {
            if (root == null) {
                return new ReturnType(true, 0);
            }

            ReturnType leftIsBalanced = process(root.left);
            ReturnType rightIsBalanced = process(root.right);

            height = Math.max(leftIsBalanced.height, rightIsBalanced.height) + 1;
            boolean isBalanced = leftIsBalanced.isBalanced && rightIsBalanced.isBalanced && Math.abs(leftIsBalanced.height - rightIsBalanced.height) < 2;

            return new ReturnType(isBalanced, height);

        }
    }
}