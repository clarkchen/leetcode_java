package ps1;

public class Solution {
	boolean isLeaf(TreeNode tr)
	{
		return tr.right==null && tr.left==null;
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		 if(root==null) return false;
		 if(isLeaf(root) && sum!=root.val) return false;
	     if(isLeaf(root) && sum==root.val) return true;
	     //if left is true the right will not be excuted
	     return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(-1);
		root.right = new TreeNode(-2);
		root.left = new TreeNode(-2);
		Solution s = new Solution();
		System.out.println(s.hasPathSum(root,-3));
		
	}

}
