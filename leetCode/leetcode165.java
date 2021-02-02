/**
 * 题目：https://leetcode-cn.com/problems/compare-version-numbers/
 * 比较版本号
 * 
 * 思路：
 *      用字符串分割的方法用 "." 进行分割
 *      完了之后每部分转换为整数比较大小（前面会有0） 
 */
class Solution {
    public static int compareVersion(String version1, String version2) {
      String[] arr1 = version1.split("\\.");
      String[] arr2 = version2.split("\\.");

      int i = 0;
      int j = 0;
      while(i < arr1.length&&j < arr2.length){
          if(Integer.valueOf(arr1[i]) < Integer.valueOf(arr2[j])){
              return -1;
          }else if(Integer.valueOf(arr1[i]) > Integer.valueOf(arr2[j])){
              return 1;
          }
          i++;
          j++;
      }
      while(i < arr1.length){
          if(Integer.valueOf(arr1[i]) != 0){
              return 1;
          }
          i++;
      }
      while(j < arr2.length){
          if(Integer.valueOf(arr2[j]) != 0){
              return -1;
          }
          j++;
      }
      return 0;
  }
}