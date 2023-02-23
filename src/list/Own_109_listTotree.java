package list;

import java.util.ArrayList;

/*
 * 题目描述：
 * 将一个值升序排序的链表转换为一个高度平衡二叉搜索树
 * （左右子树高度之差不能大于1）
 * 
 * 思路：
 * 
 */
public class Own_109_listTotree {
    public static ArrayList<Integer> alist = new ArrayList<>();
    public static void main(String args[]){
        System.out.println("Hello, World!");
        ListNode node  = new ListNode(1);
        ListNode listhead = node;
        int i=0;
        while(i<5){
            node.next = new ListNode(i++);
            node = node.next;
        }
        
        TreeNode resTree = listTotree(listhead);
        System.out.println(resTree.left.val);
        System.out.println(resTree.right.val);
        System.out.println(resTree.val);
    }
    public static TreeNode listTotree(ListNode node){
        if(node==null)  return null;
        if(node.next==null) return new TreeNode(node.val);
        TreeNode resTree = new TreeNode();
        while(node!=null){//遍历linkedlist存储并后续索引
            alist.add(node.val);
            node = node.next;
        }
        int len = alist.size();
    
        return  construct(0,len-1);
    }
    public static TreeNode construct(int l, int r){
        if(l==r)    return new TreeNode(alist.get(l));
        int mid = (l+r+1)/2;
        
        
        if(l==mid)  return new TreeNode(alist.get(mid),null,construct(mid+1,r));
        if(r==mid)  return new TreeNode(alist.get(mid), construct(l,mid-1),null);
        

        return new TreeNode(alist.get(mid),construct(l,mid-1), construct(mid+1,r));
        
    }
}









