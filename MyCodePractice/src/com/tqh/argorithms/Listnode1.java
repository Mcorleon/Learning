package com.tqh.argorithms;


public class Listnode1 {

    public static void main(String[] args) {
        Listnode myListNode = new Listnode(0);
        Listnode tempNode = myListNode;
        //myListNode只有有一个头结点，我们为它添加9个节点。
        // 设好下一个节点后，指针后移
        for (int i = 0; i < 10; i++) {
            myListNode.setNext(new Listnode(i + 1));
            myListNode = myListNode.getNext();
        }
        //tempNode和mylistNode指向同样的链表，此时myListnode已经后移9次
        //tempNode依然在头结点 所以遍历tempNode即可
        Listnode1 listnode1 = new Listnode1();
        /*tempNode=listnode1.InsertInLinkedList(tempNode,new Listnode(22),12);
         tempNode=listnode1.DeleteNodeFromLinkedList(tempNode,11);
        tempNode=listnode1.NthNodeFromEnd(tempNode,5);
        tempNode=listnode1.ReverseList(tempNode);*/
        tempNode=listnode1.FindMidNode(tempNode);

        //打印
        int len = listnode1.ListLength(tempNode);
        for (int i = 0; i < len; i++) {
            System.out.println(tempNode.getData());
            tempNode = tempNode.getNext();
        }

    }


    /**
     * 遍历链表
     *
     * @return 链表长度
     */
    int ListLength(Listnode headNode) {
        int length = 0;
        Listnode currentNode = headNode;
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            length++;
        }
        return length;
    }

    /**
     * 为链表添加一个节点
     */
    Listnode InsertInLinkedList(Listnode headNode, Listnode nodeToInsert, int position) {
        //如果链表为空，直接返回插入的那个节点
        if (headNode == null) {
            return nodeToInsert;
        }
        //获取目标链表长度
        int size = ListLength(headNode);
        //positon为1就在开头插入
        if (position > size + 1 || position < 1) {
            System.out.println("插入位置应该在1~" + (size + 1) + "之间");
            return headNode;
        }
        if (position == 1) {
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        }
        //在中间或末尾插入
        else {
            Listnode previousNode = headNode;
            int count = 0;
            //previous指针走到目标位置前面
            while (count < position) {
                previousNode = previousNode.getNext();
                count++;
            }
            //current指向的是目标位置后面
            Listnode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }

        return headNode;
    }

    /**
     * 删除节点
     */

    Listnode DeleteNodeFromLinkedList(Listnode headNode, int position) {
        //获取目标链表长度
        int size = ListLength(headNode);
        if (position > size || position < 1) {
            System.out.println("删除节点的位置应该在1~" + size + "之间");
            return headNode;
        }
        //positon为1就删除头结点
        if (position == 1) {
            Listnode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        }
        //中间或表尾删除
        else {
            int count = 1;
            Listnode currentNode = null;
            Listnode previousNode = headNode;
//            previousNode走到要删除的节点前面
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }

        return headNode;
    }

    /***
     * 找到倒数第N个节点
     * */
    Listnode NthNodeFromEnd(Listnode headNode, int NthNode) {
        Listnode pTemp = headNode, pNthNode = headNode;
        if (headNode == null)
            return null;
//        pTemp后移N次，pNthNode再开始
        int count = 0;
        while (count < NthNode) {
            pTemp = pTemp.getNext();
            count++;
        }
//        pTemp 和pNthnode同时后移，直到pTemp到表尾
        while (pTemp != null) {
            pTemp = pTemp.getNext();
            pNthNode = pNthNode.getNext();
        }
        return pNthNode;
    }

    /**
     * Floyd环判定
     *
     * @return 链表是否存在环
     */
    Boolean doesLinkedListCotainLoop(Listnode headNode) {
        if (headNode == null)
            return false;
//        快指针每次走2步，慢指针走1步，会相遇就有环
        Listnode slowPtr=headNode,fastPtr=headNode;
//        这样判定是因为快指针每次走2步
        while (fastPtr.getNext()!=null&&fastPtr.getNext().getNext()!=null){
            slowPtr=slowPtr.getNext();
            fastPtr=fastPtr.getNext().getNext();
            if(slowPtr==fastPtr){
                return true;
            }
        }
        return false;
    }

    /**
     *找到环的起点
     */
    Listnode findBeginLoop(Listnode headNode) {
        if (headNode == null)
            return null ;
        Boolean loopExists=false;
//        快指针每次走2步，慢指针走1步，会相遇就有环
        Listnode slowPtr=headNode,fastPtr=headNode;
        while (fastPtr.getNext()!=null&&fastPtr.getNext().getNext()!=null){
            slowPtr=slowPtr.getNext();
            fastPtr=fastPtr.getNext().getNext();
            if(slowPtr==fastPtr){
                loopExists=true;
                break;
            }
        }
        if (loopExists==false){
            return null;
        }
//        相遇后，慢指针指向重新指向头节点，各自开始每次走1步，相遇处就是环的起点
        slowPtr=headNode;
        while (slowPtr!=fastPtr){
            slowPtr=slowPtr.getNext();
            fastPtr=fastPtr.getNext();
        }
        return slowPtr;
    }
    /**
     * 计算环的长度
     * */
    int getLoopLength(Listnode headNode){
        if (headNode == null)
            return 0;
//        快指针每次走2步，慢指针走1步，会相遇就有环
        Boolean loopExists=false;
        Listnode slowPtr=headNode,fastPtr=headNode;
        while (fastPtr.getNext()!=null&&fastPtr.getNext().getNext()!=null){
            slowPtr=slowPtr.getNext();
            fastPtr=fastPtr.getNext().getNext();
            if(slowPtr==fastPtr){
                loopExists=true;
                break;
            }
        }
//        相遇后慢指针不动,快指针每次走1步，重新相遇就是环的长度。
        if (loopExists){
            int len=0;
            fastPtr=fastPtr.getNext();
            while (fastPtr!=slowPtr){
                fastPtr=fastPtr.getNext();
                len++;
            }
            return len;
        }
        return 0;
    }
    /**
     * 逆置链表
     * */
    Listnode ReverseList(Listnode headNode){
        Listnode temp=null,nextNode=null;
        while (headNode!=null){
            nextNode=headNode.getNext();
            headNode.setNext(temp);
            temp=headNode;
            headNode=nextNode;
        }
        return temp;
    }
    /**
     * 找到链表中间节点
     * */
    Listnode FindMidNode(Listnode headNode){
        Listnode fastPtr=headNode,slowPtr=headNode;
        int i=0;
//        快指针每走2步慢指针走1步，快指针走完，慢指针就到中间
        while(fastPtr.getNext()!=null){
            if(i==0){
                fastPtr=fastPtr.getNext();
                i=1;
            } else if(i==1){
                fastPtr=fastPtr.getNext();
                slowPtr=slowPtr.getNext();
                i=0;
            }
        }
        return  slowPtr;
    }
    /**
     * 两个有序链表合成新的有序链表
     */
    Listnode MergeList(Listnode a,Listnode b){
        Listnode result=null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.getData()<=b.getData()){
            result=a;
            a.setNext(MergeList(a.getNext(),b));
        }else{
            result=b;
            b.setNext(MergeList(b.getNext(),a));
        }
        return result;
    }
}

/**
 * 声明一个链表
 */
class Listnode {
    private int data;
    private Listnode next;

    public Listnode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Listnode getNext() {
        return next;
    }

    public void setNext(Listnode next) {
        this.next = next;
    }

}