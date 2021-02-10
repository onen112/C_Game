/**
 * 题目：https://leetcode-cn.com/problems/permutation-in-string/
 * 
 * 字符串的排列
 *      给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *      换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 思路
 *   输入只有小写字母 所以 定义长度为26的 一个数组保存s1所包含的字符   
 *   然后用双指针去s2中寻找，如果那一段的字符串与s1的数组相同
 *   返回true 否则返回false   
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if(s1.length() > s2.length()) return false;
        int[] arr1 = new int[26];
        for(int i = 0;i < s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }
        int start = 0;
        int end;
        while(start < s2.length()){
            int[] arr2 = new int[26];
            end = start + s1.length() - 1;
            for(int i = start;i < s2.length()&&i <= end;i++){
                arr2[s2.charAt(i)-'a']++;
            }
            if(Arrays.equals(arr1,arr2)){
                return true;
            }
            start++;
        }
        return false;
    }
}