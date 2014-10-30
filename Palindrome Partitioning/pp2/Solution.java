package pp2;


import java.util.*;
/**
 * @author chenxi
 * 参考文章：
 * http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning-ii.html
 * 这道题确实太精致了，我的小脑袋，一个多小时没想出来
 * 首先回文判断的动态规划的填充方法，自底向上填充这是非常自然的一个过程，从后向前扩张
 * 然后就题目而言，最小割的思路是这样的，遍历到i
 * 一旦形成了 S[i,j] 为回文，那么看一下 D[i] 小还是 从 D[j+1] 那里割一下之后小，当然遍历i的时候可能产生多个回文，这时候就是动态规划的判断了
 * 
 * 这道题目最主要的还是要能 最长回文子串的动态规划的解法，难点有两个，这是第一个，另外一个是答案的状态表示和转移，太神奇了
 * 
 * 
 */
public class Solution {
	int min(int a,int b)
	{
		return a>b?b:a;
	}
	public int minCut(String s) {
		 int len = s.length();  
		    int D[]=new int [len+1];  
		    boolean [][]P=new boolean [len][len];  
  
		    D[len] = 0;
		    for(int i = 0; i < len; i++)  
		    for(int j = 0; j < len; j++)  
		    P[i][j] = false;  
		    for(int i = len-1; i >= 0; i--){  
		         D[i] =D[i+1]+1;
		         for(int j = i; j < len; j++){  
		              if(s.charAt(i) == s.charAt(j) && (j-i<2 || P[i+1][j-1])){  
		                   P[i][j] = true;  
		                   D[i] = min(D[i],D[j+1]+1);  
		              }  
		         }  
		    }  
		    return D[0]-1;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "aaba";
		temp ="abaefghaba";
		temp ="a";
		//temp = "cbbbcc";
		temp="apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
// 		temp="abbbbbc";
// 		temp = "cbbbcc";
// 		temp = "caba";
		Solution s = new Solution();
		System.out.println(s.minCut(temp));
		 
	}

}
