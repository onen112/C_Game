import java.util.*;
public class leetcode222{

    /**
     *  题目：
     *      https://leetcode-cn.com/problems/count-complete-tree-nodes/
     *  思路：
     *      求一个完全二叉树的节点个数，通过遍历进行统计
     *  缺点：
     *      时间复杂度较高，不过勉强可以通过，
     *      选择的是通过队列对二叉树的层序遍历
     *  优化点：
     *      可以使用递归的方法，似乎可以稍微快一点（暂未实现）
     */

    public static void main(String[] args) {
        
    }
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q  = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        TreeNode h = root;
        q.add(h);
        TreeNode n = q.poll();
        while(n != null){     
            l.add(n.val);
            q.add(n.left);
            q.add(n.right);
            n = q.poll();
        }
        return l.size();
    }
}