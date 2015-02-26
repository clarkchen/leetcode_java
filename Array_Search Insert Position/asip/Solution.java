package asip;

public class Solution {
	 
    public int searchInsert(int[] A, int target) {
    	
       //边界条件判断
       if ( A.length==0 ) return 0;
       int end = A.length-1;
       int start = 0 ;
       if (A[start] >= target) return start;
       else if (A[end]< target ) return A.length;
       //二分查找
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
       return end+1;
       
    
    }

}
