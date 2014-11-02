/**
 * 
 */
package st;
import java.util.*;
/**
 * @author chenxi
 * 非常恶心的题目，但是其实还没有我想象中的恶心，还好只是纯数字的转化
 * 考虑的难点就是正负号，还有越界的问题
 * 最大正数 比 最大 负数 对应的绝对值 少1 因为有 0 的存在
 */
public class Solution {
	boolean isNum(char c)
	{
		if(c-'0'>=0 && c-'9'<=0)
			return true;
		else return false;
	}
	
	public int atoi(String str) {
		if(str ==null) return 0;
		str = str.trim();
		if(str.length()==0) return 0;
		
		boolean neg = false;
		int i =0 ;
		if(str.charAt(i)=='-') {neg = true;i++;}
		else if(str.charAt(i)=='+') {neg = false;i++;}
		long res= 0;
		for(;i<str.length();i++)
		{
			if(isNum(str.charAt(i)))
			{
				res =10*res + (str.charAt(i)-'0');
				if(res>Integer.MAX_VALUE && neg) { res = Integer.MAX_VALUE+1;break; }
				else if(res>Integer.MAX_VALUE){ res = Integer.MAX_VALUE;break;}
			}
			else 
			{
				break;
			}
		}
		if(neg) res= -res;
		return (int)res;
		
		
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.atoi("    -2147483649"));
		
	}

}
