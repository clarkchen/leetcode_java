package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class listsort {

	class NodeValue
	{
		public int v,index;
		public NodeValue(int v,int index)
		{
			this.v = v;
			this.index= index;
		}
		
	}
	public class CustomComparator implements Comparator<NodeValue> {
	    @Override
	    public int compare(NodeValue o1, NodeValue o2) {
	        return o1.v-o2.v;
	    }
	}
	public void test()
	{
		ArrayList<listsort.NodeValue> al = new ArrayList<listsort.NodeValue>();
		listsort.NodeValue n1=  new listsort.NodeValue(3, 4);
		listsort.NodeValue n2=  new listsort.NodeValue(1, 6);
		NodeValue n3 = new NodeValue(4,5);
		al.add(n1);al.add(n2);al.add(n3);
		for(NodeValue s:al)
			System.out.println(s.v+" "+s.index);
		
		Collections.sort(al, new CustomComparator());
		for(NodeValue s:al)
			System.out.println(s.v+" "+s.index);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listsort ls =new listsort();
		ls.test();
		
	}
}
