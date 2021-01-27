/**
 * 题目：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *  二叉树的层序遍历
 *      思路：
 *          使用队列先进先出的特性来进行遍历
 *          先将root入队，通过while循环每次出队一个
 *          打印出值，并将其左右节点（非null）入队
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();

        if(root == null){
            return ret;
        }
        qu.offer(root);
        TreeNode tmp;
        List<Integer> l = new ArrayList<>();
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size > 0){
                tmp = qu.poll();
                l.add(tmp.val);
                if(tmp.left != null)
                    qu.offer(tmp.left);
                if(tmp.right != null)
                    qu.offer(tmp.right);
                size--;
            }
            ret.add(l);
            l = new ArrayList<>();
        }
        return ret;
    }
}