package algorithm.heapandheapsort;

/**
 * @author 58212
 * @date 2019-11-08 0:08
 */
public class HeapSort<E extends Comparable<E>> {

    public static void main(String[] args) {
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            maxHeap.insert(random.nextInt(100));
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.print(maxHeap.extractMax() + " ");
//        }
//        System.out.println("\n" + "size equals to: " + maxHeap.getSize());
        Integer[] data = {7, 2, 9, 4, 1,6,2,12};
        HeapSort<Integer> heap = new HeapSort<>(data);
//        for (int i = 0; i < 5; i++) {
//            System.out.print(heap.extractMax() + " ");
//        }
//        System.out.println(heap.size);
        Comparable[] arr = heap.sort();
        for (Comparable item : arr) {
            System.out.print(" " + item);
        }
 
    }

    private E[] data;
    private int size;

    public HeapSort(int capacity) {
        size = 0;
        data = (E[]) new Comparable[capacity];
    }

    public HeapSort(E[] arr) {

        data = (E[]) new Comparable[arr.length];
        size = arr.length;

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        heapify(data);

    }

    /**
     * 鍘熷湴鍫嗘帓搴�
     *
     * @return
     */
    public E[] sort() {

        while (size > 1) {
            swap(size - 1, 0);
            size--;
            shiftDown(0);
        }
        return data;

    }

    public void insert(E ele) {
        if (size > data.length) {
            throw new IllegalArgumentException("Priority Queue is full");
        }
        data[size + 1] = ele;
        shiftUp(size + 1);
        size++;
    }

    public E extractMax() {
        E ret = data[0];
        data[0] = data[size - 1];
        size--;
        shiftDown(0);
        return ret;
    }

    private void shiftUp(int index) {
        if (index <= 0) {
            return;
        }
        if (data[(index - 1) / 2].compareTo(data[index]) > 0) {
            return;
        }
        swap(index, (index - 1) / 2);
        shiftUp((index - 1) / 2);
    }

    private void shiftDown(int index) {
        //宸﹀瓙鏍戝瓨鍦�
        while (index * 2 + 1 < size) {
            int j = index * 2 + 1;
            //鍙冲瓙鏍戝瓨鍦�,涓斿彸瀛愭爲澶т簬宸﹀瓙鏍�
            if (j + 1 < size && data[j].compareTo(data[j + 1]) < 0) {
                j = j + 1;
            }
            if (data[j].compareTo(data[index]) < 0) {
                break;
            }
            swap(j, index);
            index = j;
        }
    }

    public int getSize() {
        return size;
    }

    private void heapify(E[] arr) {
        //浠庢渶鍚庝竴涓猵arent鑺傜偣寮�濮嬪仛heapify鎿嶄綔
        for (int i = (size - 1) / 2; i > -1; i--) {
            shiftDown(i);
        }
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}