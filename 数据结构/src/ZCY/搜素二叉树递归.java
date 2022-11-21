package ZCY;

public class 搜素二叉树递归 {
    public static void main(String[] args) {

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static class ReturnData {
        public boolean isBST;
        public int max;
        public int min;

        public ReturnData(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static ReturnData process(TreeNode root) {
        if (root == null) {
            return null;
        }

        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);


        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (root.right != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
//        boolean isBST = true;
//        if (root.left != null && (!leftData.isBST || leftData.max >= root.val)) {
//            isBST = false;
//        }
//        if (root.right != null && (!rightData.isBST || rightData.min <= root.val)) {
//            isBST = false;
//        }
        boolean isBST = false;
        if (
                        (root.left != null ? leftData.isBST && leftData.max < root.val : true)
                        &&
                        (root.right != null ? rightData.isBST && rightData.min > root.val : true)
        ) {
            isBST = true;
        }
        return new ReturnData(isBST, max, min);
    }

}


