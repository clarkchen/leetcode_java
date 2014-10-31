/**
 * 
 */
package UBST;

/**
 * @author chenxi
 *
 */
public class Solution {
	public int numTrees(int n) {
		 if(n<0) return 0;
		 int D[] = new int[n+1];
		 D[0] = 1;D[1] =1;
		 for(int i=2;i<=n;i++)
		 {
			 //其余的树作为右子树插入
			 D[i] = D[i-1];
			 //i为单节点插入到 i-1中
			 D[i] += D[i-1];
				
			 //i为父节点，j 到 i-1 作为子节点 插入到  j-1 对应的子树中去
			 for(int j=i-1;j>1;j--)
			 {
				D[i]+=D[j-1]*D[i-j];
		  	 }
			 
		 }
		 return D[n];
	   
	 }
	
	
	 public int numTreesCorrect(int n) {
		 if(n<0) return 0;
		 int D[] = new int[n+1];
		 D[0] = 1;D[1] =1;
		 for(int i=2;i<=n;i++)
		 {
			 D[i] = D[i-1];
			  
			 for(int j=i-1;j>=1;j--)
			 {
				 D[i]+=D[j]*D[i-1-j];
			 }
		 }
		 return D[n];
	   
	 }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.numTrees(10));
	}

}
