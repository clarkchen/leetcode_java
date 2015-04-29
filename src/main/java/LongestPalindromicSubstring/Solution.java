package LongestPalindromicSubstring;

public class Solution {
	public String longestPalindrome(String s) {
		if(s==null || s.length()<2) return s;
		
		int max = 0,maxLen =Integer.MIN_VALUE;
		int f,b;
		int len;
		 
		for(int i=0;i<s.length();i++)
		{
			//odd
			f = i+1;
			b = i-1;
			while(b>=0 && f<s.length()&& s.charAt(f)==s.charAt(b)){f++;b--;};
			len = f-b-1;
			if(len>maxLen){max =b+1;maxLen = len; }
			
			//even
			b=i;f=i+1;
			while(b>=0 && f<s.length()&& s.charAt(f)==s.charAt(b)){f++;b--;};
			len = f-b-1;
			if(len>maxLen){max =b+1;maxLen = len;}
		}
		
		System.out.println(max+"  "+maxLen);
		return s.substring(max,max+maxLen);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=  new Solution();
		String a = "helooleh";
		a="abcddfgcba";
		a="abba";
		a="bb";
		System.out.println(s.longestPalindrome(a));
	}

}
