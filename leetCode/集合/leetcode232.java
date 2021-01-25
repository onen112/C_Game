/**
 * 题目：https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *  用栈实现队列
 *  
 *  思路：
 *  定义两个栈s1,s2
 *  其中s1只负责入栈,出栈时若s2为空，
 *  将s1中的所有元素出栈并入到s2中
 *  若不为空，直接从s2出栈即可
 */
class MyQueue {

    private Stack<Integer> s1 = new Stack<>();//入队
    private Stack<Integer> s2 = new Stack<>();//出队

    /** Initialize your data structure here. */
    public MyQueue() {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!s2.isEmpty()){
            return s2.pop();
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
        
    }
    
    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
    }
}