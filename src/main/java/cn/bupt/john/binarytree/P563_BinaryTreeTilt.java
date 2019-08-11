package cn.bupt.john.binarytree;

/**
 * 解题思路：
 * 相当于后序遍历，由于需要求之前所有节点的和，所以必须先遍历到叶子节点
 * <li>遍历过程中将节点差值放入result时，还需要把节点的和返回给上一层</li>
 */
public class P563_BinaryTreeTilt {

    public static void main(String[] args) {
        P563_BinaryTreeTilt solution = new P563_BinaryTreeTilt();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left = treeNode4;
        System.out.println(solution.findTilt(treeNode));
    }

    int result = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return result;
        }
        recursive(root);
        return result;
    }

    private int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursive(root.left);
        int right = recursive(root.right);
        result += Math.abs(left - right);
        return left+right+root.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
