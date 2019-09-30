package data_structure.LinkedList;

/**
 * @author 58212
 * @date 2019-10-01 0:05
 */
public class main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.add(1,2);
        linkedList.add(2,3);
        linkedList.add(2,6);
        linkedList.add(2,7);
        System.out.println(linkedList);
    }

}
