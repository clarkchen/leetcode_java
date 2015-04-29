package ValidPalindrome;

public class Solution {
	boolean valid(String s, int i)
	{
		char c = s.charAt(i);
		if(c>='0' && c<='9') return true;
		if(c>='a' && c<='z') return true;
		if(c>='A' && c<='Z'){return true;}
		return false;
	}
	
	public boolean isPalindrome(String s) {
		if(s==null) return false;
		s=s.trim();
		if(s.length()<=1) return true;
		s = s.toLowerCase();
		int i = 0;
		int j = s.length()-1;
		while(i<j)
		{
			while(!valid(s, i) &&i<j) i++;
			while(!valid(s, j)&& i<j) j--;
			if(i>=j) break;
			if(s.charAt(i)!=s.charAt(j)) return false;
			i++;j--;
		}
 		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =  new Solution();
		String st = "A man, a plan, a cana'''''l: Panama!!!+)(),,,,,,";
		st= "1a2;";
		System.out.println(s.isPalindrome(st));;
	}

}
