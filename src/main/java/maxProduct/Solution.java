package  maxProduct;
public class Solution {
	int findMax(int []B)
	{
		int max = B[0];
		for(int i=1;i<B.length;i++)
		{
			if(max< B[i]) max = B[i];
		}
		return max;
	}
	
	public int maxProduct(int[] A) {
		int max[] = new int[A.length];
		int min[] =  new int [A.length];
		max[0] = A[0];
		min[0] = A[0]; 
 		for(int i=1;i<A.length;i++)
		{
			max[i] = A[i];
			min[i] = A[i];
			int v;
			
			//和上部分比较
			if(max[i-1] != Integer.MIN_VALUE)
			{
				v = max[i-1];
				if(max[i]<A[i]*v) max[i] = A[i]*v;
				if(min[i]>A[i]*v) min[i] = A[i]*v;
			}
			
			v = A[i-1];
			if(max[i]<A[i]*v) max[i] = A[i]*v;
			if(min[i]>A[i]*v) min[i] = A[i]*v;
		
			//和下面的部分比较
			{
				v = min[i-1];
				if(max[i]<A[i]*v) max[i] = A[i]*v;
				if(min[i]>A[i]*v) min[i] = A[i]*v;
			}
			
			//如果所有带有元素i的操作的最大值仍然比前面的值下的话，直接设置为中断
			if(max[i]<max[i-1] && max[i]<0){
				max[i] = Integer.MIN_VALUE;
			}

		}
 		
 		//防止出现多个0截断的情况
		return findMax(max);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=  new Solution();
		int [] a= new int[]{1,2,1,-1,-2,-3,-4};
		a = new int[]{0,1,2,3,4,0,3,2};
//		a = new int[]{0,1};
//		a =new int[]{4,5,1,10,11};
//		a =new  int[]{-1,-1};
//		a= new int []{-2,3,-4};
//		a=new int[]{1,-2,4,-2,-9,3};
//		a= new int []{3,-1,4};
//		a= new int []{0,-1,-2};
//		a = new int[]{7,-2,-4};
		//a= new int[]{2,-5,-2,-4,3};
		System.out.println(s.maxProduct(a));
	}

}
