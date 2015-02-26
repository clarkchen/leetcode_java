package asip;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		
		Solution s = new Solution();
		int []a = new int[] {1,3};
		int target = 3;
		assertTrue(s.searchInsert(a, target)==1);
		
		a = new int []{1,3,5,6};
		target  = 5;
		assertTrue(s.searchInsert(a, target)==2);
		
		a = new int []{1,3,5,6};
		target  = 2;
		assertTrue(s.searchInsert(a, target)==1);
		
	}

}
