/**
 * 题目：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 从前序与中序遍历序列构造二叉树
 * 
 * 思路同106题，只不过遍历从前往后找root
 * 然后递归时先构建左子树，在构建右子树
 */
class Solution {
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = inorder.length-1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode buildTreeChild(int[] inorder,int[] postorder,int inBengin,int inEnd){
        if(inBengin > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = findRoot(inorder,postorder[postIndex],inBengin,inEnd);
        postIndex--;
        root.right = buildTreeChild(inorder,postorder,index+1,inEnd);
        root.left = buildTreeChild(inorder,postorder,inBengin,index-1);
        return root;
    }
    public int findRoot(int[] inorder,int val,int inBengin,int inEnd){
        for(int i = inBengin;i <= inEnd;i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}