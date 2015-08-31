package BinaryTreePaths;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxi on 15/8/31.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList();
        if(root==null) return ret;

        if(root.left==null && root.right==null)
        {

            ret.add(String.valueOf(root.val));
            return ret;
        }
        List<String> right = binaryTreePaths(root.right);
        if (right.size()>0) {
            for (String temp:right)
            {
                ret.add(String.valueOf(root.val)+"->"+temp);
            }
        }

        List<String> left = binaryTreePaths(root.left);
        if(left.size()>0)
        {

            for (String temp:left)
            {
                ret.add(String.valueOf(root.val)+"->"+temp);
            }
        }
        return ret;
    }
}