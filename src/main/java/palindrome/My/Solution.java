package palindrome.My;



public class Solution {
	int getLen(int x)
	{
		int i=0;
		while(x>0)
		{
			x= x/10;
			i++;
		}
		return i;
	}
	public boolean isPalindrome(int x) {
		if (x<0) return false;
        int len =  getLen(x);
        if (len==1) return true;
        int start =1;
        int end = len;
        while (start<end)
        {
        	if (start == end) return true;
        	int s = x%10;
        	int e = x/ (int)(Math.pow(10, end-start));
        	if(e!=s) return false;
        	x = x%( (int)(Math.pow(10, end-start)));
        	x = x/10;
        	start++;
        	end--;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=  new Solution();
		System.out.println(s.isPalindrome(575));
		System.out.println(s.isPalindrome(576));
		System.out.println(s.isPalindrome(5755));

		System.out.println(s.isPalindrome(55555));
		System.out.println(s.isPalindrome(55755));
		System.out.println(s.isPalindrome(-1));
		System.out.println(s.isPalindrome(1234321));

	}

}
