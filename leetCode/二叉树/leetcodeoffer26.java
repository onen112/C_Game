/**
 * 题目：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 
 * 树的子结构
 * 
 * 思路：
 *      类似于另一颗树的子树，不过判断的方式稍微不同
 *      当B树走到空直接返回true，无论A树是否为空
 *      其余部分代码类似
 */

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return false; 
        return findRoot(A,B);
    }
    //找到和B.val相同的值就判断是否为子结构
    public boolean findRoot(TreeNode A,TreeNode B){
        if(A == null) return false;
        if(A.val == B.val&&isSame(A,B)){
            return true;
        }; 
        return findRoot(A.left,B)||findRoot(A.right,B);
    }
    //判断是否为子结构
    public boolean isSame(TreeNode A,TreeNode B){
        if(B == null) return true;
        if((A == null&&B!=null)||A.val != B.val) return false;
        return isSame(A.left,B.left)&&isSame(A.right,B.right);
    }
}