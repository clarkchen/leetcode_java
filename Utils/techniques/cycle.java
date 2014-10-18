package techniques;

import java.util.ArrayList;

public class cycle {
	public static void main(String[]args)
	{
		int a[] = new int[]{3,2,5,2};
		for(int v :a)
		{
			System.out.println(v);
		}
		
		ArrayList<String> test= new ArrayList<String>();
		test.add("nice");test.add("hello");
		for(String v : test)
		{
			System.out.println(v);
		}
	}
}
