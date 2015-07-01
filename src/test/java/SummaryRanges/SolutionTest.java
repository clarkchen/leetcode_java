package SummaryRanges;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/6/30.
 */
public class SolutionTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSummaryRanges() throws Exception {
        Solution s = new Solution();

        {
            int nums[] = new int[] {0,1,2,4,5,7};
            List<String> list = s.summaryRanges(nums);
            assertEquals(list.get(0),"0->2");
            assertEquals(list.get(1),"4->5");
            assertEquals(list.get(2),"7");
        }

        {
            int nums[] = new int[] {0,1,2,3,4,5,6};
            List<String> list = s.summaryRanges(nums);
            assertEquals(list.get(0),"0->6");
        }

        {
            int nums[] = new int[] {0};
            List<String> list = s.summaryRanges(nums);
            assertEquals(list.get(0),"0");
        }
        {
            int nums[] = new int[] {0,3,5};
            List<String> list = s.summaryRanges(nums);
            assertEquals(list.get(0),"0");
            assertEquals(list.get(1),"3");
            assertEquals(list.get(2),"5");
        }
        {
            int nums[] = new int[] {0,3,5,6};
            List<String> list = s.summaryRanges(nums);
            assertEquals(list.get(0),"0");
            assertEquals(list.get(1),"3");
            assertEquals(list.get(2),"5->6");
        }


    }
}