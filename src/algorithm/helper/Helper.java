package algorithm.helper;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author 58212
 * @date 2019-10-23 23:51
 */
public class Helper {

    public static void main(String[] args) {
        printArray(generateArray(3, 1, 4));
    }

    private Helper() {

    }

    public static int[] generateArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("");
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(i + ",");
            } else {
                System.out.println(i);
            }
        }
    }

    // 判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr) {

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            if (isSorted(arr)) {
                throw new IllegalArgumentException("Error");
            }

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
