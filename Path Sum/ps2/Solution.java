package ps2;
import ps1.TreeNode;


import java.util.*;


public class Solution {
	
	boolean isLeaf(TreeNode tr)
	{
		return tr.right==null && tr.left==null;
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		
		if(root==null) return new ArrayList<List<Integer>>();
		if(isLeaf(root) && root.val!=sum)return new ArrayList<List<Integer>>();
		
		List<List<Integer>> rtPathSet =new ArrayList<List<Integer>>();
		
		if(isLeaf(root) && root.val == sum)
		{
			List<Integer> rtPath =new ArrayList<Integer>();
			rtPath.add(root.val);
			rtPathSet.add(rtPath);
			return rtPathSet;
		}
		
		List<List<Integer>> lS;
		lS =  pathSum(root.left, sum-root.val);
		if(lS.size()>0)
		{
			for(List<Integer> l:lS)
			{
				l.add(0, root.val);
				rtPathSet.add(l);
			}
		}
		List<List<Integer>> rS=pathSum(root.right, sum-root.val);
		if(rS.size()>0)
		{
			for(List<Integer>l:rS)
			{
				l.add(0,root.val);
				rtPathSet.add(l);
			}
		}
		return rtPathSet;
		
		
	        
    }
	public TreeNode test()
	{
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left =new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);

		root.right.right.right = new TreeNode(1);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =new Solution();
		List<List<Integer>> rt = s.pathSum(s.test(), 22);
		for(List<Integer> l:rt)
		{
			System.out.println(l);
		}
	}

}
