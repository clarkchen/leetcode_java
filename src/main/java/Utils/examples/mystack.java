package Utils.examples;
import java.util.Stack;;
public class mystack {

	public void test()
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);s.push(2);s.push(3);
		while(!s.isEmpty())
		{
			System.out.println(s.pop());
		}
		
	}
	public static void main(String[] args)
	{
		mystack ms = new mystack();
		ms.test();
	}
}
