package algorithm.sortbasic;

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

    public static Integer[] generateArray(int size, int min, int max) {
        Random rand = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void printArray(Integer[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("");
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.println(arr[i]);
            }
        }
    }

    // 判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr) {

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class cls = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = cls.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            // 调用排序函数
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(cls.newInstance(), params);
            long endTime = System.currentTimeMillis();

            System.out.println(cls.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer[] copyArray(Integer[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException("Input array can not be null or empty");
        }
        Integer[] array = new Integer[source.length];
        for (int i = 0; i < source.length; i++) {
            array[i] = source[i];
        }
        return array;
    }

}
