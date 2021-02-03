/**
 * 题目：https://leetcode-cn.com/problems/sliding-window-median/
 * 滑动窗口的中位数
 * 
 * 思路：维护一个ArrayList
 *      先放入k个元素，排好序，以后每次移动滑动窗口
 *      移除最早的元素，添加新的元素 新入的元素按照大小插入到自己的位置
 *      这样就不用每次排序了
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
      double[] ret = new double[nums.length-k+1];
      int index = 0;
      int i = 0;
      //维护这个保持数组中只有k个元素
      ArrayList<Double> pq = new ArrayList<>();
      for(;i < k;i++){
          pq.add((double)nums[i]);
      }
      pq.sort(new Comparator<Double>() {
          public int compare(Double o1, Double o2) {
              return (int)(o1-o2);
          }
      });
      while(i <= nums.length){
          /**
           * 添加中位数
           */
          if(k % 2 != 0){
              ret[index] = pq.get(k/2);
          }else{
              ret[index] = (pq.get(k/2-1) + pq.get((k/2)))/2;
          }
          if(i >= nums.length) break;
          pq.remove(Double.valueOf(nums[i-k]));
          add(pq,nums[i]);
          index++;
          i++;
      }
      return ret;
  }
  /**
   * 用于插入新的元素到指定位置
   */
  public void add(ArrayList<Double> list,double val){
      if(list.size()==0||val <= list.get(0)) {
          list.add(0,val);
          return;
      }
      for(int i = 0;i < list.size()-1;i++){
          if(val > list.get(i)&&val <= list.get(i+1)){
              list.add(i+1,val);
              return;
          }
      }
      list.add(list.size(),val);
  }
}