package pp2;


import java.util.*;

/**
 * @author chenxi
 * 这种方式首先答案是错误的，但是思路是正确的，是一种贪心算法的思路
 * 不过也正应了那句老话，贪心算法只能达到局部最优，无法实现全局的最优
 * 
 * 思路：每次查找字符串的最长回文子串进行切割，剩下的左右两边的子串再进行切割
 * 这个想法当时提出来的时候，最大的疑问就是能否证明这是最优的方法，其实这是典型的贪心也就说明了，并不是全局最优
 * 下手之前就应该想清楚的
 * 
 */
public class SolutionGreedy {
	//get longest palindrome
	String preProcess(String s)
	{
		String rt ="^";
		for(int i=0;i<s.length();i++)
		{
			rt+="#"+s.charAt(i);
		}
		rt+="#!";
		return rt;
	}
	//[max,maxLen]
	class Value{
		int max;int maxLen;
	}
	public ArrayList<Value> getLPS(String s)
	{	 
		String t = preProcess(s);
		int P[] =  new int[t.length()];
		P[0] = 0;
		int C=0,R =0;
		int maxLen =0;
		for(int i=1;i<t.length()-1;i++)
		{
			if(R>i){
				int j = 2*C-i;
				P[i] =  P[j] > R-i? R-i:P[j];
			}
			else P[i] =0;
		 
			while(t.charAt(i+P[i]+1)==t.charAt(i-P[i]-1)) P[i]++;
		 
		 
			if(i+P[i]>R)
			{
				C = i;
				R = i+ P[i];
			}
			
			if(P[i]>maxLen){
				maxLen = P[i];
			}
		}
 		ArrayList<Value> rt = new ArrayList<Value>();
		for(int i=1;i<t.length()-1;i++)
		{
			if(P[i]==maxLen){
			   Value temp = new Value();
			   temp.maxLen = maxLen;
			   temp.max = (i - maxLen-1)/2;
			   rt.add(temp);
			}
		}
		 
	 
		return rt;
	}
	int answer(String s)
	{
		ArrayList<Value> lps = getLPS(s);
		int min = Integer.MAX_VALUE;
		Value m=lps.get(0);
		int rt=0;
		int max= m.max,maxLen =m.maxLen;
		String s1 = s.substring(0,max);
		if(s1.length()>0) rt+= 1+ answer(s1);
		String s2 = s.substring(max+maxLen);
		if(s2.length()>0) rt+=1+ answer(s2);
		if(rt<min) min = rt;
		
		return min;
	}
	public int minCut(String s) {
 		if(s==null||s.length()==1) return 0;
 		String b="";
		for(int i=0;i<s.length();i++) b+=s.charAt(s.length()-i-1);
		return answer(b);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionGreedy ps = new SolutionGreedy();
		String a="abceababfgcba";
		a="abacdfgdcaba";
		a="cbacadb";
		//ps.getLPS(a);
//		a="bbbb";
//		a="apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
 		//a="abadfcbczxdfde";
		
		System.out.println(ps.minCut(a));

		
	}

}
