package ReorderList;


public class Solution {
	int getLen(ListNode head)
	{
		int len = 0;
		ListNode temp = head;
		while(temp != null)
        {
        	len++;
        	temp = temp.next;
        }
		return len;
	}
	ListNode getHalf(ListNode head, int len)
	{
		ListNode temp=head;
		int N = len %2==0 ? len/2: len/2+1;
		for(int i =0 ;i< N-1;i++)
		{
			temp = temp.next;
		}
		ListNode rtValue = temp.next;
		temp.next =null;
		return rtValue;
	}
	ListNode revserseList(ListNode head)
	{
		//assert head !=null
		if (head.next==null) return head;
		ListNode temp1 = head ;
		ListNode temp2 = head.next;
		while(temp2.next!=null)
		{
			ListNode temp3 = temp2.next;
			temp2.next = temp1;
			temp1 = temp2;
			temp2 = temp3;
		}
		temp2.next = temp1;
		head.next = null;
		return temp2;
	}
	ListNode merge(ListNode First, ListNode Second)
	{
		//assert len of first> len of second
		ListNode temp_s = Second;
		ListNode temp_f = First;
		ListNode rtValue = First;
		while (Second!=null)
		{
			temp_f = First.next;
			temp_s = Second.next;
			First.next = Second;
			Second.next = temp_f;
			First =  temp_f;
			Second =  temp_s;
			
		}
		return rtValue;
	}
	public void showList(ListNode head)
	{
		ListNode temp = head;
		while (temp!=null)
		{
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	public void reorderList(ListNode head) {
        if (head==null || head.next==null) return ;
        ListNode second = head.next ;
        
        if (second.next==null) return;
        // assert len > 2
        int len = this.getLen(head);
        //get the other half
        second = this.getHalf(head, len);
        //reverse that
        second = this.revserseList(second);
        head = this.merge(head, second);
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3;
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for (int i =2;i<N+1;i++)
		{
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		
		Solution s =  new Solution();
		//s.showList(head);
		s.reorderList(head);
		s.showList(head);
	}

}
