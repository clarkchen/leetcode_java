package MAXPOINTSALINE.MAXPOINTSALINE;

class Line
{
	//when the x is max_value, we compare by the value in x axis
	int X;
	double xl;
	double b;
	Line(Point x, Point y)
	{	
		xl = getXL(x, y);
		b= getB(x, y);
		X = x.x;
	}
	double getXL(Point a, Point b)
	{	
		if (a.x == b.x) return Double.MAX_VALUE;
		return (a.y-b.y)/ (1.0*(a.x-b.x));
		
	}
	double getB(Point a, Point b)
	{
		if (a.x == b.x) return Double.MAX_VALUE;
		return (a.y*b.x-b.y*a.x)/ (1.0*(a.x-b.x));
	}
	boolean isSame(Line l)
	{
		if (xl == Double.MAX_VALUE && l.xl==Double.MAX_VALUE)
		{
			return l.X == X; 
		}
		return l.xl == this.xl && l.b == this.b;
	}
	
	public boolean equals(Object obj) {
	    if (!(obj instanceof Line)) {
	        return false;
	    } else {
	    	Line that = (Line)obj;
	        return this.isSame(that);
	    }
	}
	public int hashCode() { 
	    int hash = 1;
	    hash = hash * 31 + (int)(this.xl*this.b);
	    hash = hash * 31 
	                + (int)(this.xl-this.b);
	    return hash;
	  }
	
}