/**
 * 题目：https://leetcode-cn.com/problems/min-stack/
 *  实现最小栈
 *      push(x) —— 将元素 x 推入栈中。
 *      pop() —— 删除栈顶的元素。
 *      top() —— 获取栈顶元素。
 *      getMin() —— 检索栈中的最小元素。
 *  思路：
 *      使用两个栈，一个正常存放数据
 *      另一个每次判断要入栈的元素时候小于这个栈顶
 *      如果小于就入栈，
 *      出栈时判断两个栈的栈顶是否相等
 *      如果相等，同时出栈，否则就第一个栈出栈
 */
class MinStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    } 
    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty()||s2.peek() >= x){
            s2.push(x);
        }
    }
    
    public void pop() {
        if(!s1.isEmpty()){
            int ret = s1.pop();
            if(!s2.isEmpty() && s2.peek() == ret){
                s2.pop();
            }
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}