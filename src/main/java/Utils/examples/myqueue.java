package Utils.examples;
import java.util.Queue;
import java.util.LinkedList;;
public class myqueue {
	public void test()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);q.offer(2);q.offer(3);
		System.out.println(q.contains(2));
		while(!q.isEmpty())
		{
			System.out.println(q.poll());
		}
		
		
	}
	public static void main(String[] args)
	{
		myqueue mq =new myqueue();
		mq.test();
	}
}
