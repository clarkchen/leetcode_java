package ZigZagConversion; /**
 * 
 */

/**
 * @author chenxi
 * 这道题目，还是检测，能否找到所有的特殊情况，以及为什么要加入中间值的东西
 */
public class Solution {
	public String convert(String s, int nRows) {
		if(s==null) return s;
		if(s.length()==1) return s;
		String rt = "";
		int step = 2*nRows-2;
		if(step==0)step=1;
		for(int i=0;i<nRows;i++)
		{
			for(int j=i;j<s.length();j+=step)
			{
				rt+=s.charAt(j);
				if(i>0&&i<nRows-1&&(nRows>2))
				{	
					int a =  (j/step)*step;
					int k = a+step-(j-a);
					if(k<s.length())
						rt+=s.charAt(k);
				}
			}
		}
		return rt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String t= "PAYPALISHIRING";
		System.out.println(s.convert(t, 3));
	}

}
