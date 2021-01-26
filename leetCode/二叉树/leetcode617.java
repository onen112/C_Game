/**
 * 题目：https://leetcode-cn.com/problems/merge-two-binary-trees/
 *  合并两个二叉树
 *      即返回对应节点位置相加的新二叉树
 *  思路：采用递归的方式对没个节点进行遍历（这里用的先序遍历）
 *      当两个节点都为空时，结束递归
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //两个都为空，直接返回null
        if(t1 == null&&t2 == null)
            return null;
        TreeNode root = new TreeNode();
        //否则进入递归
        preOrder(t1,t2,root);
        return root;
    }
    public static void preOrder(TreeNode t1,TreeNode t2,TreeNode add){
        //递归结束条件
        if(t1==null&&t2==null){
            return;
        }
        if(t1 != null&&t2 == null){
            //第二个树对应位置为空，直接把t1的左右子🌲都给add
            add.val = t1.val;
            add.left = t1.left;
            add.right = t1.right;
        }else if(t1 == null&&t2 != null){
            //同上第1个树对应位置为空，直接把t2的左右子🌲都给add
            add.val = t2.val;
            add.left = t2.left;
            add.right = t2.right;
        }else{
            //否则正常相加加
            add.val = t1.val+t2.val;
        }   
        if(t1 != null && t2 != null){
            //t1,t2都不为空
            if(t1.left!= null||t2.left!=null){
                //创建add的左子树递归
                add.left = new TreeNode();
            }   
            preOrder(t1.left,t2.left,add.left);
        }
        if(t1 != null&&t2!= null){
            //创建右子树递归
            if(t1.right!= null||t2.right!=null)
                add.right = new TreeNode();
            preOrder(t1.right,t2.right,add.right);           
        }
    }
}