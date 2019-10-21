package maxheap;

import java.util.Random;

/**
 * @author 58212
 * @date 2019-10-17 1:22
 */
public class main {

    public static void main(String[] args) {
        int n = 1000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println("add complete");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        System.out.println("extract complete");
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                System.out.println(arr[i] + " ");
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed");
    }
}
