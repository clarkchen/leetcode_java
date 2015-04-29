package CopyListwithRandomPointer;

import java.util.HashMap;
 //time limitation 
//N ^ 2
public class Solution2 {
	 HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode> ();
	 public RandomListNode copyRandomList(RandomListNode head) {
		 	if (head==null) return null;
	        RandomListNode rt =  new RandomListNode(head.label);
	        RandomListNode cur = rt;
	        RandomListNode h = head;
	        hm.clear();
	        while(h!=null)
	        {
	        	cur.random = h.random;
	        	hm.put(h, cur);
	        	h = h.next;
	        	if(h!=null)
	        	cur.next  = new RandomListNode(h.label);
	        	cur = cur.next;	
	        }
	      
	        h = head;
	        cur = rt;
	        while (h!=null)
	        {
	        	cur.random = hm.get(h.random);
	        	cur = cur.next;
	        	h = h.next;
	        }
	        
	        return rt;
	 }
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			Solution2 s =  new Solution2();
			RandomListNode r=  new RandomListNode(-1);
			RandomListNode r2 = new RandomListNode(3);
			r.random  = r2;
			r.next =  r2;
			
			System.out.println(s.copyRandomList(r).random.label);;
		}
}
