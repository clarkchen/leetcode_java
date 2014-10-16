package wordbreak2;

import java.util.*;
public class Solution {
	public boolean wordBreakTest(String s, Set<String> dict) {
		Boolean dp[] = new Boolean[s.length()];
		
		for(int i=0;i<s.length();i++)
		{
			dp[i] = false;
			Iterator<String>  it=  dict.iterator();
			while(it.hasNext())
			{
				String d =it.next();
				int m = i-d.length()+1;
				if(m<0) continue;
				String temp = s.substring(m,i+1);
				if(temp.equals(d) &&(m==0|| dp[m-1]==true))
				{
					dp[i]  =true;break;
				}
				
			}
		}
		return dp[s.length()-1];
	}
	Boolean isStart(String s, String t)
	{
		if(s==null) return false;
		return s.indexOf(t) ==0;
	}
	public List<String> getWords(String s, Set<String> dict)
	{
		if(s==null||s.equals("")) return null;
		List<String> rt = new ArrayList<String>();
		Iterator<String> it  = dict.iterator();
		while(it.hasNext())
		{
			String d = it.next();
			if(isStart(s, d))
			{
				List<String> after = getWords(s.substring(d.length()), dict);
				if(after==null) {
					rt.add(d);
				}
				else if(after.size()>0){
					for( int j = 0;j<after.size();j++)
					{
						rt.add( d+" "+ after.get(j));
					}
				}
			
			}
		}
		
		return rt;
	}
	
	public List<String> wordBreak(String s, Set<String> dict) {
		if(s==null || s.length()==0) 
			return new ArrayList<String>();
		if(!wordBreakTest(s,dict))return new ArrayList<String>();
		return this.getWords(s, dict);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		HashSet<String> dict = new HashSet();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		Solution s1  =new Solution();
		System.out.print(s1.wordBreak(s, dict));
	}

}
