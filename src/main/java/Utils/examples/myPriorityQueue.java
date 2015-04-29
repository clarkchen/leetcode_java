package Utils.examples;

import java.util.PriorityQueue;
import java.util.Comparator;

public class myPriorityQueue {

	
	public static void main(String[] args)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11,
				new Comparator<Integer>() {
			public int compare(Integer h1,Integer h2)
			{
				return h1-h2;
			}
		});
		pq.offer(3);pq.offer(2);pq.offer(1);
		
		while (!pq.isEmpty())
		{
			System.out.println(pq.poll());
		}
	}

}
