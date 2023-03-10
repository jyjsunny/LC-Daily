package list;
/*
 需求分析：
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
思路：
    设置pre和node，每两个点为一组表示关系、进行交换

 */
public class Own_24_swapList {
    public static void main(String[] args){
        System.out.println("Hello, World!");
        ListNode node  = new ListNode(1);
        ListNode listhead = node;
        int i=2;
        while(i<6){
            node.next = new ListNode(i++);
            node = node.next;
        }
        int k = 2;
        SwapList(listhead);
    }

    public static ListNode SwapList(ListNode node){
        /*方法一：
        if(node==null||node.next==null)  return node;
        ListNode newhead = node.next;
        ListNode pre = new ListNode();
        pre.next = node;

        while(node!=null&&node.next!=null){
            pre.next = node.next;
            node.next = node.next.next;
            pre.next.next = node;
            pre = node;
            node = pre.next;
        }
        

        return newhead;
        */
        
        //方法二：递归
        //递归：1）终止条件，2）返回值，3）单步过程
        //终止条件
        if(node==null||node.next==null)
        {
            return node;
        }
        ListNode next = node.next;
        //单步过程
        node.next= SwapList(next.next);
        next.next=node;
        //返回值
        return next;
    }
}
