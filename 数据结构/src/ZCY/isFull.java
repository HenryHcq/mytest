package ZCY;

public class isFull {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean isF(TreeNode root) {
        if (root == null) {
            return true;
        }
        ReturnType process = process(root);
        return process.nodes == ((1 << process.height) - 1);
    }

    public static class ReturnType {
        public int height;
        public int nodes;

        public ReturnType(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }

        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new ReturnType(height, nodes);
    }
}
