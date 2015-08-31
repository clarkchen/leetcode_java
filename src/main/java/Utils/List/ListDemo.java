package Utils.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxi on 15/8/31.
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("hello");
        list.set(0, list.get(0) + " world");
        System.out.println(list.get(0));
    }
}
