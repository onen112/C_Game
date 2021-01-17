/**
 * 题目：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *      交换链表了两两相邻的节点
 *      
 *  思路：
 *      除了第一个第二个节点，后面的节点都可以直接交换
 *          用一个指针p（指向前一个节点）和一个指针c（表示当前节点）
 *          进行交换即可，直到c==null ｜｜ c.next==null结束
 *          在一开始交换第一个节点和第二个节点即可
 */


public class leetcode24 {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode p = l;
        l.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);

        ListNode head = swapPairs(l);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        //只有一个节点，或者没有节点直接返回head
        if(head == null || head.next == null){
            return head;
        }
        //交换第一二个节点
        ListNode p = head.next;
        head.next = p.next;
        p.next = head;
        head = p;
        //p指向前一个节点，c表示当前节点 
        p = head.next;
        ListNode c = head.next.next;
        while(c != null&&c.next!=null){
            p.next = c.next;
            c.next = c.next.next;
            p.next.next = c;
            p = c;
            c = c.next;
        }
        return head;
    }
}