/**
 * 题目：https://leetcode-cn.com/problems/balanced-binary-tree/
 * 平衡二叉树
 *      一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 
 *    
 * 思路：
 *      划分子问题，判断每个节点左右子🌲的最大高度
 *      若都相差为1返回true，否则返回false
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.left);
        return Math.abs(leftH-rightH) <= 1&&(isBalanced(root.left)&&isBalanced(root.right));

    }
    //求树高度
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return leftHeight  > rightHeight  ?
                leftHeight +1 : rightHeight +1;
    }
}