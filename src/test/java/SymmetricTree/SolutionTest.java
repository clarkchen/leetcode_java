package SymmetricTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/5/11.
 */
public class SolutionTest {

    @Test
    public void testIsSymmetric() throws Exception {
        Solution s = new Solution();
        //System.out.println("not balanced");
        TreeNode tn = new TreeNode(1);
        assertTrue(s.isSymmetric(tn));
        tn.left = new TreeNode(2);
        assertTrue(!s.isSymmetric(tn));
        tn.right =new TreeNode((2));
        assertTrue(s.isSymmetric(tn));

        tn.left.left = new TreeNode(4);
        tn.right.left = new TreeNode(4);
        assertTrue(!s.isSymmetric(tn));

        tn.right.right =  new TreeNode(4);
        assertTrue(!s.isSymmetric(tn));
        tn.left.right =  new TreeNode(5);
        assertTrue(!s.isSymmetric(tn));

        tn.right.left=  new TreeNode(5);
        assertTrue(s.isSymmetric(tn));


    }
}