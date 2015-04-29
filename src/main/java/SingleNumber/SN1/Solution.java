package SingleNumber.SN1;

public class Solution {
    public int singleNumber(int[] A) {
       if(A.length==1) return A[0];
    	int  rt = A[0];
    	for(int i=1;i<A.length;i++)
    	{
    		rt = rt ^ A[i];
    	}
    	return rt;
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{3,3,2,4,2,3,3};
		Solution s= new Solution();
		System.out.println(s.singleNumber(a));
		
		
	}

}
