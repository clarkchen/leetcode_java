package EditDistance; /**
 * 
 */

/**
 * @author chenxi
 *
 */
public class Solution {

	boolean isempty(String s)
	{
		return s==null;
	}
	public int minDistance(String word1, String word2) {
		 if(isempty(word1) && isempty(word2)) return 0;
		 if(isempty(word2)) return word1.length();
		 if(isempty(word1)) return word2.length();
		 //all lager than 1
		 int len1 =word1.length(),len2=word2.length();
		 int dp[][] =  new int[len1+1][len2+1];
		 for(int i=0;i<=len1;i++) dp[i][0] = i;
		 for(int i=0;i<=len2;i++) dp[0][i] = i;
		 
		 int i,j;
		 for(i=1;i<=len1;i++)
		 {
			 for(j=1;j<=len2;j++)
			 {
				 if(word1.charAt(i-1)==word2.charAt(j-1))
				 {
					dp[i][j] = dp[i-1][j-1];
				 }
				 else 
				 {
					 int min = dp[i-1][j-1];
					 if(dp[i][j-1]<min) min = dp[i][j-1];
					 if(dp[i-1][j]<min) min = dp[i-1][j];
					 dp[i][j] = min+1;
				 }
				 
			 }
		 }
		 
		 return dp[len1][len2];
		 
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=  new Solution();
		String word1="a";
		String word2= "b";
		System.out.println(s.minDistance(word1, word2));
	}

}
