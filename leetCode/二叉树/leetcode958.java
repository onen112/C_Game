/**
 * 题目：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 *  二叉树的完整性检验
 *  判断一颗二叉树是否为完全二叉树
 * 
 *  思路：
 *      采用类似层序遍历的方法，若当前节点不为空
 *      将当前节点的左右孩子入队，
 *      当出队时遇到null节点
 *      跳出两层循环，然后看队列中是否有非空元素
 *      如果有返回false 
 *      否则返回true
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null||(root.left==null&&root.right==null)) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //标记循环
        hear:
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                TreeNode top = queue.poll();
                //每次判断当前节点是否为空
                if(top != null){
                    //不为空将其左右孩子入队
                    queue.offer(top.left);
                    queue.offer(top.right);
                }else{
                    //跳出hear循环
                    break hear;
                }
                size--;
            }
        }
        //看队列中是否有非空元素
        while(!queue.isEmpty()){
            if(queue.poll()!=null){
                return false;
            }
        }
        return true;
    }
}