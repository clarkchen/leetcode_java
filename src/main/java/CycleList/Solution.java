package CycleList;

public class Solution {
	
	public Boolean testConnect(ListNode head,ListNode t)
	{
		ListNode temp = head;
		while (temp!=null)
		{
			if(temp==t) return true;
			temp = temp.next;
		}
		return false;
	}
	public ListNode  detectCycle(ListNode head){
		ListNode cur  = head;
		ListNode slow = head;
		int count = 1;
		while(cur!=null)
		{
			cur = cur.next;
			if(count%10==0)
			{
				slow = slow.next;
			}
			count++;
			if(cur==slow) 
			{break;}
		}
		if (cur==null)
		{
			return null;
		}
		
		cur = slow.next;
		slow.next =null;
		
		while(testConnect(head,cur)==false)
		{
			slow.next = cur;
			slow = cur;
			cur = cur.next;
		 	slow.next = null;
		}
		return cur;
	}
	
//	假设刚进环的时候慢指针走了m步，环的大小为n，快慢指针在距离环起点x步的时候相遇。这是慢指针走了m+x步，快指针走了2(m+x)步，
//	快指针在圈内走了2(m+x)-m=m+2x步。由于相遇在x位置，所以 m+2x % n = x，推出m+2x = i * n + x，于是m+x = i*n。我们
//	注意到慢指针已经走了x步了，再走m步时一定会回到圈的起点的(m+x = i*n)，所以等它们相遇后，一个指针从head开始走，然后慢指针
//	从相遇的位置出发，则一定会相遇到圈的起点。
	public ListNode  detectCycle2(ListNode head){
		ListNode pfast  = head;
		ListNode pslow = head;
		do {
			if(pfast != null)  
                pfast = pfast.next;  
            if(pfast != null)  
                pfast = pfast.next;  
            if(pfast == null)  
                return pfast;  
            pslow = pslow.next;  
		}while(pfast!=pslow);
		
		pfast = head;  
		while(pfast != pslow)  
        {  
            pfast = pfast.next;  
            pslow = pslow.next;   
        }  
        return pfast;  
	}
	
	
	
	public boolean hasCycle(ListNode head) {
		ListNode cur  = head;
		ListNode slow = head;
		int count = 1;
		while(cur!=null)
		{
			cur = cur.next;
			if(count%10==0)
			{
				slow = slow.next;
			}
			count++;
			if(cur==slow) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(3);
		ListNode head=l;
		
		l.next =new ListNode(4);
		l=l.next;
		
		l.next =new ListNode(2);
		l=l.next;
		ListNode s1 = l;
		l.next = new ListNode(0);
		l=l.next;
		l.next = new ListNode(-1);
		l = l.next;
		l.next = s1;
		Solution s=  new Solution();
		System.out.println(s.detectCycle2(head).val);;
	}

}
