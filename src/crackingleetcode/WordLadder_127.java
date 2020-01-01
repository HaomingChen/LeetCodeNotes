package crackingleetcode;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * <p>
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * @author 58212
 * @date 2020-01-01 18:29
 */
public class WordLadder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) {
            return 0;
        }
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{beginWord, "1"});
        Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            String[] path = q.poll();
            for (String word : wordList) {
                if (!visited.contains(word)) {
                    if (transferrable(path[0], word)) {
                        if (word.equals(endWord)) {
                            return Integer.parseInt(path[1]) + 1;
                        } else {
                            q.offer(new String[]{word, Integer.toString(Integer.parseInt(path[1]) + 1)});
                            visited.add(word);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean transferrable(String source, String target) {
        char[] sr = source.toCharArray();
        char[] tgt = target.toCharArray();
        if (sr.length != tgt.length) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < sr.length; i++) {
            if (sr[i] != tgt[i]) {
                count++;
            }
        }
        return count == 1;
    }

}
