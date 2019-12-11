package com.tqh.contest;

/**
 * @Author Mcorleon
 * @Date 2019/8/8 20:05
 * 链表原地排序（不使用堆空间），小于target在左边，大于target在右边
 */
public class Main15 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode res=solve(node1,4);
        while (res!=null){
            System.out.print(res.val+",");
            res=res.next;
        }
    }

    private static ListNode solve(ListNode head, int targe) {
        ListNode p=head,r=null,l=head;
        while (p!=null){
            if(p.val==targe){
                l=p;
                r=p;
                break;
            }
            p=p.next;
        }
        p=head;
        while (p!=null){
            ListNode next=p.next;
            if(next!=null&&next.val==targe){
                next=next.next;
            }
            if(p.val<targe){
                p.next=l;
                l=p;
            }else if(p.val>targe){
                p.next=null;
                r.next=p;
                r=r.next;
            }
            p=next;
        }
        return l;
    }
}

