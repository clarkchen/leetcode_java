package TwoSum;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/4/30.
 */
public class SolutionTest {

    @Test
    public void testTwoSum() throws Exception {
        Solution s = new Solution();
        int numbers[]={2, 7, 11, 15};
        int target=9;
        int[] ans = s.twoSum(numbers, target);
        assertEquals(ans[0],1);
        assertEquals(ans[1],2);

        numbers = new int []{2, 8, 11, 15};
        target=9;
        ans = s.twoSum(numbers, target);
        assertEquals(ans.length,0);


    }
}