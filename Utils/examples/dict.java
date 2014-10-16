package examples;

import java.util.HashMap;
import java.util.Iterator;
public class dict {

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
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dict d=  new dict();
		d.test();
	}

}
