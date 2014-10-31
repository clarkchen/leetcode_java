/**
 * 
 */
package cs;

/**
 * @author chenxi
 *
 */
public class Solution {
	public long climbStairs(int n) {
		if(n<0) return 0;
		if(n<2) return 1;
		long []dp = new long[n+1];
		dp[0] =1; dp[1] =1;
		for(int i=2;i<=n;i++)
			dp[i] = dp[i-1]+dp[i-2];
		
		return dp[n];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =  new Solution();
		
		System.out.println(s.climbStairs(100));
		
		
	}

}
