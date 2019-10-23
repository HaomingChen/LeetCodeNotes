package algorithm.sortbasic;

/**
 * @author Haoming Chen
 * Created on 2019/10/23
 */
public class SelectionSort<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer[] s = {1, 7, 2, 6, 4, 0, 2, 6, 4, 5, 1, 7, 4};
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] sorted = ss.selctSort(s);
        for (int i : sorted) {
            System.out.print(i + " ");
        }

        SelectionSort<Student> sp = new SelectionSort<>();
        Student[] scoreList = {new Student("jack", 20), new Student("mike", 87),
                new Student("snow", 88), new Student("marry", 12)};
        scoreList = sp.selctSort(scoreList);
        for (Student student : scoreList) {
            System.out.print(student.name + " ");
        }
    }

    private E[] selctSort(E[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("数组不可为空");
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }
            swap(i, min, arr);
        }
        return arr;
    }

    private void swap(int i, int j, E[] arr) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class Student implements Comparable<Student> {

        String name;

        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            if ((o.score - this.score) > 0) {
                return -1;
            } else if ((o.score - this.score) < 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
