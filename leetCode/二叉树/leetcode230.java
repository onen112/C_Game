/**
 * 题目：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 
 * 二叉搜索树中第K小的元素
 * 
 * 思路：对于二叉搜索树 其中序遍历的序列就是一个从小到大的序列
 *      因此只需要对二叉树进行中序遍历 每次遍历到一个节点
 *      k-- 直到k == 0 返回 不继续进行了  返回此时的root.val即可
 *           
 */
class Solution {
    int ret = 0;
    int k;
    public int kthSmallest(TreeNode root, int n) {
        k = n;
         mid(root);
         return ret;
    }
    public void mid(TreeNode root){
        if(root == null) return;
            mid(root.left);
            k--;
            if(k == 0){
                ret = root.val;
                return;
            }
            mid(root.right);
    }
}