package Sort;

import java.util.ArrayList;
import java.util.Collections;

public class StringSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		String s2 = "cdb";
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(s2);ar.add(s1);
		System.out.println(ar);
		Collections.sort(ar);

		System.out.println(ar);
		System.out.println(s1.compareTo(s1));;
		System.out.println(s1.compareTo(s2));;
	}
}
