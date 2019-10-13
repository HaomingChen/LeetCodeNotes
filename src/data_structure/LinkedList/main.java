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
        linkedList.removeElement(6);
        linkedList.removeElement(1);
        linkedList.removeElement(3);
        System.out.println(linkedList);
//        System.out.println("linkedList.getFirst(): " + linkedList.getFirst());
//        System.out.println("linkedList.getLast(): " + linkedList.getLast());
//        linkedList.update(2,13);
//        System.out.println(linkedList);
//        System.out.println(linkedList.contains(6));
//        System.out.println(linkedList.contains(9));
//        System.out.println(linkedList.remove(1));
//        System.out.println(linkedList);
    }

}
