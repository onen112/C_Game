/**
 * 题目：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 至少有 K 个重复字符的最长子串
 * 
 * 思路
 *      暴力求解 用数组chars[26]表示该子串每个字母出现的次数
 *      
 */
class Solution {
    public int longestSubstring(String s, int k) {
        int ret = 0;
        
        int left = 0;
        int right = 0;
        int[] chars = new int[26];
        while(left < s.length()){
            chars[left-'a']++;
            while(right < s.length()){
                chars[right-'a']++;
                if(isSub(chars,k)){
                    ret = Math.max(ret,right-left+1);
                }
                right++;
            }
            chars[left--];
            left++;
            
        }

        return ret;
    }
    public boolean isSub(int[] chars,int k){
        for(int i = 0;i < chars.length;i++){
            if(chars[i] < k && chars[i] != 0){
                return false;
            }
        }
        return true;
    }
}