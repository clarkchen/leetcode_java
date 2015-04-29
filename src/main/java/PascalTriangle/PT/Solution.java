package PascalTriangle.PT;
import java.util.*;
public class Solution {
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> rt = new ArrayList<List<Integer>>();
		if(numRows==0) return rt;
		ArrayList<Integer> n = new ArrayList<Integer>();
		n.add(1);rt.add(n);
		if(numRows==1) return rt;
		int v1,v2;
		for(int i=1;i<numRows;i++)
		{
			n = new ArrayList<Integer>();
			for(int j=0;j<=i;j++)
			{
				if(j==0) v2=0;
				else v2 = rt.get(i-1).get(j-1);
				if(j==i) v1=0;
				else v1 = rt.get(i-1).get(j);
				n.add(v1+v2);
			}
			rt.add(n);
		}
		
		return rt;
	}
	public void print(List<List<Integer>> rt)
	{
		for(List<Integer> l :rt)
		{
			System.out.println(l);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s= new Solution();
		int a=5;
		List<List<Integer>> rt = s.generate(a);
		s.print(rt);
	}

}
