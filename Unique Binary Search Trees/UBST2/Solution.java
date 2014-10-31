/**
 * 
 */
package UBST2;

import java.util.*;

/**
 * @author chenxi
 *
 */
public class Solution {
	 public void AddTree(TreeNode root , int value)
	 {
		 AddTree(root, new TreeNode(value));
	 }
	 public void AddTree(TreeNode root , TreeNode v)
	 {
		 TreeNode temp =root;
		 while(temp!=null)
		 {
			 int value =  v.val;
			 if(temp.val<value && temp.right!=null) temp = temp.right;
			 else if(temp.val>value && temp.left!=null) temp= temp.left;
			 else if(temp.val<value){ temp.right = v;break;}
			 else if(temp.val>value){temp.left = v;break;}
			 else break;
		 }
	 }
	 public TreeNode copy(TreeNode root)
	 {
		 TreeNode rt = new TreeNode(root.val);
		 
		 Stack<TreeNode> s = new Stack<TreeNode>();
		 s.push(root);
		 Stack<TreeNode> s1 = new Stack<TreeNode>();
		
		 TreeNode copyNode=rt ,cur;
		 s1.push(copyNode);
		 while(!s.isEmpty())
		 {
			 cur = s.pop();
			 copyNode = s1.pop();
			 if(cur.right!=null){copyNode.right = new TreeNode(cur.right.val);s1.push(copyNode.right);s.push(cur.right);}
			 if(cur.left!=null) {copyNode.left = new TreeNode(cur.left.val);s1.push(copyNode.left);s.push(cur.left);}
		 }
		 
		 return rt;
	 }
	 
	public List<TreeNode> CreateTree(List<TreeNode> sample, int Margin)
	{
		List<TreeNode> rt = new ArrayList<TreeNode>();
		for(TreeNode root: sample)
		{
			 TreeNode rootNew= copy(root);
			 Stack<TreeNode> s = new Stack<TreeNode>();
			 s.push(rootNew);
			 TreeNode cur=rootNew;
			 while(!s.isEmpty())
			 {
				 cur = s.pop();cur.val+=Margin;
				 if(cur.right!=null) {s.push(cur.right);}
				 if(cur.left!=null) {s.push(cur.left);}
				 
			 }
			 rt.add(rootNew);
		}
		return rt;
	}
	class myele{
		ArrayList<TreeNode> value= new ArrayList<TreeNode>();
		public myele(int v)
		{
			value.add(new TreeNode(v));
		}
		public myele(){}
		public void add(TreeNode tn){value.add(tn);}
	}
	public List<TreeNode> generateTrees(int n) {
    	if(n<0) return null;
    	myele []Trees =new  myele[n+1];
   	 	if(n==0) {myele t= new myele();t.add(null);return t.value;}
    	Trees[1] = new myele(1);
    	if(n==1){return Trees[1].value;}
    	
		TreeNode root;
		for(int i=2;i<=n;i++)
		{
			Trees[i] = new myele();
			for(TreeNode node:Trees[i-1].value)
			{
				//其余的树作为右子树插入
				 root = new TreeNode(i);
				 root.left = copy(node);
				 Trees[i].add(root);
				  
				 {
					 //i为单节点插入到 i-1中
					 TreeNode temp =  copy(node);
					 AddTree(temp, i);
					 Trees[i].add(temp);
				 }
			}
		 
		  //i为父节点，j 到 i-1 作为子节点 插入到  j-1 对应的子树中去
		  for(int j=i-1;j>1;j--)
		  {
				for(TreeNode temp:Trees[j-1].value)
				{
					int Margin = j-1;
					for(TreeNode temp2:CreateTree(Trees[i-j].value, Margin))
					{
						 root = new TreeNode(i);
						 TreeNode temp3 = copy(temp);
						 AddTree(temp3, root);
						 root.left = temp2;
						 Trees[i].add(temp3);
					}
				}
		  	 }
			 
		 }
    	
    	return Trees[n].value;
    }
	public void preOrder(TreeNode root)
	{
		if(root==null) { return;}
		
		System.out.print(root.val);
		
		preOrder(root.left);
		
		preOrder(root.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s= new Solution();
		
		List<TreeNode>l = s.generateTrees(4);
		for(TreeNode t :l)
		{
			s.preOrder(t);
			System.out.println();
		}
				
		System.out.println(l.size());
	}

}
