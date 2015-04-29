package  PalindromePartitioning.pp1;
import java.util.*;
/**
 * @author chenxi
 *
 *这道题发生的错误在于 第 29行的 cur.remove(cur.size()-1);
 *最开始写成了 cur.remove(sub),而实际上要表示的意思是从尾部去除掉, 这的确是非常大的毛病
 *另外这道题的测试用例， abaefghaba， 会有重复串产生，但是貌似是顺序来决定hash的所有即使集合相同但是顺序不同依然视为不同的结果
 */
public class Solution {
	
	boolean isPalidrom(String s)
	{
		if(s==null) return false;
		int i = 0 ;
		int j = s.length()-1;
		while(i<j && s.charAt(i)==s.charAt(j)){j--;i++;}
		return i>=j;
	}
	void getAnswer(String s, List<String> cur, List<List<String>>  All)
	{
		if(s.length()==0)
		{
			List<String> rt =  new ArrayList<String>();
			for(String c:cur) rt.add(c);
			All.add(rt);return;
		}
		for(int i=0;i<s.length();i++)
		{
			String sub = s.substring(0,i+1);
			if(!isPalidrom(sub)) continue;
			cur.add(sub);
			getAnswer(s.substring(i+1), cur, All);
			
			cur.remove(cur.size()-1);
		}
	}
	public List<List<String>> partition(String s) {
		if(s==null) return null;
		List<List<String>> All = new ArrayList<List<String>>();
		List<String> cur =  new ArrayList<String>();
		getAnswer(s, cur, All);
		return All;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "aaba";
		temp ="abaefghaba";
		temp ="a";
		temp = "cbbbcc";
		Solution s = new Solution();
		List<List<String>> t =s.partition(temp);
		for(List<String>l:t) System.out.println(l);
	}

}
