package SortList;
public class Solution {
    public ListNode sortList(ListNode head) {
    	if (head == null) return null;
    	
    	ListNode start=head;
    	ListNode mid = splitList(start);
    	if (mid == null) return head;

    	start = sortList(start);
    	mid = sortList(mid);
    	
    	return mergeListNode(start, mid);
    }
    private ListNode splitList(ListNode head){
    	int n = getsize(head);
    	ListNode cur = head;
    	for (int i =0;i<n/2-1;i++)
    	{
    		cur = cur.next;
    	}
    	ListNode temp = cur.next;
    	cur.next = null;
    	return temp;
    	
    }
    
    private int getsize(ListNode head)
    {
    	ListNode cur = head;
    	int step = 0;
    	 
    	while (cur!=null)
    	{
    		step+=1;
    		cur = cur.next;
    			
    	}
    	return step;
    }
    private ListNode mergeListNode(ListNode ln1, ListNode ln2)
    {
    	if(ln1 == null) return ln2;
    	if(ln2==null) return ln1;
    	ListNode tail= null;
    	ListNode head=null;
    	ListNode cur=null;
    	while (ln1!=null && ln2!=null)
    	{
    		
    		if(ln1.val<=ln2.val )
    		{
    			cur = ln1;
    			ln1=  ln1.next;
        	}
        	else if(ln1.val>ln2.val )
        	{
        		cur = ln2;
        		ln2 = ln2.next;
        	}
    		if (head==null)
			{
				head= cur;
				tail = cur;
			}
			else
			{
				tail.next = cur;
				tail= tail.next;
			}
    	}
    	if (ln1==null) tail.next = ln2;
    	if (ln2==null) tail.next = ln1; 
    	return head;
    	
    }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] res= {5,3,6,4,2,100,89,9,9};
		ListNode ln = new ListNode(1);
		ListNode cur =ln;
		for (int i=0;i<res.length;i++)
		{
			ListNode temp = new ListNode(res[i]);
			cur.next = temp;
			cur = cur.next;
			
		}
			
		Solution s = new Solution();
		cur = s.sortList(ln);
		
		while (cur!=null)
		{
			System.out.print(cur.val+ " ");
			cur = cur.next;
		}
	}

}
