package CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null)return null;
		UndirectedGraphNode root =  new UndirectedGraphNode(node.label),cur,temp;
		
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		HashMap<Integer, UndirectedGraphNode> hm = new HashMap<Integer, UndirectedGraphNode>();
		hm.put(root.label, root);
		q.offer(node);
		UndirectedGraphNode n;
		while(!q.isEmpty())
		{
			cur = q.poll();
			for(int i = 0;i<cur.neighbors.size();i++)
			{
				n = cur.neighbors.get(i);
				if(hm.containsKey(n.label))
				{
					temp = hm.get(n.label);
				}
				else 
				{
					temp  = new UndirectedGraphNode(n.label);
					hm.put(temp.label, temp);
					q.offer(n);
				}
				hm.get(cur.label).neighbors.add(temp);
			}
		}
		return root;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode g0 =  new UndirectedGraphNode(0);
		UndirectedGraphNode g2 =  new UndirectedGraphNode(2);
		UndirectedGraphNode g1 =  new UndirectedGraphNode(1);
		g0.neighbors.add(g1);g0.neighbors.add(g2);
		g1.neighbors.add(g2);g2.neighbors.add(g2);
		Solution s = new Solution();
		UndirectedGraphNode g = s.cloneGraph(g0);
		System.out.println(g.label);
	}

}
