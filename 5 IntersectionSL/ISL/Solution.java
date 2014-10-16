package ISL;



public class Solution {
	 public ListNode insertionSortList(ListNode head) {
		 if (head==null) return null;
		 ListNode cur = head.next;
		 ListNode tail = head;
		 while (cur!=null)
		 {	
			 ListNode insertValue = cur;
			 if(insertValue.val < head.val)
			 {
				 tail.next = insertValue.next;
				 insertValue.next =head;
				 head = insertValue;
	 		 }
			 
			 if (insertValue.val >= tail.val)
			 {
				 tail.next = insertValue;
				 tail = insertValue;
			 }
			 
			 ListNode res = head;
			 while (res != insertValue)
			 {
				 int temp = res.next.val;
				 if(insertValue.val < temp)
				 {
					 tail.next = insertValue.next;
					 insertValue.next = res.next;
					 res.next = insertValue;
				 }
				 else res = res.next;
			 }
			 cur = tail.next;
		 }
		 return head;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] res= {1};
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
