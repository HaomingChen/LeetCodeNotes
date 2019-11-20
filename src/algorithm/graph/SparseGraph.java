package algorithm.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * E < V^2
 * 稀疏图: 邻接表实现
 * 排除平行边O(V)
 * 排除自环边
 *
 * @author Haoming Chen
 * Created on 2019/11/18
 */
public class SparseGraph implements Graph {

    List<Integer>[] graph;
    //该图为有向图或无向图
    boolean isDirect;
    //n个顶点
    int n;
    //m条边
    int m;

    SparseGraph(int size, boolean isDirect) {
        graph = new List[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        this.n = size;
        this.isDirect = isDirect;
    }

    //add edge to connect vertex n and m
    //忽略平行边,因检测平行边的时间复杂度较高
    @Override
    public boolean addEdge(int n, int m) {
        //检测边m,n是否有效
        if (n >= graph.length || n < 0) {
            return false;
        }
        if (m >= graph.length || m < 0) {
            return false;
        }
        //避免自环边
        if (n == m) {
            return false;
        }
        //将边n - m添加至顶点的边列表graph[n]中
        graph[n].add(m);
        //无向图
        if (!isDirect) {
            graph[m].add(n);
        }
        m++;
        return true;
    }

    //n个顶点
    @Override
    public int V() {
        return n;
    }

    //m条边
    @Override
    public int E() {
        return m;
    }

    @Override
    public void show() {
        System.out.println("\nSparse Graph Iteration\n");
        int count = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            SparseGraph.adjIterator adjIterator = new SparseGraph.adjIterator(graph, i);
            while (adjIterator.hasNext()) {
                System.out.print(adjIterator.next() + " ");
                count++;
            }
            System.out.println();
        }
        System.out.println("count:" + count);
    }

    @Override
    public Iterator iterator() {
        return new SparseGraph.adjIterator(graph, n);
    }

    //O(V)
    //检测边是否存在,避免平行边
    private boolean hasEdge(int n, int m) {
        //遍历该节点
        for (int item : graph[n]) {
            if (item == m) {
                return true;
            }
        }
        return false;
    }


    public static class adjIterator implements Iterator<Integer> {

        List<Integer>[] graph;
        int vertex;
        int pos;

        public adjIterator(List<Integer>[] graph, int vertex) {
            this.graph = graph;
            this.vertex = vertex;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Integer> action) {

        }

        @Override
        public boolean hasNext() {
            if (pos < graph[vertex].size()) {
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            return graph[vertex].get(pos++);
        }

    }
}
