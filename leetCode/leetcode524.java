/**
 * 题目：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 
 * 通过删除字母匹配到字典里最长单词
 *      给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 *      该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，
 *      返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * 思路
 *      逐个用字典中的单词去匹配字符串 s
 *      如果字典中的对应字符串在s 中以相应的顺序出现匹配成功
 *      最终保留最长的一个并返回即可
 */
class Solution {
    public  String findLongestWord(String s, List<String> d) {
       String ret = "";
       for(String str : d){

           if(isEq(s,str)){
               if(str.length() == ret.length()){
                   ret = str.compareTo(ret) < 0?str:ret;
               }else{
                   ret = str.length() > ret.length()?str:ret;
               }
           }
       }
       return ret;
   }
   public boolean isEq(String s1,String s2){
       if(s1.length() < s2.length()) return false;
       int j = 0;
       for(int i = 0;i < s2.length();i++){
           boolean flag = true;
           for(;j < s1.length();j++){
               if(s1.charAt(j) == s2.charAt(i)){
                   flag = false;
                   break;
               }
           }
           j++;
           if(flag){
               return false;
           }
       }
       return true;
   }
}