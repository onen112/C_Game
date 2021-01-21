/**
 * 题目：https://leetcode-cn.com/problems/design-linked-list/
 * 自己实现一个链表
 *  并实现一些方法，但这样写不是很快，有待优化
 */
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(){
    }
    public ListNode(int val){
        this.val = val;
    }
}
class MyLinkedList {
    private ListNode head;
    private int len;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = new ListNode();
        this.len = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index > this.len-1 || index < 0){
            return-1;
        }
        ListNode p = this.head.next;
        while(index > 0){
            p = p.next;
            index--;
        }
        return p.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newL = new ListNode(val);
        if(this.head.next != null)
            newL.next = this.head.next;
        this.head.next = newL;
        this.len++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode p = this.head.next;
        if(p == null){
            this.addAtHead(val);
            return;
        }else{
            while(p.next != null){
            p = p.next;
        }
        p.next = new ListNode(val);
        }
        this.len++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.len){
            return;
        }
        if(index == 0){
            this.addAtHead(val);
            return;
        }
        if(index == this.len){
            this.addAtTail(val);
            return;
        }
        ListNode p = this.head.next;
        while(index > 1){
            p = p.next;
            index--;
        }
        ListNode add = new ListNode(val);
        add.next = p.next;
        p.next = add;
        this.len++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > this.len -1 ){
            return;
        }
        if(index == 0){
            head.next = head.next.next;
            this.len--;
            return;
        }
        ListNode p = this.head.next;
        while(index > 1){
            p = p.next;
            index--;
        } 
        p.next = p.next.next;     
        this.len--;
    }
}