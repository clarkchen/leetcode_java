package InvertBinaryTree;

/**
 * Created by chenxi on 15/6/30.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
        {
            return root;
        }
        if(root.left==null && root.right==null)
        {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
