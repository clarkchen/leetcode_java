package ISLBetter;

import ISL.ListNode;


public class Solution {

	
	public ListNode insertionSortList(ListNode head) {
    ListNode helper=new ListNode(0);
    ListNode pre=helper;
    ListNode current=head;
    while(current!=null) {
        pre=helper;
        while(pre.next!=null&&pre.next.val<current.val) {
            pre=pre.next;
        }
        ListNode next=current.next;
        current.next=pre.next;
        pre.next=current;
        current=next;
    }
    return helper.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] res= {3,4,1,3,5,1};
		ListNode ln = new ListNode(1);
		ListNode cur =ln;
		for (int i=0;i<res.length;i++)
		{
			ListNode temp = new ListNode(res[i]);
			cur.next = temp;
			cur = cur.next;
		}
			
		Solution s = new Solution();
		cur = s.insertionSortList(ln);
		
		while (cur!=null)
		{
			System.out.print(cur.val+ " ");
			cur = cur.next;
		}
	}
}