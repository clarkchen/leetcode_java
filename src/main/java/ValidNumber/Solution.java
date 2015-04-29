package ValidNumber;

public class Solution {
	boolean isNumber(char c)
	{
		return c-'0'<=9 && c-'0'>=0;
	 
	}
	boolean isSymbole(char c)
	{
		return c=='-'||c=='+';
	}
	public boolean isNumber(String s) {
		if(s==null) return false;
		s= s.trim();
		if(s.length()==0) return false;
		int i=0;
		boolean eApear=false; 
		boolean dotApear=false; 
		int fu=0;
		int start = i;
		while(i<s.length())
		{
			if(isNumber(s.charAt(i))){i++;}
			else if(!dotApear&&!eApear && s.charAt(i)=='.'){
				dotApear=true;
				if(i>start&&isSymbole(s.charAt(i-1)))
				{
					if(i==s.length()-1 || !(isNumber(s.charAt(i+1))) ) return false;
				}
				char b = i<s.length()-1?s.charAt(i+1):s.charAt(i);
				char f = i>start?s.charAt(i-1):s.charAt(start);
				if(!isNumber(b)&&!isNumber(f)) return false;
			 	i++;
			}
			else if(!eApear && s.charAt(i)=='e'){
				eApear=true;
				
				char f = i<s.length()-1?s.charAt(i+1):s.charAt(i);
				char b = i>start?s.charAt(i-1):s.charAt(start);
				 
				if(!(b=='.')&&!isNumber(b)) return false;
				if(!(isSymbole(f))&&!isNumber(f)) return false;
				
				i++;
			}
			else if(fu<2 && isSymbole(s.charAt(i))) {
				
				//before
				if(!(i==start)&&!(s.charAt(i-1)=='e')) return false;
				//after
				char f = i<s.length()-1?s.charAt(i+1):s.charAt(i);
				if(!(f=='.')&&!(isNumber(f))) return false;
				i++;
				fu++;
			}
			else return false;
			 
		}
		return true;
 	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =  new Solution();
		System.out.println(Double.valueOf("1.e2"));

		System.out.println(s.isNumber(" 005047e+6 "));
	}

}
