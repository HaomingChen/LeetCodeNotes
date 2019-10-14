package map;

import set.FileOperation;

import java.util.ArrayList;

/**
 * @author 58212
 * @date 2019-10-15 0:16
 */
public class Main {

    public static void main(String[] args) {
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap();
        BSTMap<String, Integer> bstMap = new BSTMap();
        System.out.println("testCase(linkedListSet): " + testCase(linkedListMap));
        System.out.println("testCase(bstSet): " + testCase(bstMap));
    }

    private static String testCase(Map<String, Integer> map) {
        Long start = System.currentTimeMillis();
        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("E:\\workspace2\\LeetCodeNotes\\src\\set\\a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            for (String word : words2) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
        }

        Long end = System.currentTimeMillis();
        return Long.toString((end - start));
    }
}
