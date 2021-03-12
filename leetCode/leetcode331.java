/**
 * 题目：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 
 * 验证二叉树的前序序列化
 * 
 * 思路：定义一个栈 用曹位看待每个节点 遇到数字会占用一个 槽位 同时产生两个新槽位
 *      遇到 # 会占用一个槽位 并不会产生新的槽位
 *      如此可以维护栈 当槽位不够是返回false 槽位减到0从栈中删除
 *      最终判断遍历结束 栈是否为空
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
       if(preorder.length() == 0) return false;
       if(preorder.charAt(0) == '#' && preorder.length() == 1) return true;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        if(preorder.charAt(i) != '#'){
            while(i < preorder.length() && preorder.charAt(i) <= '9' && preorder.charAt(i) >= '0'){
                i++;
            }
            stack.push(2);
        }
        while(i < preorder.length()){
            if(preorder.charAt(i) == ','){
                i++;
            }else if(preorder.charAt(i) == '#'){
                i++;
                if(stack.isEmpty()){
                    return false;
                }
                int n = stack.pop();
                if(n == 0){
                    return false;
                }else if(n == 2){
                    stack.push(1);
                }
            }else{
                while(i < preorder.length() && preorder.charAt(i) <= '9' && preorder.charAt(i) >= '0'){
                    i++;
                }
                if(stack.isEmpty()){
                    return false;
                }
                int n = stack.pop();
                if(n == 0){
                    return false;
                }else if(n == 2){
                    stack.push(1);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}