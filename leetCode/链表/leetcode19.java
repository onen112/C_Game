/**
 * 题目：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 
 * 删除链表的倒数第n个节点
 * 
 * 思路：
 *      采用快慢指针的方式 快的f  慢的s
 *      让f先走n步，如果 n == null  则要删的是头节点
 *      返回 head.next 即可 否则就让f节点和s节点一起走
 *      走到f.next == null
 *      将s删除即可,返回head
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head;
        ListNode s = head;
        if(head == null || (head.next == null)&&(n == 1)){
            return null;
        }
        while(n != 0){
            f = f.next;
            n--;
        }
        if(f == null){
            return head.next;
        }
        while(f.next != null){
            f = f.next;
            s = s.next;
        }
        if(s.next != null){
            s.next = s.next.next;
        }
        return head;
    }
}