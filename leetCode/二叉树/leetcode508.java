/**
 * 题目：https://leetcode-cn.com/problems/most-frequent-subtree-sum/
 * 
 * 出现次数最多的子树元素和
 * 
 * 思路：
 *      定义全局的Map List 和一个int 的 max
 *      map中保存每个值出现的次数  list中保存当前的出现次数最大值的数
 *      max保存当前的最多的次数
 *      二叉树的值用递归的思想 分别求左右子🌲的值加上root的值就是当前的和
 */
class Solution {
    int max;
    Map<Integer,Integer> map;
    List<Integer> list;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        max = 0;
        map = new HashMap<>();
        list = new ArrayList<>();
        post(root);
        int[] ret = new int[list.size()];
        int i = 0;
        for(int n : list){
            ret[i++] = n;
        }
        return ret;
    }
    public int post(TreeNode root){
        if(root.left != null){
            root.val += post(root.left);
        }
        if(root.right != null){
            root.val += post(root.right);
        }
        int n = map.getOrDefault(root.val,0)+1;
        map.put(root.val,n);

        //这个元素的出现次数等于当前的最大出现次数 将其添加
        if(n == max){
            list.add(root.val);
        }else if(n > max){
            //当前出现次数大于max了 需要修改max 并清空之前的list 添加当前的值
            list.clear();
            list.add(root.val);
            max = n;
        }
        return root.val;
    }
}