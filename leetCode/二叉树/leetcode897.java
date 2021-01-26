/**
 * 题目：https://leetcode-cn.com/problems/increasing-order-search-tree/
 *  递归增序查找树
 *  思路：先用中序遍历将树种的数据读到数组中
 *  在按照题目要求进行创建树
 * 
 */
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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inOrder(root,ret);
        TreeNode retNode = new TreeNode();
        TreeNode retP = retNode;
        //按题意构建对应的二叉树
        for(int i : ret){
            retP.right = new TreeNode(i);
            retP = retP.right;
        }
        return retNode.right;
    }
    //中序遍历
    public static void inOrder(TreeNode root,List ret){
        if(root == null) return;
        inOrder(root.left,ret);
        ret.add(root.val);
        inOrder(root.right,ret);
    }
}