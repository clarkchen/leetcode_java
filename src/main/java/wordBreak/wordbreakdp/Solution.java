package wordBreak.wordbreakdp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Solution {
	
	
	public boolean wordBreak(String s, Set<String> dict) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="abc";
		System.out.println(s.indexOf("ab",10));
		System.out.println(s.substring(1, 3));
		s=  "letacodeleet";
		Set<String> dict = new HashSet();
		dict.add("let");
		//dict.add("leta");
		dict.add("code");
		dict.add("le");
		//dict.add("et");
		dict.add("leet");	
		
	
		
		
		Solution s1 = new Solution();
		System.out.println(s1.wordBreak(s, dict));
		
		
	}

}
