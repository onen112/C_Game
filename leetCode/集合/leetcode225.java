/**
 * 题目：https://leetcode-cn.com/problems/implement-stack-using-queues/
 *  用队列实现栈
 *  
 * 思路：
 *      定义两个队列q1，q2
 *      入栈：若两个队列都为空，默认入到q1中
 *          否则入到空的队列中
 *      出栈：把非空的队列出队size-1个元素，返回最后一个元素
 *      是否为空：当两个队列都为空，则为空，否则不空
 */
class MyStack {
    private Queue<Integer> qu1 = new LinkedList<>();
    private Queue<Integer> qu2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }
    /** Push element x onto stack. */
    public void push(int x) {
        //谁不为空入到哪个队列当中
        if(this.empty()){
            qu1.offer(x);
        }else if(qu1.isEmpty()){
            qu2.offer(x);
        }else{
            qu1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //每次出不为空的队列，出size-1个 到另外一个为空的队列，最后弹出剩余的那一个元素
        Queue<Integer> tmp = qu1.isEmpty()?qu2:qu1;
        Queue<Integer> tmp2 = qu1.isEmpty()?qu1:qu2;
        while(tmp.size() > 1){
            tmp2.offer(tmp.poll());
        }
        return tmp.poll();
    }

    /** Get the top element. */
    public int top() {
        //每次出不为空的队列，出size-1个 到另外一个为空的队列，最后弹出剩余的那一个元素
        Queue<Integer> tmp = qu1.isEmpty()?qu2:qu1;
        Queue<Integer> tmp2 = qu1.isEmpty()?qu1:qu2;
        while(tmp.size() > 1){
            tmp2.offer(tmp.poll());
        }
        int ret = tmp.poll();
        tmp2.offer(ret);
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qu1.isEmpty()&&qu2.isEmpty();
    }
}