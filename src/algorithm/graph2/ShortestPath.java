package algorithm.graph2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * @author Haoming Chen
 * Created on 2019/11/21
 */
public class ShortestPath {

    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;

    // 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
    public ShortestPath(Graph graph, int s) {

        G = graph;
        this.s = s;
        visited = new boolean[G.V()];
        from = new int[G.V()];
        ord = new int[G.V()];

        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }

        // 无向图最短路径算法, 从s开始广度优先遍历整张图
        // 广度遍历即是求最短路径因广度遍历按照"深度"进行排序,
        // 先遍历到的节点即是最短路径
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        //原点据自己的距离
        ord[s] = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            //广度遍历
            for (int adje : G.adj(i)) {
                //未访问过i
                if (!visited[i]) {
                    //距原点的距离等于广度遍历的父节点+1
                    ord[adje] = ord[i] + 1;
                    from[adje] = i;
                    visited[adje] = true;
                }
            }
        }
    }


    // 查询从s点到w点是否有路径
    public boolean hasPath(int w) {
        if (w < 0 || w >= G.V()) {
            return false;
        }
        return visited[w];
    }

    // 查询从s点到w点的路径, 存放在vec中
    public Vector<Integer> path(int w) {

        if (hasPath(w)) {
            return null;
        }
        Stack<Integer> s = new Stack<Integer>();
        //通过from数组逆向查找从s到w的路径,存放到栈中
        int p = w;
        while (p != -1) {
            s.push(w);
            p = from[p];
        }
        //从栈中依次去除元素,获得顺序从s到w的路径
        Vector<Integer> res = new Vector<Integer>();
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;

    }

    // 打印出从s点到w点的路径
    public void showPath(int w) {
        if (!hasPath(w)) {
            return;
        }
        Vector<Integer> vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.println(vec.elementAt(i));
            if(i == vec.size() - 1){
                System.out.println();
            }else{
                System.out.println(" -> ");
            }
        }
    }

    // 查看从s点到w点的最短路径长度
    // 若从s到w不可达，返回-1
    public int length(int w) {
        if(w <=0 || w >= G.V()){
            return -1;
        }
        return ord[w];
    }

}
