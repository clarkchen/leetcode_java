package StringMultiplyStrings.sms; /**
 * 
 */

/**
 * @author chenxi
 * 通过数组的方式来实现，假设输入是完全正确的
 */
public class Solution {
	//不考虑符号问题，全是正负号
	public String add(String num1, String num2)
	{
		int i=num1.length()-1;
		int j=num2.length()-1;
		int pre = 0;
		int i1,i2,i3;
		String res = "";
		for(;i>=0 && j>=0;i--,j--)
		{
			i1 = num1.charAt(i)-'0';
			i2 = num2.charAt(j)-'0';
			i3 =  pre+ i1+i2;
			res = (i3%10)+ res;
			pre = i3/10;
		}
		while(i>=0)
		{
			i1 = num1.charAt(i)-'0';
			i3 = i1+ pre;
			res = (i3%10)+ res;
			pre = i3/10;
			i--;
		}
		while(j>=0)
		{
			i2 = num2.charAt(j)-'0';
			i3 =i2+ pre;
			res = (i3%10)+res;
			pre = i3/10;
			i--;
		}
		if(pre>0) res= pre+res;
		return res;
	}
	boolean fuhao(char c)
	{
		return c=='-' || c=='+';
	}

	public String multiply(String num1, String num2) {
		boolean neg = false;
		char s1,s2;
		if(fuhao(num1.charAt(0)))
		{
			s1 =  num1.charAt(0);
			num1 = num1.substring(1);
			if (s1=='-') neg =!neg;
		}
		if(fuhao(num2.charAt(0)))
		{
			s2 = num2.charAt(0);
			num2 =  num2.substring(1);
			if(s2=='-') neg = !neg;
		}
		
		String res="0";
		int pre=0;
		for(int i =num1.length()-1;i>=0;i--)
		{
			String temp = "";
			pre = 0;
			int w = num1.length()-1-i;
			for(int j=num2.length()-1;j>=0;j--)
			{
				int i1 = num1.charAt(i)-'0';
				int i2 =num2.charAt(j)-'0';
				int i3 = i1*i2 + pre;
				temp =  (i3%10)+temp;
				pre = i3 /10;
			}
			if(pre>0) temp =pre+temp;
			while(w-->0) temp=temp+'0';
			res = add(temp, res);
		}
		
		//remove the zeros in the front
		int i=0;
		while(res.charAt(i)=='0'&&i<res.length()-1) i++;
		res =res.substring(i);
		
		res = neg? "-"+res:res;
		
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="-999";
		String s2="-0";
		Solution s= new Solution();
		
		System.out.println(s.multiply(s1, s2));
	}

}
