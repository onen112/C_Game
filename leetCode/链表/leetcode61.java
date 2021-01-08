/**
 * 题目：https://leetcode-cn.com/problems/rotate-list/
 *      旋转链表
 * 思路：类似于leetcode189的旋转数组
 *      先求出链表的长度，然后算出旋转的最小值
 *      顺便把链表首尾相连
 *      从链表头向后走找到旋转后的头节点的前一个节点，进行重新分割，
 *      快的嘛就不谈，然后返回新的头就行，如果链表本身为null就直接返回ok
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int len  = 0;
        ListNode p = head;
        while(p.next != null){
            len++;
            p = p.next;
        }
        len++;
        p.next = head;
        k = len - (k % len);
        p = head;
        while(k > 1){
            p = p.next;
            k--;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}