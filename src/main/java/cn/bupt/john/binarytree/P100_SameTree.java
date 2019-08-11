package cn.bupt.john.binarytree;


public class P100_SameTree {

    public static void main(String[] args) {
        P100_SameTree solution = new P100_SameTree();
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode4;

        System.out.println(solution.isSameTree(null, null));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recursive(p, q) && recursive(p, q);
    }

    public boolean recursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return recursive(p.left, q.left) && recursive(p.right, q.right);
    }

    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
