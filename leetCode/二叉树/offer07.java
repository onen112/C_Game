/**
 * 重建二叉树：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 
 * 根据一个二叉树的先序遍历和中序遍历序列创建二叉树
 *  
 * 思路：
 *      分解子问题，由先序遍历序列确定root，然后在中序遍历中以root分为左右子🌲
 *      继续找，直到找完即可
 */
class Solution {
    //用于遍历先序序列（用来确定每次的root）
    int prIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        prIndex = 0;
        int inIndex = findIn(inorder,preorder[prIndex],0,inorder.length);
        //第一个根节点
        TreeNode root = new TreeNode(preorder[0]);
        prIndex++;
        //按照root在中序遍历的位置分别去创建左右子树
        root.left = build(0,inIndex,preorder,inorder);
        root.right = build(inIndex+1,inorder.length,preorder,inorder);
        return root;
    }
    //递归创建左右子树
    public TreeNode build(int begin,int end,int[] preorder,int[]inorder){
        if(begin == end) return null;
        TreeNode root = new TreeNode(preorder[prIndex]);
        int inIndex = findIn(inorder,preorder[prIndex],begin,end);
        prIndex++;
        root.left = build(begin,inIndex,preorder,inorder);
        root.right = build(inIndex+1,end,preorder,inorder);
        return root;
    }
    //找到当前root在中序遍历中的位置并返回
    public int findIn(int[] inorder,int root,int begin,int end){
        for(int i = begin;i < end;i++){
            if(root == inorder[i]){
                return i;
            }
        }
        return -1;
    } 
}