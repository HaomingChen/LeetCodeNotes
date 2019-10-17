package data_structure.Array;

/**
 * @author 58212
 * @date 2019-09-22 17:10
 */
public class Array<E> {

    private E[] array;
    private int size;

    //构造函数,传入数组的容量capacity构造Array
    public Array(int capacity) {
        array = (E[]) new Object[capacity];
        size = 0;
    }

    //无参数的构造函数，默认数组的容量capacity = 10
    public Array() {
        this(10);
    }

    //获取第一个元素
    public E getFirst() {
        return get(0);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return array.length;
    }

    //获取index索引位置的元素
    public E get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("index is too big");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index is too small");
        }
        return array[index];
    }

    //修改index索引位置的元素为e
    public boolean changeIndex(int index, E e) {
        if (index >= size) {
            throw new IllegalArgumentException("index is too big");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index is too small");
        }
        array[index] = e;
        return true;
    }

    //查找数组中是否含有元素e
    public boolean contains(E e) {
        if (-1 == find(e)) {
            return false;
        }
        return true;
    }


    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < array.length; i++) {
            if (e.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    //向所有元素后添加一个新元素
    public void addLast(E e) {
        insert(size, e);
    }

    //向数组头添加一个元素
    public void addFirst(E e) {
        insert(0, e);
    }

    //在第index个位置插入一个新元素e
    public void insert(int index, E e) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        if (index > size) {
            throw new IllegalArgumentException("index is too big");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index is too small");
        }
        for (int i = size - 1; i > index; i--) {
            array[i + 1] = array[i];
        }
        size++;
        array[index] = e;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("delete failed, index is invalid");
        }
        E ret = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;//loitering objects

        if (size == array.length / 4 && array.length / 2 != 0) {
            resize(array.length / 2);
        }
        return ret;
    }

    //删除首部元素
    public E removeFirst() {
        return remove(0);
    }

    //删除尾部元素
    public E removeLast() {
        return remove(size - 1);
    }

    //删除指定元素,有则删除
    public void removeElement(E e) {
        if (find(e) != -1) {
            remove(find(e));
        }
    }

    //交换两个索引的size
    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) {
            throw new IllegalArgumentException("Illegal index found");
        }
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //重写toString方法，输出array的size和array的capacity及其每一个元素
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(String.format("The size of array is %d and the length of array is %d", size,
                array.length));
        stringBuilder.append("]:");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    //对数组进行扩容
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
