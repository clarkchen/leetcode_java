package Utils.Stack;

import java.util.Stack;

/**
 * Created by chenxi on 15/7/9.
 */
public class StackUtil {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(5);
        s.push(7);
        Stack<Integer> s1 = (Stack<Integer>)s.clone();

        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s1.size());


    }
}
