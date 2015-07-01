package RectangleArea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/7/1.
 */
public class SolutionTest {

    @Test
    public void testComputeArea() throws Exception {
        Solution s = new Solution();
        {
            assertEquals(s.computeArea(0,0,1,1,0,0,2,3),6);
        }
        {
            assertEquals(s.computeArea(-3,0,3,4,0,-1,9,2),45);
        }
        {
            assertEquals(s.computeArea(0,0,10,10,-10,-10,-1,-1),181);
        }

        {
            assertEquals(s.computeArea(-2, -2, 2, 2, -4, 3, -3, 4),17);
        }
    }
}