/**
 * 
 */
package RIA;
import java.util.*;
/**
 * @author chenxi
 * 这道题也是一道常见，面试题，IP地址转化
 * 我觉的用深度搜素加剪枝来做这道题目
 */
public class Solution {
	
	//两个连续的0不合法
	//01.02 不合法
	boolean validate(String s)
	{
		if(s.charAt(0)=='0' && s.length()>1) return false;
		if(Integer.valueOf(s)<=255) return true;
		return false;
	}
 	 
	void answer(String s, int n, String cur, List<String> res)
	{
		if(s.length()>n*3 || s.length()<n) return;
		if(n==0)
		{
			res.add(cur);
		}
		for(int i=0;i<3&&i<s.length();i++)
		{
			String temp =  s.substring(0,i+1);
			if(validate(temp))
			{
				if(n<4) temp ="."+temp;
				answer(s.substring(i+1), n-1, cur+temp, res);
			}
		}
	}
	public List<String> restoreIpAddresses(String s) {
		
		if(s==null) return null;
		List<String>  res= new ArrayList<String>();
		res.clear();
 		answer(s, 4, "", res);
		return res;
		
    }
	
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip="25525511135";
		Solution s = new Solution();
		
		List<String> rt =  s.restoreIpAddresses(ip);
		for(String s1:rt)
		{
			System.out.println(s1);
		}
		System.out.println(rt.size());
		 
	}

}
