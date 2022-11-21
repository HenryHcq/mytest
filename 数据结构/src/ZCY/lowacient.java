package ZCY;

import java.util.HashMap;
import java.util.HashSet;

public class lowacient {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static TreeNode function(TreeNode root, TreeNode n1, TreeNode n2) {
        HashMap<TreeNode, TreeNode> fatherNode = new HashMap<TreeNode, TreeNode>();
        fatherNode.put(root, root);
        process(root, fatherNode);

        HashSet<TreeNode> hashSet = new HashSet<TreeNode>();
        TreeNode cur = n1;
        while (cur != fatherNode.get(cur)) {
            //等于root
            hashSet.add(cur);
            cur = fatherNode.get(cur);
        }
        hashSet.add(root);

        cur = n2;
        while (cur != fatherNode.get(cur)) {
            if (hashSet.contains(cur)) {
                return cur;
            } else {
                cur = fatherNode.get(cur);
            }
        }
        return root;
    }

    private static void process(TreeNode root, HashMap<TreeNode, TreeNode> fatherNode) {
        if (root == null) {
            return;
        }
        fatherNode.put(root.left, root);
        fatherNode.put(root.right, root);
        process(root.left, fatherNode);
        process(root.right, fatherNode);
    }

    private static TreeNode function2(TreeNode root, TreeNode o1, TreeNode o2) {
        if (root == null || root == o1 || root == o2) {
            return root;
        }
        TreeNode left = function2(root.left, o1, o2);
        TreeNode right = function2(root.right, o1, o2);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
