package asip;

public class Solution {
	 
    public int searchInsert(int[] A, int target) {
       int end = A.length;
       if (end==0) return 0;
       int start = 0 ;
       if (A[start] >= target) return start;
       else if (A[end-1]< target ) return end;
       end = end-1;
       int mid = (end-start)/2;
       while ( end>=start)
       {
    	   if( A[mid] > target){
    		   end = mid-1;
    	   }
    	   else if( A[mid] < target){
    		   start = mid+1;
    	   }
    	   else if( A[mid] == target)
    	   {
    		   return mid;
    	   }
    	   mid = (end+start)/2;
       }
       if (A[end]>target) return end;
       
       return end+1;
       
    
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int []a = new int[] {1,3};
		int target = 3;
		System.out.println(s.searchInsert(a, target)); 
	}

}
