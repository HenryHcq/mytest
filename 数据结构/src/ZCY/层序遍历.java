package ZCY;

import java.util.*;

public class 层序遍历 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void cxbl(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            root = treeNodeQueue.poll();
            list.add(root);
            treeNodeQueue.add(root.left);
            treeNodeQueue.add(root.right);
        }
    }

    public static void getMaxWidth(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        hashMap.put(root, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!treeNodeQueue.isEmpty()) {
            root = treeNodeQueue.poll();
            int curNodeLevel = hashMap.get(root);
            if (curLevel == curNodeLevel) {
                //是当前层
                curLevelNodes++;
            } else {
                //不是当前层
                max = Math.max(max, curLevelNodes);//更新最大值
                curLevel++;
                curLevelNodes = 1;//发现了一个新一层的节点
            }
            list.add(root);
            if (root.left != null) {
                hashMap.put(root.left, curLevel + 1);
                treeNodeQueue.add(root.left);
            }
            if (root.right != null) {
                hashMap.put(root.right, curLevel + 1);
                treeNodeQueue.add(root.right);
            }
        }
        max = Math.max(max, curLevelNodes);//最后一层在循环中无法比较，在末尾再比较一次
    }

    public static void getMaxWidth1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        int curLevelNodes = 0;
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        int max = Integer.MIN_VALUE;
        while (!treeNodeQueue.isEmpty()) {
            root = treeNodeQueue.poll();
            if (root.left != null) {
                treeNodeQueue.add(root.left);
                nextEnd = root.left;
            }
            if (root.right != null) {
                treeNodeQueue.add(root.right);
                nextEnd = root.right;
            }
            if (curEnd == root) {
                curLevelNodes++;
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
                nextEnd = null;
            } else {
                curLevelNodes++;
            }
        }
    }
}
