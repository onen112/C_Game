/**
 * 题目：https://leetcode-cn.com/problems/design-circular-queue/
 * 设计一个循环链表实现一些方法：
 *      MyCircularQueue(k): 构造器，设置队列长度为 k 。
 *      Front: 从队首获取元素。如果队列为空，返回 -1 。
 *      Rear: 获取队尾元素。如果队列为空，返回 -1 。
 *      enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 *      deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 *      isEmpty(): 检查循环队列是否为空。
 *      isFull(): 检查循环队列是否已满。
 *
 * 采用浪费一个数组空间的方式实现循环队列，front表示队头，rear表示队尾
 * 当front == rear时队为空
 * 当(rear +  1)%elem.length == front队满
 *
 */
public class MyCircularQueue {

    private int front;//队头
    private int rear;//代表当前可以存放数据元素的下标
    private int[] elem;
    private int len;//elem的长度
    public MyCircularQueue(int k) {
        len = k+1;
        this.elem = new int[len];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 入队
     * (rear+1)  % len
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        //放到数组的rear下标  rear往后走
        this.elem[rear] = value;
        this.rear = (this.rear + 1) % this.len;
        return true;
    }

    /**
     * 队列是否为满
     * @return
     */
    public boolean isFull() {
        return (this.rear +  1)%this.len == this.front;
    }

    /**
     * 出队
     * @return
     */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        //只需要挪动front这个下标就好了
        this.front = (this.front + 1) % this.len;
        return true;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
        if(this.rear == this.front){
            return true;
        }
        return false;
    }

    /**
     * 得到队头元素
     * @return
     */
    public int Front() {
        if(this.isEmpty()){
            return -1;
        }
        return this.elem[this.front];

    }

    /**
     * 得到队尾元素
     * @return
     */
    public int Rear() {
        if(this.isEmpty()){
            return -1;
        }
        //出队需要这样，方式-1之后是上一圈的值
        return this.elem[((this.rear + elem.length)-1)%this.len];
    }
}