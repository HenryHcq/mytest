package ZCY;

import java.util.Stack;

public class isBST {

    public static int preValue = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeftBst = checkBST(root.left);
        if (!isLeftBst) {
            return false;
        }
        if (preValue >= root.val) {
            return false;
        } else {
            preValue = root.val;
        }
//        System.out.println(root.val);//原本中序遍历是打印值
        return checkBST(root.right);//当成左子树来看
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
//        System.out.println(root.val);//遍历到最后一个节点时，left是null 打印头，再进right right也是null 此节点的头便变成了新的root

        inOrder(root.right);
    }

    public static boolean checkBST1(TreeNode root) {
        //非递归
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
//                System.out.println(root.val);
                if (preValue >= root.val) {
                    return false;
                } else {
                    preValue = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }
}
