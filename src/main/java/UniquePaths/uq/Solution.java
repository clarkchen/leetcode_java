package UniquePaths.uq;
public class Solution {
	public long uniquePaths(int m, int n) {
		if(m<1||n<1) return 0;
		if(m==1 && n==1) return 1;
		long count[][] = new long[m+1][n+1];
		for(int i=0;i<=m;i++) count[i][0] = 0;
		for(int i=0;i<=n;i++) count[0][i] = 0;
		
		count[0][1] = 1;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				count[i][j] =count[i-1][j]+ count[i][j-1];
			}
		}
		
		return count[m][n];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int m=3,n=7;
		m=50;n=4;
		System.out.println(s.uniquePaths(m, n));
	}

}
