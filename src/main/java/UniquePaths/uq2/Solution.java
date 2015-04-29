package UniquePaths.uq2;
public class Solution {
	public long uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(m<1||n<1) return 0;
		if(m==1 && n==1) return obstacleGrid[0][0]^1;
		long count[][] = new long[m+1][n+1];
		for(int i=0;i<=m;i++) count[i][0] = 0;
		for(int i=0;i<=n;i++) count[0][i] = 0;
		
		count[0][1] = 1;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(obstacleGrid[i-1][j-1]==1) count[i][j]=0;
				else count[i][j] =count[i-1][j]+ count[i][j-1];
			}
		}
		 
		return count[m][n];
    }
	 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int [][] result =  {{0,0,0},{0,1,0},{0,1,0}};
		result =new int[][] {{0}};
		System.out.println(s.uniquePathsWithObstacles(result));
	}

}