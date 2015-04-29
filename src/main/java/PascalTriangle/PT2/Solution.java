package PascalTriangle.PT2;
import java.util.ArrayList;
import java.util.List;

 public class Solution {
	public List<Long> getRow(int numRows) {
		if(numRows<0  ) return  new ArrayList<Long>();
		List<Long> rt = new ArrayList<Long>();
		rt.add((long)1);
		int row = numRows+1;
		for(int i=1;i<row;i++)
		{
			rt.add(rt.get(i-1)*(row-i)/i);
		}
		
		return rt;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s= new Solution();
		int a=5;
		System.out.println(s.getRow(3));
	}

}
