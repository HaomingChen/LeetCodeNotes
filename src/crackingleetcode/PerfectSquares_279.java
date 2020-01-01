package crackingleetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 *
 * @author 58212
 * @date 2020-01-01 17:51
 */
public class PerfectSquares_279 {

    public int numSquares(int n) {
        //current value -> step
        Queue<Integer[]> q = new LinkedList<>();
        Integer[] path = new Integer[]{n, 0};
        boolean[] visited = new boolean[n + 1];
        q.offer(path);
        while(!q.isEmpty()){
            Integer[] vertex = q.poll();
            for(int i = 0; vertex[0] - i*i >= 0; i++){
                if(vertex[0] - i * i == 0){
                    return vertex[1] + 1;
                }else{
                    if(!visited[vertex[0] - i * i]){
                        q.offer(new Integer[]{vertex[0] - i * i, vertex[1] + 1});
                        visited[vertex[0] - i * i] = true;
                    }
                }
            }
        }
        throw new IllegalArgumentException("impossible");
    }

}
