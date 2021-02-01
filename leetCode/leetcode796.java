/**
 * 题目：https://leetcode-cn.com/problems/rotate-string/
 * 
 * 旋转字符串
 * 思路：
 *  定义一个方法用于旋转字符串A
 *  然后旋转的位数每次++
 *  旋转一次，判断一次是否与字符串B相等
 *  如果相等直接返回true  
 *  遍历完了也不相等返回false
 */y
class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.equals(B)) return true;
        for(int i = 1;i < A.length();i++){
            if(A.charAt(i) == B.charAt(0)){
                if(move(i,A).equals(B)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * i为每次旋转几位 
     */
    public String move(int i,String A){
        if(i == A.length()){
            return A;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A,i,A.length());
        sb.append(A,0,i);
        return sb.toString();
    }
}