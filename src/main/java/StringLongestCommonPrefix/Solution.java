package StringLongestCommonPrefix; /**
 * 
 */

/**
 * @author chenxi
 * 这道题，我觉的就是 拿第一个作为前缀串，不断缩减就行
 * N*L 的复杂度
 */
public class Solution {
	int commontLen(String s1, String s2)
	{
		int i=0;
		if(s1==null||s2==null) return i;
		while(i<s1.length()&&i<s2.length()&& s1.charAt(i)==s2.charAt(i))i++;
		return i;
	}
	public String longestCommonPrefix(String[] strs) {
		if(strs==null) return null;
		if(strs.length==0) return "";
		if(strs.length==1) return strs[0];
		String lcp = strs[0];
		for(int i=1;i<strs.length;i++)
		{
			int end = commontLen(lcp, strs[i]);
			lcp = lcp.substring(0, end);
			if(lcp.length()==0) break;
		}
				
		return lcp;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String [] ss = new String[]{"a","b","c"};
		System.out.println(s.longestCommonPrefix(ss));
	}

}
