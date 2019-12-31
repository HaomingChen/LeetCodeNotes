package crackingleetcode;

/**
 * 使用队列实现栈 -> 使用栈实现队列
 *
 * @author 58212
 * @date 2020-01-01 0:33
 */
public class StackToQueueAndQueueToStack {
    public static void main(String[] args) {
//        QueueToStack qs = new QueueToStack(10);
//        qs.push(12);
//        qs.push(13);
//        System.out.println(qs.pop());
//        System.out.println(qs.pop());
//        qs.push(15);
//        qs.push(18);
//        qs.push(21);
//        System.out.println(qs.pop());
//        System.out.println(qs.pop());
//        System.out.println(qs.pop());
        StackToQueue sq = new StackToQueue(10);
        sq.enqueue(12);
        sq.enqueue(13);
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());
        sq.enqueue(13);
        sq.enqueue(15);
        System.out.println(sq.dequeue());

    }

}

class QueueToStack {

    public QueueToStack(int size) {
        arr1 = new int[size];
        arr2 = new int[size];
        size1 = 0;
        size2 = 0;
    }

    int size1;
    int[] arr1;

    int size2;
    int[] arr2;

    public int push(int val) {
        if (size1 != 0) {
            arr1[size1++] = val;
        } else {
            arr2[size2++] = val;
        }
        return val;
    }

    public int pop() {
        if (size1 != 0) {
            for (int i = 0; i < size1 - 1; i++) {
                arr2[i] = arr1[i];
            }
            size2 = size1 - 1;
            int temp = size1;
            size1 = 0;
            return arr1[temp - 1];
        } else {
            for (int i = 0; i < size2 - 1; i++) {
                arr1[i] = arr2[i];
            }
            size1 = size2 - 1;
            int temp = size2;
            size2 = 0;
            return arr2[temp - 1];
        }
    }
}


class StackToQueue {

    int size1;
    int[] arr1;

    int size2;
    int[] arr2;

    public StackToQueue(int size) {
        arr1 = new int[size];
        arr2 = new int[size];
        size1 = 0;
        size2 = 0;
    }

    public int enqueue(int val) {
        if (size1 != 0) {
            arr1[size1++] = val;
        } else {
            arr2[size2++] = val;
        }
        return val;
    }

    public int dequeue() {
        int j = 0;
        if (size1 != 0) {
            for (int i = size1 - 1; i > 0; i--) {
                arr2[j] = arr1[i];
                j++;
            }
            size2 = size1 - 1;
            size1 = 0;
            return arr1[0];
        } else {
            for (int i = size2 - 1; i > 0; i--) {
                arr1[j] = arr2[i];
                j++;
            }
            size1 = size2 - 1;
            size2 = 0;
            return arr2[0];
        }
    }

}
