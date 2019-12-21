package crackingleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 58212
 * @date 2019-12-21 1:37
 */
public class ThreeSum_15 {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(123);
        arr.add(334);
        System.out.println(arr.get(0));
        System.out.println(arr.get(1));

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(arr);
        List<List<Integer>> lists2 = new ArrayList<>();
        lists2.add(arr);
        lists.addAll(lists2);
    }

}
