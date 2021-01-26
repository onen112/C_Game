/**
 * 题目：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *  二叉树的后序遍历
 *  递归实现
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        pre(root,l);
        return l;
    }
    public void pre(TreeNode root,List l){
        if(root == null) return;
        
        pre(root.left,l);
        l.add(root.val);
        pre(root.right,l);
    }    
}