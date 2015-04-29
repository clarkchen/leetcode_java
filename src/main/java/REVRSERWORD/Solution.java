package REVRSERWORD;

public class Solution {
    public String reverseWords(String s) {
    	if( s.length()==0 || s.split(" ").length == 0){return "";}
        String [] temp = s.split(" ");
        String res = "";
        int L = temp.length;
        int i=L-1;
        for (;i>=0;i--)
        {
        	if (temp[i].length()>0)
        	{
        		res += temp[i]+" ";
        	}
        }
        res = res.substring(0, res.length()-1);
        return res;
        
    }
    
    public static void main(String[] args)
    {
    	Solution S = new Solution();
    	System.out.println(S.reverseWords("123 adf"));
    	
    }
    
    
}