/**
 * 题目：https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 另一颗树的子树
 *  判断第二棵树是否为第一棵树的子🌲
 * 思路：
 *      选择一种遍历方式遍历第一颗树
 *      如果当前节点值==第二棵树的root
 *      判断是否这俩是否相等
 *      不想等继续遍历在找下一个相等的
 *      对后如果找不到返回false
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return findNode(s,t);
    }
    public static boolean findNode(TreeNode s,TreeNode t){
       boolean ret;
       if(s == null){
           return false;
       }
        if(s.val == t.val){
            ret = preOrder(s,t);
            if(ret){
                return true;
            }
        }
        return findNode(s.right,t)||findNode(s.left,t);
    }
    public static boolean preOrder(TreeNode p,TreeNode q){
        if((p == null && q != null)||p != null && q == null){
            return false;
        }else if(p == null && q == null){
            return true;
        }
        else if(p.val != q.val){
            return false;
        }else{
            return preOrder(p.left,q.left)&&preOrder(p.right,q.right);
        } 
    }
}