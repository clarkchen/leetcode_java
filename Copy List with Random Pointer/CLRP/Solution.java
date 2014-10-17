package CLRP;
 //time limitation 
//N ^ 2
public class Solution {
	 int find(RandomListNode head, RandomListNode target)
	 {
		 if(target.random==null) return -1;
		
		 RandomListNode cur = head;
		 int i = 0;
		 while(cur!=null && cur!=target.random)
		 {
			 cur = cur.next;i++;
		 }
		 return i;
	 }
	 RandomListNode find(RandomListNode head, int i)
	 {
		 if(i==-1) return null;
		 RandomListNode rln = head;
		 for(int k=1;k<=i;k++)
		 {
			 rln = rln.next;
		 }
		 return rln;
	 }
	 public RandomListNode copyRandomList(RandomListNode head) {
		 	if (head==null) return null;
	        RandomListNode rt =  new RandomListNode(head.label);
	        RandomListNode cur = rt;
	        RandomListNode h = head.next;
	        while(h!=null)
	        {
	        	cur.next  = new RandomListNode(h.label);
	        	cur = cur.next;
	        	h = h.next;
	        }
	        h = head;
	        cur = rt;
	        while (h!=null)
	        {
	        	int i = this.find(head, h);
	        	cur.random = this.find(rt, i);
	        	cur = cur.next;
	        	h = h.next;
	        }
	        
	        return rt;
	 }
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			Solution s =  new Solution();
			RandomListNode r=  new RandomListNode(-1);
			
			System.out.println(s.copyRandomList(r).label);;
		}
}
