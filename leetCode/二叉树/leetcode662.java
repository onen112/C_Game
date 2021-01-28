/**
 * 题目：https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 * 二叉树的最大宽度
 * 
 * 旧的思路：
 *      一开始想用层序遍历的方式，
 *      判断队列中的size大小，
 *      但要存放null值所以
 *      数据过于庞大，可能会超时
 * 
 * 思路：
 *      有些投机取巧的方法
 * 
 *      还是采用层序遍历，但是不用存储null节点
 *      把root节点的值设置为 1 然后进行层序遍历
 *      每次把拿出的节点的左右孩子的val值修改为
 *      n*2 和 n*2+1    在入队
 *      最终该列的宽度为队列最后一个元素 - 第一个元素（val）+1
 *      
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);
        int max = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //保存该列第一个节点的val
            int left = queue.peek().val;
            while(size != 0){
                TreeNode top = queue.poll();
                if(size == 1){
                    //该列最后一个节点的val
                    max = Math.max(max,top.val-left+1);
                }
                if(top.left != null){
                    //修改左孩子的值
                    top.left.val = top.val*2;
                    queue.offer(top.left);
                }
                if(top.right != null){
                    //修改右孩子的值
                    top.right.val = top.val*2+1;
                    queue.offer(top.right);
                }
                size--;
            }
        }
        return max;
    }
}