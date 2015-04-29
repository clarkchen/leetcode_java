package Candy.candy;

public class Solution {
	public int candy(int[] ratings) {
        if(ratings ==null || ratings.length==0) return 0;
        if(ratings.length==1) return 1;
        int c[] = new int[ratings.length];
        int i;
        c[0]=1;
        for(i=1;i<c.length;i++)
        {
        	if(ratings[i]>ratings[i-1])
        		c[i] = c[i-1]+1;
        	else if(ratings[i]==ratings[i-1]) 
        		c[i] = 1;//regard as lower
        	else if(ratings[i]<ratings[i-1])
        		c[i] = 1;
        }
        
        for(i = c.length-2;i>=0;i--)
        {
        	if(ratings[i]>ratings[i+1] && c[i]<c[i+1]+1)
        	{
        		c[i] = c[i+1] +1;
        	}

        }
        
        int sum = 0;
        for(i=0;i<c.length;i++) sum+=c[i];
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = new int[]{1,10,4,3,2,1};
		a = new int[]{1,10,11,4,4,3};
		//a = new int[]{1,2,2};
		Solution s= new Solution();
		System.out.println(s.candy(a));
		;
	}

}
