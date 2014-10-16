package wordbreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Solution {
	
	void findIndex(String s, Set<String> dict,HashMap<Integer, ArrayList<Integer>> hr)
	{
		Iterator<String>  it=  dict.iterator();
		while(it.hasNext())
		{
			String d =it.next();
			if(d.length()==0) continue;
			int index = s.indexOf(d);
			if(index==-1) continue;
			do
			{
				if(!hr.containsKey(index))
				{
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(index+d.length());
					hr.put(index,l);
				}
				else 
				{
					hr.get(index).add(index+d.length());
				}
				index = s.indexOf(d,index+d.length());
			}while (index!=-1);
			
		}
	}
	Boolean test(int key,HashMap<Integer, ArrayList<Integer>> hr,String s )
	{
		ArrayList<Integer> nodes=  hr.get(key);
		if(nodes==null||nodes.size()==0) return false;
		for(int i = 0;i<nodes.size();i++)
		{
			int next = nodes.get(i);
			if(next == s.length()) return true;
			if(test(next,hr,s)==true) return true;
		}
		return false;
	}
	public boolean wordBreak(String s, Set<String> dict) {
			if(s.length()==0) return false;
	       HashMap<Integer, ArrayList<Integer>> hr= new HashMap<Integer, ArrayList<Integer>>();
	       this.findIndex(s, dict, hr);
	       System.out.println("hello");
	       
	       return this.test(0, hr, s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="abcab";
		System.out.println(s.indexOf("ab",10));
		
//		s=  "letacodeleet";
		Set<String> dict = new HashSet();
//		dict.add("let");
//		dict.add("leta");
//		dict.add("code");
//		dict.add("le");
//		//dict.add("et");
//		dict.add("leet");	
		
		s = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		dict.add("b");
		dict.add("a");
		
		
		Solution s1 = new Solution();
		System.out.println(s1.wordBreak(s, dict));
		
		
	}

}
