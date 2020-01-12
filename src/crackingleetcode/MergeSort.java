package crackingleetcode;

/**
 * @author 58212
 * @date 2020-01-12 23:26
 */
public class MergeSort {

    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(4 << 1);
    }

    public int[] sort(int[] data) {
        return sort(data, 0, data.length - 1);
    }

    private int[] sort(int[] data, int low, int high) {
        if (low == high) {
            return data;
        }
        int mid = (high + low) >> 1;
        int[] left = sort(data, low, mid);
        int[] right = sort(data, mid + 1, high);
        int[] result = new int[high - low + 1];
        int i = 0, k = 0;
        for (int j = 0; j < result.length; j++) {
            count++;
            if (i == left.length) {
                result[j] = right[k++];
            } else if (k == right.length) {
                result[j] = left[i++];
            } else {
                result[j] = right[k++];
            }
        }
        return result;
    }
}
