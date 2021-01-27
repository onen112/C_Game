/**
 * 题目：https://leetcode-cn.com/problems/same-tree/
 * 相同的二叉树
 *      给两个二叉树的根节点，判断两棵树是否是相同二叉树
 *    
 * 思路：
 *  选择一种遍历方式对两棵树同时遍历
 *  分解为子问题对于每个节点判断它的左右子🌲是否相同
 *  如果都相同返回true
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null&&q == null){
            return true;
        }
        return preOrder(p,q);
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
            //当前节点相同，判断其左右子🌲是否相同
            return preOrder(p.left,q.left)&&preOrder(p.right,q.right);
        } 
    }
}