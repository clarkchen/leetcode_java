package SN2;

//negtive values
public class Solution {
    public int singleNumber(int[] A) {
       if(A.length==1) return A[0];
       int count[] = new int[32];
       int i;
       
       for( i = 0;i<A.length;i++)
       {
    	   int j =0;
    	   int temp = A[i];
    	   while(j<32)
    	   {
    		   if((temp>>j & 1)==1)
    			   count[j] = (count[j]+1)%3 ;
    		   j++;
    	   }
       }
       int rt = 0;
       
       for( i = 0 ;i< 31;i++)
       {
    	   	if(count[i]>0)
    	   		rt = rt + count[i] * (1<<i);
       }
       if(count[i]==1) return rt- Integer.MAX_VALUE-1;
       return rt;
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{3,3,2,4,4,2,10000,4,3,2};
		a = new int []{-2,-2,1,1,-3,1,-3,-3,-4,-2};
		Solution s= new Solution();
		System.out.println(s.singleNumber(a));
		
		
	}

}
