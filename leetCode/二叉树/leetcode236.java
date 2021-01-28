/**
 * 题目：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 二叉树的最近公共祖先
 * 
 *      给你一颗二叉树和两个节点
 *      找出两个节点最近的一个公共祖先
 * 思路：
 *      递归，大问题划小问题在左右子树中分别寻找并保存
 *      然后对找到的节点进行判断
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p||root == q||root==null) return root;
       
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;  
    }
}