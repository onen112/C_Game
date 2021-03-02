/**
 * 题目：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 
 * 最长回文子串
 * 
 * 思路
 *      1. 由于字符串长度可能是奇数 也可能是偶数 所有在每个字母之间加上 '#'从而使长度一定是奇数
 *          如：ababd -> #a#b#a#b#d#   abab -> #a#b#a#b#
 *          这样即不会改变本身的回文性 还能避免进行分类讨论
 *      2. 定义 i 从1下标起向后走 用半径法 (定义一个len为半径 每次判断 以 i 为圆心 len 为半径画圆)
 *          判断这个半径范围内字符串是否为回文字符串 如果是 len++ 继续判断 并更新h(保存长度最大的圆心位置)的值
 *      
 */
class Solution {
    public String longestPalindrome(String s) {
        char[] chars = new char[2*s.length()+1];
        int n = 1;
        //添加 # 
        chars[0] = '#';
        for(int i = 0;i < s.length();i++){
            chars[n++] = s.charAt(i);
            chars[n++] = '#';
        }
        int len = 1;
        int h = 0;

        for(int i = 1;i < chars.length;i++){
            //  是回文串 更新h 并进行扩容len
            if(isPalind(len,i,chars)){
                h = i;
                while(isPalind(len,i,chars)){
                    len++;
                }
                //while中最后一次++是无效的 减去
                len--;
            }
        }
        //去除 #  拼接并返回
        StringBuilder sb = new StringBuilder();
        for(int i = h - len+1;i < h + len;i++){
            if(chars[i] != '#'){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    /**
     * 判断是否为回文串
     * len 半径
     * h   圆心
     * chars 要判断的数组
     */
    public boolean isPalind(int len,int h,char[] chars){
        int l = h;
        int r = h;
        while(l > h-len){
            if(l < 0 || r >= chars.length||chars[l] != chars[r]){
                return false;
            }
            l--;
            r++;
        }
        return true;
    }
}