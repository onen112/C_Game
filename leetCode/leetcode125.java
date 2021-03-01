/**
 * 题目：https://leetcode-cn.com/problems/valid-palindrome/
 * 
 * 验证回文字符串
 * 
 * 只考虑字母和数字 忽略其他字符 忽略大小写判断是否为回文串
 * 
 * 思路：
 *      定义两个下标 一个从左向右 一个从右向左
 *      找到字母或者数字进行比较判断是否相等
 *      不等返回false 最终返回true
 *  
 */
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        s = s.toLowerCase();
        while(left < right){
            while((left < right) && (s.charAt(left) < 'a' || s.charAt(left) > 'z')&& 
            (s.charAt(left) < 'A' || s.charAt(left) > 'Z')&&
            (s.charAt(left) < '0' || s.charAt(left) > '9') ){
                left++;
            }
            while((left < right)&&(s.charAt(right) < 'a' || s.charAt(right) > 'z')&&
            (s.charAt(right) < 'A' || s.charAt(right) > 'Z')&&
            (s.charAt(right) < '0' || s.charAt(right) > '9')){
                right--;
            }
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}