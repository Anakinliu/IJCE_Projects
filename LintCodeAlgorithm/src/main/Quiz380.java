package main;

/**
 * Author: Anakinliu
 * Date: 2018/03/25
 * Time: 16:48
 * You may be disappointed if you fail,
 * but you are doomed if you don't try.
 */
/*
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
请写一个程序，找到两个单链表最开始的交叉节点。
 */
public class Quiz380 {
    /*
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        ListNode cross = null;
//        ListNode backHeadA = headA;
        ListNode backHeadB = headB;
        while (headA != null) {
            headB = backHeadB;
            while (headB != null) {
                if (headA.val == headB.val) {
                    cross = headA;
                    return cross;
                }
                headB = headB.next;
            }
            headA = headA.next;
        }

        return cross;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = c;
        c.next = d;

        b.next = c;
        System.out.println(getIntersectionNode(a, b).val);
        System.out.println();
    }
}