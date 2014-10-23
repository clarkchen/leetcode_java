package np;

import java.util.ArrayList;

public class Solution {
	int jiecheng(int n)
	{
		if(n==1||n==0) return 1;
		return n*jiecheng(n-1);
	}
	int find(int k, ArrayList<Integer> res)
	{
		int n = res.size();
		int j=1;
		while(j<n)
		{
			if(k<= j* jiecheng(n-1)) return j;
			j++;
		}
		return j;
	}
	public String getPermutation(int n, int k) {
		if(k<1) return "";
		ArrayList<Integer> res = new ArrayList<Integer>();
		String rt = "";
		for(int i=1;i<=n;i++) res.add(i);
		
		while(!res.isEmpty() && k!=0)
		{
			int j = find(k,res);
			rt+= String.valueOf(res.get(j-1));
			k = k - (j-1)* jiecheng(res.size()-1);
			res.remove(j-1);
		}
		if(res.size()>0 && k==0)
		{
			for(int i=0;i<res.size();i++) rt+= String.valueOf(res.get(i));
		}
		
		return rt;
    }
	public static void  main(String []args)
	{
		Solution s= new Solution();
		String rt = s.getPermutation(9,362882);
		System.out.println(rt);
	}
}
