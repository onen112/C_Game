/**
 * 题目：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *      采用快慢指针，快的是慢的二倍，如果fast==null|| fast.next == null
 *      说明没有环，返回false
 *      否则当fast和slow相等时结束循环
 *      从现在开始，让s=head
 *      然后没人每次走一步，相遇的点就是环的入口结点
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
         if(head == null || head.next == null){
             return null;
         }
         ListNode f = head;
         ListNode s = head;
         while(f != null && f.next!= null){
             f = f.next.next;
             s = s.next;
             if(f == s){
                 break;
             }
         }
         if(f != s){
             //没有环
             return null;
         }else{
             s = head;
             while(s != f){
                 s = s.next;
                 f = f.next;
             }
         }
         return s;
     }
 }