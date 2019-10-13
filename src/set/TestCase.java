package set;

import java.util.ArrayList;

/**
 * @author 58212
 * @date 2019-10-13 23:02
 */
public class TestCase {
    public static void main(String[] args) {
        LinkedListSet linkedListSet = new LinkedListSet();
        BSTSet bstSet = new BSTSet();
        System.out.println("testCase(linkedListSet): " + testCase(linkedListSet));
        System.out.println("testCase(bstSet): " + testCase(bstSet));
    }

    private static String testCase(Set set) {
        Long start = System.currentTimeMillis();
        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("E:\\workspace2\\LeetCodeNotes\\src\\set\\a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            for (String word : words2)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }

        Long end = System.currentTimeMillis();
        return Long.toString((end - start));
    }
}
