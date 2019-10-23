package tag.heap;

import java.util.*;

/**
 * @author Haoming Chen
 * Created on 2019/10/23
 */
public class TopKFrequentElementsUseJavaQ_347 {

    public static void main(String[] args) {
        TopKFrequentElementsUseJavaQ_347 tkf = new TopKFrequentElementsUseJavaQ_347();
        int[] arr = {5, 1, -1, -8, -7, 8, -5, 0, 1, 10, 8, 0, -4, 3, -1, -1, 4, -5, 4, -3, 0, 2, 2, 2, 4, -2, -4, 8, -7,
                -7, 2, -8, 0, -8, 10, 8, -8, -2, -9, 4, -7, 6, 6, -1, 4, 2, 8, -3, 5, -9, -3, 6, -8, -5, 5, 10, 2, -5,
                -1, -5, 1, -3, 7, 0, 8, -2, -3, -1, -5, 4, 7, -9, 0, 2, 10, 4, 4, -4, -1, -1, 6, -8, -9, -1, 9, -9, 3,
                5, 1, 6, -1, -2, 4, 2, 4, -6, 4, 4, 5, -5};
        tkf.topKFrequent(arr, 7);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : nums) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(freqMap::get));
        Iterator it = freqMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (pq.size() < k) {
                pq.add((Integer) entry.getKey());
            } else {
                if (freqMap.get(pq.peek()) < freqMap.get(entry.getKey())) {
                    pq.remove();
                    pq.add((Integer) entry.getKey());
                }
            }
        }
        List<Integer> resList = new ArrayList<>(k);
        while (!pq.isEmpty()) {
            resList.add(pq.poll());
        }
        return resList;
    }
}
