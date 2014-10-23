package permu2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	class Node
	{
		int index,value;
		HashMap<Integer, Node> sons;
		public Node(int i, int v)
		{
			index = i;value = v;
			sons = new HashMap<Integer, Solution.Node>();
		}
		public Node gesSon(int i, int v)
		{
			
			if(sons.containsKey(v))
			{
				return sons.get(v);
			}
			Node  son =  new Node(i,v);
			sons.put(v, son);
			return son;
		}
		Node addson(int i, int v)
		{
			Node rt =  new Node(i, v);
			sons.put(v, rt);
			return rt;
		}
		public boolean needTogo(int i, int v)
		{
			if(!sons.containsKey(v)) return true;
			Node temp = sons.get(v);
			return temp.index==i;
		}
	}
 
	//we assume that there is no duplicates
	public List<List<Integer>> permuteUnique(int[] num) {
			List<List<Integer>> rt = new ArrayList<List<Integer>>();
			if(num.length<1) return rt;
			ArrayList<Integer> res =  new ArrayList<Integer>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			Node empty = new Node(0, 0);
			for(int i:num) res.add(i);
			temp.clear();
			
			fullfill(rt, temp, res, empty);
			return rt;
	    }
		void fullfill(List<List<Integer>> rt, ArrayList<Integer> temp, ArrayList<Integer> res,Node cur)
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
				int value = res.get(i);
				if(!cur.needTogo(i, value)) continue;
				temp.add(value);
				res.remove(i);
				fullfill(rt, temp, res, cur.gesSon(i, value));
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
			int []num = new int[]{1,1,2,3,3};
			Solution s=  new Solution();
			s.print(s.permuteUnique(num));
			
			
			
		}
 

}
