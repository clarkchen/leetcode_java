package BasicCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenxi on 15/7/1.
 */
public class SolutionTest {

    @Test
    public void testCalculate() throws Exception {
        Solution s = new Solution();
        {
            String eq = "5";
            assertEquals(s.calculate(eq), 5);
        }
        {
            String eq = "5+3";
            assertEquals(s.calculate(eq), 8);
        }
        {
            String eq = "5*3";
            assertEquals(s.calculate(eq), 15);
        }
        {
            String eq = "5*3+4";
            assertEquals(s.calculate(eq), 19);
        }
        {
            String eq = "5+3*4";
            assertEquals(s.calculate(eq), 17);
        }
        {
            String eq = "(5+3)*4";
            assertEquals(s.calculate(eq), 32);
        }
        {
            String eq = "(5*3)*4";
            assertEquals(s.calculate(eq), 60);
        }
        {
            String eq = "5*(3)*4";
            assertEquals(s.calculate(eq), 60);
        }
        {
            String eq = "5+(3)*4";
            assertEquals(s.calculate(eq), 17);
        }
        {
            String eq = "5*(3+4)";
            assertEquals(s.calculate(eq), 35);
        }
        {
            String eq = "1-11";
            assertEquals(s.calculate(eq), -10);
        }

        {
            String eq = "5*(1-11)";
            assertEquals(s.calculate(eq), -50);
        }
        {
            String eq = "5-1*11";
            assertEquals(s.calculate(eq), -6);
        }
        {
            String eq = " 2-1 + 2 ";
            assertEquals(s.calculate(eq), 3);
        }
        {
            String eq ="(1+(4+5+2)-3)+(6+8)";
            assertEquals(s.calculate(eq),23);
        }
        {
            String eq ="3/2";
            assertEquals(s.calculate(eq),1);
        }
        {
            String eq = " 3+5 / 2";
            assertEquals(s.calculate(eq),5);
        }
        {
            String eq = "3+2*2";
            assertEquals(s.calculate(eq), 7);
        }
        {
            String eq ="0-2147483648";
            assertEquals(s.calculate(eq),-2147483648);
        }
        {
            String eq ="10/2/3";
            assertEquals(s.calculate(eq),1);
        }
    }
}