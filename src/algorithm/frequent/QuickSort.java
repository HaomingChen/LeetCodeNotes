package algorithm.frequent;

/**
 * @author Haoming Chen
 * Created on 2020/2/10
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 7, 9};
        quickSort(arr, 0, arr.length - 1);
        for(int item : arr){
            System.out.println(item);
        }
    }

    private static void quickSort(int[] arr, int head, int tail) {

        if (head >= tail) {
            return;
        }
        int pivot = partition(arr, head, tail);
        quickSort(arr, head, pivot - 1);
        quickSort(arr, pivot + 1, tail);
        return;
    }

    private static int partition(int[] arr, int head, int tail) {
        //[start, pivot, end
        int start = head;
       for(int i = head + 1; i <= tail; i++){
           if(arr[i] < arr[start]){
               head++;
               swap(arr, start, tail);
           }
       }
       swap(arr, head, start);
       return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
