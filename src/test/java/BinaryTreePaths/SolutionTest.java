package BinaryTreePaths;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/9/1.
 */
public class SolutionTest {

    @Test
    public void testBinaryTreePaths() throws Exception {
        {
            Solution s = new Solution();
              TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.right = new TreeNode(5);
            root.right = new TreeNode(3);
            List<String> ret = s.binaryTreePaths(root);
            assertTrue(ret.contains("1->2->5"));
            assertTrue(ret.contains("1->3"));
            assertTrue(ret.size() == 2);

        }
        {
            Solution s = new Solution();
            TreeNode root = new TreeNode(1);
            root.left =  new TreeNode(2);
            root.left.right = new TreeNode(5);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(5);
            List<String> ret = s.binaryTreePaths(root);
            for (String item:ret)
            {
                System.out.println(item);
            }
            assertTrue(ret.contains("1->2->5"));
            assertTrue(ret.size()==2);
        }
    }
}