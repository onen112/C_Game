/**
 * 题目：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 二叉树的最大深度
 *  思路：
 *      化解子问题的方法，
 *      每次求这个根左右子树深度更大的并返回
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + (left > right?left:right);
    }
}