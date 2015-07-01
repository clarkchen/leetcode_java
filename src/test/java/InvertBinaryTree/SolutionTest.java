package InvertBinaryTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/6/30.
 */
public class SolutionTest {
    TreeNode root1;
    @Before
    public void setUp() throws Exception {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left =  new TreeNode(1);
        left.right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);
        this.root1 = root;

    }

    @Test
    public void testInvertTree() throws Exception {
        Solution s = new Solution();
        TreeNode root = s.invertTree(this.root1);
        TreeNode left = root.left;
        TreeNode right = root.right;
        assertEquals(left.val, 7);
        assertEquals(right.val, 2);
        assertEquals(left.left.val, 9);
        assertEquals(left.right.val, 6);
        assertEquals(right.left.val, 3);
        assertEquals(right.right.val, 1);
    }
}