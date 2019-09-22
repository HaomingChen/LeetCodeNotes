package data_structure.Array;

/**
 * @author 58212
 * @date 2019-09-22 18:09
 */
public class main {

    public static void main(String[] args) {
        Array<Integer> array = new Array(12);
        for (int i = 0; i < 12; i++) {
            array.insert(i, i);
        }
        System.out.println(array);
        array.remove(5);
        System.out.println(array);
        int s = 1;
    }

    public static <T> T sji(T jss) {
        if (jss instanceof String) {
            System.out.println("this is a String");
        }
        if (jss instanceof Integer) {
            System.out.println("this is a Integer");
        }
        return jss;
    }

}
