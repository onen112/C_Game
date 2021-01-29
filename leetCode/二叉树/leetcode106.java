/**
 * 题目：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 从中序与后序遍历序列构造二叉树
 * 
 * 思路：
 *      分解子问题的思路通过递归实现每次由后序遍历
 *      序列找到root，然后在中序遍历中找到对应的位置
 *      这样对中序序列左边就是左子树，右边就是右子树
 *      进行递归即可
 */
class Solution {
    //保存后序遍历中当前的root
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //后序遍历，树的root是postorder的最后一个元素
        postIndex = inorder.length-1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }
    //创建子树
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
    /**
     * 在中序遍历中确定当前的root的位置
     */
    public int findRoot(int[] inorder,int val,int inBengin,int inEnd){
        for(int i = inBengin;i <= inEnd;i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}