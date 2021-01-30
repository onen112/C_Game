/**
 * 题目：https://leetcode-cn.com/problems/maximum-binary-tree/
 * 最大二叉树
 *      给定一个不含重复元素的整数数组 nums 。
 *      一个以此数组直接递归构建的 最大二叉树 定义如下：
 *          二叉树的根是数组 nums 中的最大元素。
 *          左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 *          右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 
 * 思路：
 *      由递归进行构建，每次传入开始和结束位置
 *      然后寻找max的index
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createChild(nums,0,nums.length-1);
    }
    /**
    * 构建子树
    */
    public TreeNode createChild(int[] nums,int begin,int end){
        if(begin > end) return null;
        int index = findMax(nums,begin,end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = createChild(nums,begin,index-1);
        root.right = createChild(nums,index+1,end);
        return root;
    }
    /**
    * 寻找max的下标
    */
    public int findMax(int[] nums,int begin,int end){
        int max = nums[begin];
        int index = begin;
        for(int i = begin;i <= end;i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}