/**
 * 
 */
package triangle;
import java.util.*;
/**
 * @author chenxi
 *
 */
public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
        int rt =0;
        if(triangle==null||triangle.size()==0) return rt;
        int h=triangle.size();
        int w = triangle.get(h-1).size();
        int count[][] = new int[h][w];
        for(int i=0;i<h;i++)
        	for(int j=0;j<w;j++)
        		count[i][j] = Integer.MAX_VALUE;
        
        
        for(int i=0;i<h;i++)
        {
        	for(int j=0;j<triangle.get(i).size();j++)
        	{
        		int pre =Integer.MAX_VALUE;
        		pre = i-1>=0&&count[i-1][j]<pre?count[i-1][j]:pre;
        		pre = i-1>=0&&j-1>=0&&count[i-1][j-1]<pre?count[i-1][j-1]:pre;
        		pre = pre==Integer.MAX_VALUE?0:pre;
        		
        		count[i][j] = pre+triangle.get(i).get(j);
        	}
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<w;i++)
        {
        	if(count[h-1][i]<min)
        		min = count[h-1][i];
        }
        return min;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=  new Solution();
		List<List<Integer>> l =new ArrayList<List<Integer>>();
		ArrayList<Integer> ln = new ArrayList<Integer>();
		ln.add(2);
		l.add(ln);
		ln = new ArrayList<Integer>();
		ln.add(3);ln.add(4);
		l.add(ln);
		ln = new ArrayList<Integer>();
		ln.add(-1);ln.add(1);ln.add(10);
		l.add(ln);
		System.out.println(s.minimumTotal(null));
	}

}
