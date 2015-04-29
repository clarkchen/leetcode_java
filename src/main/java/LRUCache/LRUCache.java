import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;


public class LRUCache {

   class Node{
		int key;
		int value;
		Node next,pre;
		public Node(int k,int v)
		{key=k;value=v;next=pre=null;}
   }
   Node head,tail;
   int capacity;
   HashMap<Integer, Node> nodes;
   
   public LRUCache(int capacity)
   {
	   this.capacity = capacity;
	   head=null;
	   tail=null;
	   nodes =  new HashMap<Integer, LRUCache.Node>();
   }
   
   void addBeforeHead(int key,int value)
   {
	   Node cur = new Node(key, value);
	   nodes.put(key, cur);
	   if(head==null)
	   {
		   head = tail = cur;
		   return;
	   }
	   cur.next = head;
	   head.pre = cur;
	   head = cur;
	}
   
   public void updateToHead(Node cur)
   {
	   assert cur!=null;
	   if(head == cur) return;
	   
	   Node n =cur.pre;
	   n.next = cur.next;
	   if(cur==tail)
	   {
		   tail = cur.pre;
       }
	   else cur.next.pre = n;
		
	   cur.next = head;
	   cur.pre = null;
	   head.pre = cur;
	   head = cur;
   }
   
   public void set(int key, int value)
   {  
	   if(head==null )
	   {
		   addBeforeHead(key, value);
	   }
	   else{
		   
		   Node cur = nodes.get(key);
		   if(cur==null && nodes.size()< capacity)
		   {
			 addBeforeHead(key, value);return;
		   }   
		   else if(cur==null){
			   cur = tail;
			   nodes.remove(tail.key);
			   cur.key = key;
			   nodes.put(key, cur);
		   }
		   cur.value = value;
		   updateToHead(cur);
	   }  
}
   public int get(int key)
   {
	   if(head==null) return -1;
	   if(!nodes.containsKey(key)) return -1;
	   Node cur = nodes.get(key);
	   updateToHead(cur);
	   return cur.value;
   }
   public static void main(String[] args)
   {
	   LRUCache l = new LRUCache(2);
	   l.set(2,1);
	   l.set(2,2);
	   System.out.println(l.get(2));
	   l.set(1,1);
	   l.set(4,1);
	   System.out.println(l.get(2));
	   System.out.println(l.get(4));
	   l.set(4,5);
	   System.out.println(l.get(4));


   }
	

}
