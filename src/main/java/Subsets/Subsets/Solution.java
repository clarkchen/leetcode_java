/**
 * 
 */
package Subsets.Subsets;
import java.util.*;

 
 /**
 * @author chenxi
 *
 */
public class Solution {
	class myvalue{
		List<List<Integer>> arrays = new ArrayList<List<Integer>>();
	}
	public List<List<Integer>> subsets(int[] S) {
		
		if(S==null) return new ArrayList<List<Integer>>();
		int len = S.length;
		int total = 1<<len;
		Arrays.sort(S);
		List<List<Integer>> rt =  new ArrayList<List<Integer>>(total);
		HashMap<Integer, myvalue> hm =  new HashMap<Integer, Solution.myvalue>();
		for(int i=0;i<total;i++)
		{
			List<Integer> temp =  new ArrayList<Integer>();
			int t =i;
			int j=0;
			int ones =0;
			while(j<len)
			{
				if((t&1)>0)
				{
					temp.add(S[j]); ones++;
				}
				j++;
				t = t>>1;
			}
			myvalue m = hm.get(ones);
			if(m==null)
			{
				m = new myvalue();
				m.arrays.add(temp);
				hm.put(ones, m);
			}
			else hm.get(ones).arrays.add(temp);
		}
		for(int i=0;i<=len;i++)
		{
			for(List<Integer> l: hm.get(i).arrays)
				rt.add(l);
		}
		return rt;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []s= {0};
		Solution ss= new Solution();
		int i=0;
		for(List<Integer> l: ss.subsets(s))
		{
			i++;
			System.out.println(l);
		}
		System.out.println(i);
	}

}
