package tag.heap;

/**
 * @author 58212
 * @date 2019-10-21 23:47
 */
public class TopKFrequentElements_347 {


//    public List<Integer> topKFrequent(int[] nums, int k) {
//
//    }

    class MinHeap<E extends Comparable> {

        E[] data;
        int size;

        //put how many elements in it, e.g. m elements = capacity
        public MinHeap(int capacity) {
            data = (E[]) new Object[capacity];
        }

        public void add(E e) {
            if (size < data.length) {
                data[size] = e;
                siftUp(size);
                size++;
            }
        }

        public E extractMin(E e) {
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
                    index = change;
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
            data[k] = temp;
        }


    }

}
