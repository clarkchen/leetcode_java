/**
 * 
 */
package sms;
import java.math.BigInteger;
import java.util.*;
/**
 * @author chenxi
 *
 */
public class SolutionBigInteger {
	public String multiply(String num1, String num2) {
		if(num1==null||num2==null) return null;
		BigInteger bi1 = new BigInteger(num1);
		BigInteger bi2= new BigInteger(num2);
		return bi1.multiply(bi2).toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionBigInteger s = new SolutionBigInteger();
		String s1= "123123123123123";
		String s2="-3213123123123123";
		System.out.println(s.multiply(s1,s2));
	}

}
