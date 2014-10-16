package BinaryTreePostTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			
			List<Integer> res =  new ArrayList<Integer>();
			if (root==null) return res;
			TreeNode pre = null;
			TreeNode cur = root;
			Stack<TreeNode> s =  new Stack<TreeNode>();
			s.push(root);
			while (!s.isEmpty())
			{
				cur = s.pop();
				if((cur.right==null&& cur.left==null) || (pre!=null && (pre==cur.left||pre==cur.right)))
				{
					res.add(cur.val);
					pre = cur;
				}else 
				{
					s.push(cur);
					if(cur.right!=null) s.push(cur.right);
					if(cur.left!=null) s.push(cur.left);	
				}
			}			
			return res;	
	}
	public List<Integer> preorderTraversal(TreeNode root) 
	{
		List<Integer> res =  new ArrayList<Integer>();
		if (root ==null) return res;
		Stack<TreeNode> s =  new Stack<TreeNode>();
		s.push(root);
		TreeNode cur;
		while (!s.isEmpty())
		{
			cur = s.pop();
			res.add(cur.val);
			if(cur.right!=null)s.push(cur.right);
			if(cur.left!=null) s.push(cur.left);
		}
		return res;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root  = new TreeNode (1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		Solution s = new Solution();
		List<Integer> res = s.preorderTraversal(root);
		System.out.println(res);
	}

}
