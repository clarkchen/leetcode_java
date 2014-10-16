package wordbreak2;
import java.util.*;
public class Solution2 {
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
	public List<String> wordBreak(String s, Set<String> dict) {
		if(s==null || s.length()==0 || !wordBreakTest(s,dict)) 
			return new ArrayList<String>();
		
		HashMap<Integer, ArrayList<String>> hr =new  HashMap<Integer, ArrayList<String>> ();
		
		for(int i= 0;i<s.length();i++)
		{
			ArrayList<String> cur = new ArrayList<String>();
			hr.put(i,cur );
			Iterator<String> it  = dict.iterator();
			while(it.hasNext())
			{
				String dj = it.next();
				int pre = i - dj.length()+1;
				if(pre <0) continue;
				String temp = s.substring(pre,i+1);
				if(temp.equals(dj))
				{
					if(pre==0)
					{
						cur.add(dj);
					}
					else{
						ArrayList<String> preA = hr.get(pre-1);
						if(preA.size()>0)
						{
							for(int j = 0;j<preA.size();j++)
							{
								cur.add(preA.get(j)+" "+dj);
							}
						}
					}
					
					 
					
				}
			}
		}
		return hr.get(s.length()-1);
			
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

