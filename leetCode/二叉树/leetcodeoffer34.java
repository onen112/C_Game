/**
 * 题目：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 *  二叉树中和为某一值的路径
 *  打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 
 *  思路：
 *  用递归的方式，每次进入把当前路径的总和带入，保存该节点
 *  递归结束把该节点删除 
 *  当root.left == null && root.right == null时
 *  判断是否等于sum
 *  等于则保存路径即可
 */
class Solution {
    private List<List<Integer>> ret;
    private List<Integer> arr;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ret = new ArrayList<>();
        arr = new ArrayList<>();
        Sum(root,sum,0);
        return ret;
    }
    public void Sum(TreeNode root,int sum,int add){
        if(root == null) return;
        add += root.val;
        arr.add(root.val);
        if(root.left == null&&root.right==null){   
            if(add == sum){
                ArrayList<Integer> l = new ArrayList(Arrays.asList(new Object[arr.size()]));
                Collections.copy(l,arr);
                ret.add(l);
            }
        }else{
            Sum(root.left,sum,add);
            Sum(root.right,sum,add);
        }
        arr.remove(arr.size()-1);
    }
}