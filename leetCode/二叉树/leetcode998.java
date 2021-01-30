/**
 * 题目：https://leetcode-cn.com/problems/maximum-binary-tree-ii/
 * 最大二叉树 二
 * 
 * 在最大二叉树的基础上，再给你一个val并放在之前的数组最后
 * 返回新的二叉树
 * 
 * 思路：
 *      分解子问题 如果val > root.val,直接把root添加到val的左边即可
 *      否则：递归右子树直到遇到null
 */
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root != null&&val > root.val){
          TreeNode ret = new TreeNode(val);  
          ret.left = root;
          root = ret;
        }else{
            if(root == null) return new TreeNode(val);
            root.right = insertIntoMaxTree(root.right,val);
        }
        return root;
    }
}