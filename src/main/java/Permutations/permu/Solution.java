package Permutations.permu;

import java.util.*;

public class Solution {
	//we assume that there is no duplicates
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> rt = new ArrayList<List<Integer>>();
		if(num.length<1) return rt;
		ArrayList<Integer> res =  new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i:num) res.add(i);
		temp.clear();
		
		fullfill(rt, temp, res);
		return rt;
    }
	void fullfill(List<List<Integer>> rt, ArrayList<Integer> temp, ArrayList<Integer> res)
	{
		if(res.size()==0)
		{
			ArrayList<Integer> rtA = new ArrayList<Integer>();
			for(Integer i:temp) rtA.add(i);
			rt.add(rtA);
			return ;
		}
		for(int i=0;i<res.size();i++)
		{
			temp.add(res.get(i));
			res.remove(i);
			fullfill(rt, temp, res);
			res.add(i, temp.get(temp.size()-1));
			temp.remove(temp.size()-1);
			
		}
	}
	public void print(List<List<Integer>> rt)
	{
		for(List<Integer> r:rt)
		{
			System.out.println(r);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num = new int[]{1,5,6,4};
		Solution s=  new Solution();
		s.print(s.permute(num));
		
		
		
	}

}
