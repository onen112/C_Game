/**
 *  力扣2021 01 03每日一题
 *  题目：
 *      https://leetcode-cn.com/problems/partition-list/submissions/
 *  大致是保留原有的顺序，以x分隔链表
 *  
 *  思路：
 *      定义两个链表，一个保存比x小的值，另一个保存大于或等于x值
 *      最后返回拼接之后的新数组
 *  时间复杂度：
 *      O(n)
 */

public class leetcode86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n = head;
        n.next = new ListNode(4);
        n = n.next;
        n.next = new ListNode(3);
        n = n.next;
        n.next = new ListNode(2);
        n = n.next;
        n.next = new ListNode(5);
        n = n.next;
        n.next = new ListNode(2);
        n = n.next;
        ListNode node = partition(head, 3);
        while(node != null){
            System.out.print(node.val + "  ");
            node = node.next;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode();
        ListNode lp = l;
        ListNode r = new ListNode();
        ListNode rp = r;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                add(lp,p.val);
                lp = lp.next;
            }else{
                add(rp,p.val);
                rp = rp.next;
            }
            p = p.next;
        }
        lp.next = r.next;
        return l.next;
    }
    public static void add(ListNode p,int val){
        ListNode a = new ListNode(val);
        p.next = a;
    }
}