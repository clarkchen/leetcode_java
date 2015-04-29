package Combinations.Comb;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class Solution {
	List<Integer> getNonZeroIndex(BitSet s)
	{
		ArrayList<Integer> l =  new ArrayList<Integer>();
		for(int i=0;i<s.length();i++)
		{	
			if (s.get(i)) 	
			{
				l.add(i+1);
			}
		}
		return l;	
	}

	 List<BitSet> pickOneList(BitSet s)
	 {
		List<BitSet> l =  new ArrayList<BitSet>();
		for(int i=0;i<s.length();i++)
		{	
			if (s.get(i)) 
			{
				BitSet bs =  new BitSet(s.length());
				bs.set(i);
				l.add(bs);
			}

		}

		return l;	
	 }
	public List<List<Integer>> combine(int n, int k) {
	     if(n<k||k<0||n<1) return null;
	     List<List<Integer>> rtValue =  new ArrayList<List<Integer>>();;
	     if (n==1)
	     { 
	    	 List<Integer> l = new ArrayList<Integer>();
	    	 l.add(1);
	    	 rtValue.add(l);
	    	 return rtValue;
	     }	
	     BitSet sym = new BitSet(n);
	     sym.set(0, n);
	     List<BitSet>  res = C( sym,  k,n);
	     
	     for (int i=0;i<res.size();i++)
	     {
	    	 List<Integer> temp = getNonZeroIndex(res.get(i));
	    	 rtValue.add(temp);
	     }
	     
	     return rtValue;
	}
	
	List<BitSet> addParent(List<BitSet> L, Integer Parent, int len)
	{
		if (L.size()==0)
		{
			BitSet bs =  new BitSet(len);
			bs.set(Parent);
			L.add(bs);
		}
		else{
			for (int j = 0;j <L.size();j++)
			{
				BitSet temp = L.get(j);
				temp.set(Parent);
				L.set(j, temp);
			}
		}
		return L;
		
	}
	List<BitSet> C(BitSet sym,int k, int n)
	{
		if (k==1)
		{	
			return pickOneList(sym);
		}
		List<BitSet> rtValue =new ArrayList<BitSet>();
		if(k==0)
		{	
			return rtValue;
		}
		if(n==k)
		{
			rtValue.add((BitSet)sym.clone());
			return rtValue;
		}
		
		int i =sym.nextClearBit(0);
		
		sym.set(i, false);

		List<BitSet> L1 = C(sym,k-1,n-1);
		L1 = addParent(L1, i, n);
		rtValue.addAll(L1);
		
		List<BitSet>L2 = C(sym,k,n-1);
		rtValue.addAll(L2);
		sym.set(i);
		
		return rtValue;
	}
	
	void show(List<List<Integer>> L)
	{
		Iterator<List<Integer>> iter = L.iterator();
		while(iter.hasNext())
		{
			List<Integer> L1 =  iter.next();
			Iterator<Integer> iter1  = L1.iterator();
			while (iter1.hasNext())
			{
				System.out.print(iter1.next()+" ");
			}
			System.out.println(" ");
		}
		System.out.println(L.size());
	}
	
	public List<List<Integer>> combine2(int n, int k){
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    combine(n, k, 1, result, new ArrayList<Integer>());
	    return result;
	}

	public void combine(int n, int k , int start, List<List<Integer>> result, ArrayList<Integer> l){
	    if(k == 0){
	        result.add(l);
	        return;
	    }
	    for(int i = start; i <= n; ++i){
	        ArrayList<Integer> a = (ArrayList<Integer>) l.clone();
	        a.add(i);
	        combine(n, k - 1, i + 1, result, a);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s= new Solution();
		int n = 10;
		int k = 5;
		List<List<Integer>> L = s.combine2(n, k);
		s.show(L);
	}

}
