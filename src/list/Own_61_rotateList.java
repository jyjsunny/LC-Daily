package list;
/*题目描述：
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 思路：
 * 需求：索引node的pre and post
 * 单链表变loop
 * 
 */
public class Own_61_rotateList {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ListNode node  = new ListNode(1);
        ListNode listhead = node;
        int i=2;
        while(i<6){
            node.next = new ListNode(i++);
            node = node.next;
        }
        int k = 2;
        RotateList(listhead,k);
    }
    public static ListNode RotateList(ListNode node, int k ){
        if(node==null||k==1)  return node;
        ListNode newhead =  node;
        int size = 1;
        while(node.next!=null){
            size++;
            node = node.next;
        }
        node.next = newhead;
        int move = k%size;
        ListNode pre = node;
        while(move>0){
            pre = newhead;
            newhead=newhead.next;
            move--;
        }
        pre.next=null;
        return newhead;
    }
}
