package Utils.Sort;

import java.util.Arrays;

/**
 * Created by chenxi on 15/4/30.
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] intArray = new int[] { 4, 1, 3, -23 };
        Arrays.sort(intArray);
        for (int v : intArray)
        {
            System.out.println(v);
        }

    }
}
