/**
 * 题目：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 
 * 二叉树的右视图
 * 
 * 思路：
 *      用一个队列 用二叉树的层序遍历的思想
 *      当每层剩下最后一个元素时将其添加到返回的list中即可
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode p = root;
        queue.offer(p);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                p = queue.poll();
                if(p.left != null){
                    queue.offer(p.left);                    
                }
                if(p.right != null){
                    queue.offer(p.right);
                }
                if(size == 1){
                    ret.add(p.val);
                }
                size--;
            }
        }
        return ret;
    }
}
