package ValidParentheses.vpa; /**
 * 
 */

import java.util.*;
/**
 * @author chenxi
 * 非常经典的括号不断输入的匹配，用栈来实现
 */
public class Solution {
	
	boolean input(char c)
	{
		return c=='('||c=='{'||c=='[';
	}
	boolean validate(char a, char b)
	{
		if(a=='('&& b==')') return true;
		if(a=='['&& b==']') return true;
		if(a=='{'&& b=='}') return true;
		return false;
	}
	public boolean isValid(String s) {
		boolean rt = true;
		s=s.trim();
		if(s.length()<1) return !rt;
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			char c=  s.charAt(i);
			if(input(c)) st.push(c);
			else
			{
				 if(st.isEmpty() || !validate(st.pop(), c))
				 {
					 rt = false;
					 break;
				 }
			}
		}
		if(!st.isEmpty()) rt =false;
		return rt;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isValid("[[["));
		;
	}

}
