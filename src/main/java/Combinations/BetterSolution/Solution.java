package Combinations.BetterSolution;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class Solution {
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
	
	public List<List<Integer>> combine(int n, int k){
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
		List<List<Integer>> L = s.combine(n, k);
		s.show(L);
	}

}
