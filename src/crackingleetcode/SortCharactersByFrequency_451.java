package crackingleetcode;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * @author 58212
 * @date 2019-12-21 0:40
 */
public class SortCharactersByFrequency_451 {

    class Solution {
        public String frequencySort(String s) {
            if (s == null) {
                return "";
            }
            PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
                @Override
                public int compare(Element o1, Element o2) {
                    if (o1.freq == o2.freq) {
                        return (int) o1.character - (int) o2.character;
                    }
                    return o2.freq - o1.freq;
                }
            });
            Map<Character, Integer> freqMap = new HashMap<>();
            char[] sArr = s.toCharArray();
            for (char i : sArr) {
                if (freqMap.containsKey(i)) {
                    freqMap.put(i, freqMap.get(i) + 1);
                } else {
                    freqMap.put(i, 1);
                }
            }
            for (Character i : freqMap.keySet()) {
                pq.add(new Element(i, freqMap.get(i)));
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!pq.isEmpty()) {
                Element element = pq.poll();
                for (int i = 0; i < element.freq; i++) {
                    stringBuilder.append(element.character);
                }
            }
            return stringBuilder.toString();
        }

        public class Element {
            public Element(char character, int freq) {
                this.character = character;
                this.freq = freq;
            }
            char character;
            int freq;
        }
    }
}
