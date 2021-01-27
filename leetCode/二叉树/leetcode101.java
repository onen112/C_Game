/**
 * 题目：https://leetcode-cn.com/problems/symmetric-tree/
 * 对称二叉树
 *      判断一个二叉树是否镜像对称
 * 思路：
 *      分解为子问题，判断左右子🌲是否对称
 *      判断root的左右子🌲 是否对称位置相同（类似于110题）
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null||(root.left==null&&root.right==null)){
            return true;
        }
        return preOrder(root.left,root.right);
    }
    
    public static boolean preOrder(TreeNode p,TreeNode q){
        if((p == null && q != null)||p != null && q == null){
            return false;
        }else if(p == null && q == null){
            return true;
        }
        else if(p.val != q.val){
            return false;
        }else{
            //判断是否对称
            return preOrder(p.left,q.right)&&preOrder(p.right,q.left);
        } 
    }
}