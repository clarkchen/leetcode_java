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
	//升序排列
	public class IncreaseComparator implements Comparator<NodeValue> {
	    @Override
	    public int compare(NodeValue o1, NodeValue o2) {
	        return o1.v-o2.v;
	    }
	}
	
	//降序排列
	public class DecreaseComparator implements Comparator<NodeValue> {
	    @Override
	    public int compare(NodeValue o1, NodeValue o2) {
	        return o2.v-o1.v;
	    }
	}
	
	 
	public void test()
	{
		ArrayList<listsort.NodeValue> al = new ArrayList<listsort.NodeValue>();
		listsort.NodeValue n1=  new listsort.NodeValue(3, 4);
		listsort.NodeValue n2=  new listsort.NodeValue(1, 6);
		NodeValue n3 = new NodeValue(4,5);
		al.add(n1);al.add(n2);al.add(n3);
		System.out.println("原序列");
		for(NodeValue s:al)
			System.out.println(s.v+" "+s.index);
		
		System.out.println("上升序列");
		//increasing order
		Collections.sort(al, new IncreaseComparator());
		for(NodeValue s:al)
			System.out.println(s.v+" "+s.index);
		
		System.out.println("下降序列");
		//decreasing order
		Collections.sort(al, new DecreaseComparator());
		for(NodeValue s:al)
			System.out.println(s.v+" "+s.index);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listsort ls =new listsort();
		ls.test();
		
	}
}
