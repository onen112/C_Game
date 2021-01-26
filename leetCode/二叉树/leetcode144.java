/**
 * 题目：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 二叉树的前序遍历
 * 写了
 *  递归实现和
 *      正常的前序遍历方式
 *  非递归实现
 *      通过栈来实现
 */
//非递归（稍微慢了点）
class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root == null){
            return ret;
        }
        if(root != null){
            st.push(root);
        }
        while(!st.empty()){
            TreeNode t1 = st.pop();
            if(t1.right != null){
                st.push(t1.right);
            }
            if(t1.left != null){
                st.push(t1.left);
            }
            ret.add(t1.val);
        }
        return ret;
    }
}
//递归实现
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        pre(root,l);
        return l;
    }
    public void pre(TreeNode root,List l){
        if(root == null) return;
        l.add(root.val);
        pre(root.left,l);
        pre(root.right,l);
    }
}