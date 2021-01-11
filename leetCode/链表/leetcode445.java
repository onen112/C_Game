/**
 * 两数相加2:
 *      题目：https://leetcode-cn.com/problems/add-two-numbers-ii/
 *      思路：
 *          通过栈把节点放进去，然后每次出栈一个加一个，如果有进位则保存
 *          一个栈为空，再去把另一个栈取完，都最后在判断一下进位是否为0
 *          若不是，把进位部分头查到要返回的链表中
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode l1p = l1;
        ListNode l2p = l2;
        while(l1p != null){
            s1.push(l1p);
            l1p = l1p.next;
        }
        while(l2p != null){
            s2.push(l2p);
            l2p = l2p.next;
        }
        ListNode ret = null;//保存计算结果
        int ten = 0;//保存进位
        while(!s1.empty() && !s2.empty()){
            int num = s1.pop().val + s2.pop().val + ten;
            ten = num/10;
            ret = addFirst(ret,num%10);
        }
        Stack<ListNode> s = s1.empty()?s2:s1;
        while(!s.empty()){
            int num = s.pop().val + ten;
            ten = num / 10;
            ret = addFirst(ret,num%10);
        }
        if(ten != 0){
            ret = addFirst(ret,ten);
        }
        return ret;
    }
    //头查法添加val
    public static ListNode addFirst(ListNode l,int val){
        if(l == null){
            l = new ListNode(val);
            return l;
        }else{
            ListNode add = new ListNode(val);
            add.next = l;
            return add;
        }   
    } 
}