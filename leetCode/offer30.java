/**
 * 题目：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 
 * 包含min函数的栈
 * 
 * 需要每次保存一个min值 并且返回的时间复杂度都是 o1
 * 
 * 定义栈的数组时多加一个值 保存当前位置的最小值即可解决
 * 
 * 
 */

class MinStack {
    private int[][] st;
    private int top;
    /** initialize your data structure here. */
    public MinStack() {
        st = new int[20010][2];
        top = 0;
    }
    
    public void push(int x) {
        st[top][0] = x;
        //若第一次入栈 最小值是自己
        if(top == 0){
            st[top++][1] = x;
        }else{
            //前面有元素 当前的最小值为前一个的最小值和当前值的小的那个
            st[top][1] = Math.min(x,st[top-1][1]);
            top++;
        }
        
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return st[top-1][0];
    }
    
    public int min() {
        return st[top-1][1];
    }
}