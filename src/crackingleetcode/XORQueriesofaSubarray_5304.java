package crackingleetcode;

/**
 * Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri], for each query i compute
 * the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array containing the result for the given queries.
 *
 * @author 58212
 * @date 2020-01-05 11:53
 */
public class XORQueriesofaSubarray_5304 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        if (queries.length == 0 || queries[0].length == 0) {
            return res;
        }
        for (int i = 0; i < queries.length; i++) {
            int lb = queries[i][0];
            int rb = queries[i][1];
            int sum = arr[lb];
            for (int j = lb + 1; j <= rb; j++) {
                sum = sum ^ arr[j];
            }
            res[i] = sum;
        }
        return res;
    }

}
