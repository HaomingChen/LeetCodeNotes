package tag.heap;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * @author 58212
 * @date 2019-10-21 23:47
 */
public class TopKFrequentElements_347 {

    public static void main(String[] args) {
        TopKFrequentElements_347 tkf = new TopKFrequentElements_347();
        int[] arr = {5, 1, -1, -8, -7, 8, -5, 0, 1, 10, 8, 0, -4, 3, -1, -1, 4, -5, 4, -3, 0, 2, 2, 2, 4, -2, -4, 8, -7,
                -7, 2, -8, 0, -8, 10, 8, -8, -2, -9, 4, -7, 6, 6, -1, 4, 2, 8, -3, 5, -9, -3, 6, -8, -5, 5, 10, 2, -5,
                -1, -5, 1, -3, 7, 0, 8, -2, -3, -1, -5, 4, 7, -9, 0, 2, 10, 4, 4, -4, -1, -1, 6, -8, -9, -1, 9, -9, 3,
                5, 1, 6, -1, -2, 4, 2, 4, -6, 4, 4, 5, -5};
        tkf.topKFrequent(arr, 7);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        MinHeap<Elements> minHeap = new MinHeap<>(k);
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        List<Integer> frequencyList = new ArrayList<>();
        //时间复杂度为n*logn
        for (int i = 0; i < nums.length; i++) {
            if (frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            } else {
                frequencyMap.put(nums[i], 1);
            }
        }

        Iterator it = frequencyMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (minHeap.size < k) {
                minHeap.add(new Elements((Integer) entry.getKey(), (Integer) entry.getValue()));
            } else {
                if (minHeap.data[0].freq < (Integer) entry.getValue()) {
                    minHeap.replaceMin(new Elements((Integer) entry.getKey(), (Integer) entry.getValue()));
                }
            }
        }

        while (minHeap.size != 0) {
            frequencyList.add(minHeap.extractMin().val);
        }

        return frequencyList;

    }

    class Elements implements Comparable<Elements> {

        public Elements(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int val;
        public int freq;

        @Override
        public int compareTo(Elements e) {
            if (e.freq < this.freq) {
                return 1;
            } else if (e.freq == this.freq) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    class MinHeap<E extends Comparable<E>> {

        E[] data;
        int size;

        //put how many elements in it, e.g. m elements = capacity
        public MinHeap(int capacity) {
            data = (E[]) new Elements[capacity];
        }

        public void add(E e) {
            if (size < data.length) {
                data[size] = e;
                siftUp(size);
                size++;
            }
        }

        public E replaceMin(E e) {
            E ret = data[0];
            data[0] = e;
            siftDown(0);
            return ret;
        }

        public E extractMin() {
            if (size == 0) {
                throw new IllegalArgumentException("This heap is already empty");
            }
            E min = data[0];
            data[0] = data[size - 1];
            size--;
            siftDown(0);
            return min;
        }

        private void siftDown(int index) {
            int change = index * 2 + 1;
            //左子树存在
            while (change < size) {
                //右子树存在, 且右子树小于左子树
                if (change + 1 < size && data[change + 1].compareTo(data[change]) < 0) {
                    change = change + 1;
                }
                //左子树和右子树中的最小值小于当前节点
                if (data[change].compareTo(data[index]) < 0) {
                    swap(index, change);
                    index = change;
                    change = change * 2 + 1;
                } else {
                    break;
                }
            }
        }

        private void siftUp(int index) {
            //当前节点小于父节点
            while (index > 0 && data[index].compareTo(data[(index - 1) / 2]) < 0) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int k, int p) {
            E temp = data[k];
            data[k] = data[p];
            data[p] = temp;
        }

    }

}
