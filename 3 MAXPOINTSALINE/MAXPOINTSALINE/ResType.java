package MAXPOINTSALINE;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ResType
	{
		Set<Point> P;
		
		public ResType() {
			// TODO Auto-generated constructor stub
			P = new HashSet<Point>();
		}
		public void addObject(Point newP)
		{
			P.add(newP);
		}
		public Integer getValue(HashMap<Point,Integer> pointValue)
		{
			Integer count = 0;
			Iterator<Point> t= P.iterator();
			while (t.hasNext())
			{
				Point temp = t.next();
				count += pointValue.get(temp);
				
			}
			return count;
			
		}
	}