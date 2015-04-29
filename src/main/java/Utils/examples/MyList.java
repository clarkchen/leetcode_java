package Utils.examples;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class MyList {
	public void test()
	{
		List<String> l = new ArrayList<String>();
		ArrayList<Integer> il = new ArrayList<Integer>();
		int [] v = new int [] {5,3,1,2,6};
		for(int i=0;i<v.length;i++)
		{
			l.set(i, "Numer is "+v[i]);
			il.set(i, v[i]);
		}
		
		for(int i=0;i<l.size();i++)
		{
			System.out.println();
		}
		
	}
	void test2()
	{
		ArrayList<Integer> l1 = new ArrayList<Integer>();		
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		Random r= new Random();
		for (int i=0;i<10;i++)
		{
			l1.add(r.nextInt(10)+1);
			l2.add(r.nextInt(10)+1);
		}
		
		
	}
	//when the arraylist is integer, the remove by object should be declared as object
	void removeTest()
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);res.add(2);res.add(3);
		
		System.out.println(res);
		res.remove(2);//delete index 2
		System.out.println(res);
		res.remove(1);//delete index 2
		System.out.println(res);
		
		res.add(2);
		res.remove((Object)1);//remove the value 1 not index 1
		System.out.println(res);
		
	}
	//insert test, insert into position i , and the later elements are shifted to right;
	public void insertTest()
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);res.add(2);res.add(3);
		System.out.println(res);
		res.add(0, 4);
		System.out.println(res);
		res.remove(1);
		System.out.println(res);
		res.add(1, 1);
		System.out.println(res);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList d=  new MyList();
		d.insertTest();
	}
}
