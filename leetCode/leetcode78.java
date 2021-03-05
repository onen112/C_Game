/**
 * 题目：https://leetcode-cn.com/problems/subsets/
 * 
 * 子集
 * 
 * 思路：
 *      深度优先搜索（dfs） 
 */
class Solution {
    List<List<Integer>> ret;
   public List<List<Integer>> subsets(int[] nums) {
       ret = new ArrayList<>();
       ret.add(new ArrayList<>());
       for(int i = 0;i < nums.length;i++){
           List<Integer> val = new ArrayList<>();
           val.add(nums[i]);
           dfs(val,nums,i);
       }
       return ret;
   }
   public void dfs (List<Integer> val,int[] nums,int i){
       //这样的list不能直接用list的add或者一些方法需要在new一下
       List<Integer> tmp = Arrays.asList(new Integer[val.size()]);
       Collections.copy(tmp,val);
       tmp = new ArrayList<>(tmp);
       ret.add(tmp);
       if(i == nums.length) return;
       for(int j = i+1;j < nums.length;j++){
           dfs(tmp,nums,j);
           tmp.add(nums[j]);
       }
   }
}