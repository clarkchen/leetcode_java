package MaximumSubarray; /**
 * 
 */

/**
 * @author chenxi
 *
 */
public class Solution {
	public int maxSubArray(int[] A) {
		if(A==null ) return 0;
        int sum [] = new int [A.length];
        sum[0] = A[0];
        int max = sum[0];
        for(int i=1;i<A.length;i++)
        {
        	sum[i] = sum[i-1]>0?sum[i-1]+A[i]:A[i];
        	max = sum[i]>max?sum[i]:max;
        }
        
        return max;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s= new Solution();
		int []A= {-1};
		System.out.println(s.maxSubArray(A));
	}

}
