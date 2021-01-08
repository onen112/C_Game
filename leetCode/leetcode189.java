/**
 * 题目：https://leetcode-cn.com/problems/rotate-array/
 *      旋转数组
 * 首先：旋转的距离k如果大于数组的长度则会进行循环直到走完位置
 *      那么这个循环的部分则是比较浪费时间而且没用的过程
 *      所以可以用公式：mov = k / len来求出需要旋转的最少距离就行
 *      剩下的就是移动元素
 */
public  class leetcode189 {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    public static void rotate(int[] nums, int k) {
        if(k == 0){
            return;
        }
        int len = nums.length;
        int mov = k % len;
        int[] tmp = new int[k];
        for(int i =len - mov,j = 0;i < len;i++,j++){
            tmp[j] = nums[i];
        }
        for(int i = len - mov - 1;i >=0;i--){
            nums[i + mov] = nums[i];
        }
        for(int i = 0;i < mov;i++){
            nums[i] = tmp[i];
        }
        for(int i : nums){
            System.out.print(" " + i );
        }
    }
}