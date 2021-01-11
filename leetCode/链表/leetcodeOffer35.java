/**
 * 题目：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *      拷贝复杂链表，每个节点除了next，val还有一个random域，拷贝这个链表
 *      解法：
 *          定一个： Map<Node,Node> map = new HashMap<>();的map
 *          key是原始的链表的节点，value是新的链表的节点
 *          通过当前节点可以定位到拷贝后的节点
 *          然后把value的节点连起来
 *          返回map.get(head);即可，很妙 
 *          
 */
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}