/**
 * 题目：https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * 
 * 数组中出现次数超过一半的数
 */
public class Solution { public int MoreThanHalfNum_Solution(int [] array) { if(array == null || array.length==0) { return 0; }int result = array[0]; int times = 1; // 次数 for(int i=1;i<array.length;++i){ if(times != 0){ if(array[i] == result) { ++times; // 相同则加1 }else{--times; // 不同则减1
    比特科技
    } }else { // 更新result的值为当前元素，并置次数为1 result = array[i]; times = 1; } }// 判断result是否符合条件，即出现次数大于数组长度的一半 times = 0; for(int i=0;i<array.length;++i){ if(array[i] == result) ++times; }return (times > array.length/2) ? result : 0; }}