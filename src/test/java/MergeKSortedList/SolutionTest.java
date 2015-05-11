package MergeKSortedList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/5/7.
 */
public class SolutionTest {

    @Test
    public void testMergeK() throws Exception {
        ListNode lists[]=new ListNode[3];
        lists[0]=new ListNode(2);
        ListNode a1=new ListNode(3);
        ListNode a2=new ListNode(4);
        ListNode a3=new ListNode(20);
        ListNode a4=new ListNode(9);
        ListNode a5=new ListNode(14);
        ListNode a6=new ListNode(19);
        lists[0].next=a1;
        a1.next=a3;
        lists[1]=a2;
        a2.next=a4;
        lists[2]=a5;
        a5.next=a6;
        Solution m=new Solution();
        ListNode p=m.mergeKLists(lists);
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
}