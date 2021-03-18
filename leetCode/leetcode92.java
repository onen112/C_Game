/**
 * 题目 ：https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 
 * 反转链表 II
 * 
 * 思路：
 *      先把前n个节点q节点全部放入栈中
 *      之后每次出栈 出n-i个元素 进行反转
 *      最终将剩下的串起来即可
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int i, int n) {
        Stack<ListNode> stack = new Stack<>();
        i = n-i;
        while(n != 0){
            stack.push(head);
            head = head.next;
            n--;
        }
        ListNode tmp = stack.pop();
        ListNode p = tmp;
        while(i != 0){
            tmp.next = stack.pop();
            tmp = tmp.next;
            i--;
        }
        tmp.next = head;
        ListNode p1;
        while(!stack.isEmpty()){
            p1 = stack.pop();
            p1.next = p;
            p = p1;
        }
        return p;
    }
}