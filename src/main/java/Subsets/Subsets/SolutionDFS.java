/**
 * 
 */
package Subsets.Subsets;
import java.util.*;

 
 /**
 * @author chenxi
 * 这种深度搜索的方式要更加的优美
 */
public class SolutionDFS {
	 
	void fullFill(int ones , int[] S, List<Integer>cur ,List<List<Integer>> rt,int start)
	{
		if(ones==0){
			List<Integer> temp = new ArrayList<Integer>();
			for(int i: cur) temp.add(i);
			rt.add(temp);return;
		}
		
		for(int i=start;i<S.length;i++)
		{
			cur.add(S[i]);  
			fullFill(ones-1, S, cur , rt,i+1);
			cur.remove(cur.size()-1);
		}
		 
	}
	public List<List<Integer>> subsets(int[] S) {
		
		if(S==null) return new ArrayList<List<Integer>>();
		int len = S.length;
	 
		Arrays.sort(S);
		List<List<Integer>> rt =  new ArrayList<List<Integer>>();
 		List<Integer> cur = new ArrayList<Integer>();
 		 
		
 		for(int i=0;i<=len;i++)
		{
 			fullFill(i, S, cur,  rt,0);
 		}
		return rt;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []s= {1,2,3};
		SolutionDFS ss= new SolutionDFS();
		int i=0;
		for(List<Integer> l: ss.subsets(s))
		{
			i++;
			System.out.println(l);
		}
		System.out.println(i);
	}

}
