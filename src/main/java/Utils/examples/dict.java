package Utils.examples;

import java.util.HashMap;
import java.util.Iterator;
public class dict {
	class Node
	{
		int v;
		Node next;
	}
	public void test()
	{
		HashMap<Integer, String> hm = new HashMap<Integer,String>();
		String[] Value = new String[]{"hello","world"};
		for (int i =0;i<Value.length;i++)
		{
			hm.put(i, Value[i]);
		}
		System.out.println("Iterator Cycle");
		Iterator <Integer> i = hm.keySet().iterator();
		while(i.hasNext())
		{
			Integer key = i.next();
			System.out.println(hm.get(key));
		}
		
		System.out.println("Iterator Value Cycle");
		Iterator <String> j = hm.values().iterator();
		while (j.hasNext())
		{
			String v = j.next();
			System.out.println(v);
		}
		
		Node n1 = new Node();
		Node n2 = new Node();
		n1.v = 3;n1.next =n2;
		n2.v = 4;n2.next = n1;
		HashMap<Node, Node> hm22 = new HashMap<Node, Node>();
		hm22.put(n1, n2);
		hm22.put(n2, n1);
		
		System.out.println(hm22.get(n1).v);
		System.out.println(hm22.get(n2).v);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dict d=  new dict();
		d.test();
	}

}
