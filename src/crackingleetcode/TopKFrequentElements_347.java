package crackingleetcode;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * @author 58212
 * @date 2020-01-01 19:06
 */
public class TopKFrequentElements_347 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 1, 0};
        int k = 1;
        List<Integer> lst = TopKFrequentElements_347.topKFrequent(arr, k);
        System.out.println(lst.get(0));
    }
    //max heap O(nlog(n-k)) implementation
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int size = map.size() - k;
        if(map.size() < k){
            return res;
        }
        for(Integer key : map.keySet()){
            if(size > 0){
                pq.add(new Integer[]{key, map.get(key)});
                size--;
            }else{
                if(!pq.isEmpty() && map.get(key) < pq.peek()[1]){
                    res.add(pq.poll()[0]);
                    pq.add(new Integer[]{key, map.get(key)});
                }else{
                    res.add(key);
                }
            }
        }
        return res;
    }

}
