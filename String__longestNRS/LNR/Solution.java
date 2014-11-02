/**
 * 
 */
package LNR;
import java.util.*;
/**
 * @author chenxi
 * 最长不重复公共子串
 * 
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s==null ||s.length()==0) return 0;
		if( s.length()<2) return 1;
		int len[] = new int[s.length()];
		
		len[0] = 1;
		String s1,s2;
		int j;
		int max = 1;
		for(int i=1;i<s.length();i++)
		{
			s1 = s.substring(i-len[i-1],i);
			j = s1.lastIndexOf(s.charAt(i));
			if(j<0)
			{
				len[i] = len[i-1]+1;
			}
			else
			{
				len[i] = len[i-1] - j;
			}			
			if(len[i]>max) 
			{
				max = len[i];
			}
		}
		return max;
		
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring("bbb"));
		System.out.println(s.lengthOfLongestSubstring("abcabcbb"));

	}

}
