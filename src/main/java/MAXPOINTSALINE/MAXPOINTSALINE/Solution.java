package MAXPOINTSALINE.MAXPOINTSALINE;

import java.util.HashMap;
import java.util.Iterator;


public class Solution {
	
	private HashMap<Point,Integer> getPointValue(Point[] points)
	{
		//To reduce the same point
		HashMap<Point,Integer> pointValue = new HashMap<Point,Integer> ();
        for(int i=0;i<points.length;i++)
        {	
        	Point p = points[i];
        	
        	Integer v = 0;
        	if (pointValue.containsKey(p)) v =pointValue.get(p);
        	
        	pointValue.put(p, v+1);
        	
        }
        return pointValue;
		
	}
	
	
    public int maxPoints(Point[] points) {
    	if (points.length==0) return 0;
    	
    	//create lines
    	HashMap<Point,Integer> pointValue = getPointValue(points);
    	Object[] np = pointValue.keySet().toArray();
    	if (np.length==1) 
    	{	
    		return pointValue.get(np[0]);
    	}
    	
    	HashMap<Line,ResType>  lines = new HashMap<Line,ResType>();
    	for (int m=0;m<np.length-1;m++)
    		for(int n=m+1;n<np.length;n++)
	    	{
    			Point x = (Point) np[m];
    			Point y = (Point) np[n];
	    		Line l = new Line(x,y);
	    		if (lines.containsKey(l))
	    		{
	    			ResType res = (ResType)lines.get(l);
	    			res.addObject(x);
	    			res.addObject(y);
	    		}
	    		else 
	    		{
	    			ResType res = new ResType();
	    			res.addObject(x);
	    			res.addObject(y);
	    			lines.put(l,res);
	    		}
	    		
	    	}
	    
    	//count lines 
    	Iterator<ResType> t  = lines.values().iterator();
    	Integer Max = Integer.MIN_VALUE;
    	while(t.hasNext())
    	{
    		ResType res = t.next();
    		Integer count = res.getValue(pointValue);
    		if (count >Max)
    		{
    			Max = count;
    		}
    	}
    	
    	
    	return Max;
    }
    public static void main(String [] args)
    {
    	Point[] p = { new Point(5,4)};
    	Point[] p2 = {new Point(0,-12),
    			new Point(5,2),
    			new Point(2,5),new Point(0,-5),new Point(1,5),new Point(2,-2),new Point(5,-4),new Point(3,4),new Point(-2,4),new Point(-1,4),new Point(0,-5),new Point(0,-8),new Point(-2,-1),new Point(0,-11),new Point(0,-9)
};
    	Solution s = new Solution();
    	
    	System.out.println(s.maxPoints(p2));
    	String res="";
    	
    	for(int i = 0 ;i< p2.length;i++)
    	{
    			res+= p2[i].y+"\n";    		
    	}
    	//System.out.println(res);
    }
}