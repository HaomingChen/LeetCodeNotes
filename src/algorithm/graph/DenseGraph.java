package algorithm.graph;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * E >= V^2
 * 稠密图: 邻接矩阵实现
 * 排除平行边O(1)
 *
 * @author Haoming Chen
 * Created on 2019/11/18
 */
public class DenseGraph implements Graph {

    boolean[][] graph;
    //n个顶点, m条边
    int n, m;
    //是否有向
    boolean isDirected;

    //size = 顶点数
    public DenseGraph(int size, boolean isDirected) {
        graph = new boolean[size][size];
        this.isDirected = isDirected;
        this.n = size;
    }

    //添加边n - m
    @Override
    public boolean addEdge(int n, int m) {
        if (n < 0 || n >= graph.length) {
            return false;
        }
        if (m < 0 || m >= graph.length) {
            return false;
        }
        //排除自环边
        if (n == m) {
            return false;
        }
        //天然排除平行边
        graph[n][m] = true;
        //判断是否有向
        if (!isDirected) {
            graph[m][n] = true;
        }
        m++;
        return true;
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void show() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            DenseGraph.adjIterator adjIterator = new DenseGraph.adjIterator(graph, i);
            for (int pos = 0; adjIterator.hasNext(); pos++) {
                if (adjIterator.next()) {
                    System.out.print(pos + " ");
                    count++;
                }
            }
            System.out.println();
        }
        System.out.println("count:" + count);
    }

    @Override
    public Iterator iterator() {
        return new DenseGraph.adjIterator(graph, n);
    }

    //稠密图,邻接矩阵实现对一个顶点的邻接顶点遍历O(V)
    //相较于邻接矩阵的遍历当前节点时间复杂度O(V),仅当邻接表表达的图为稠密图时, 邻接表对顶点的遍历才>=O(V)
    //相邻节点迭代器
    public static class adjIterator implements Iterator<Boolean> {

        boolean[][] graph;
        int pos;
        int vertex;

        public adjIterator(boolean[][] graph, int vertex) {
            this.graph = graph;
            this.vertex = vertex;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Boolean> action) {

        }

        @Override
        public boolean hasNext() {
            //遍历V
            if (pos < graph[vertex].length) {
                return true;
            }
            return false;
        }

        @Override
        public Boolean next() {
            return graph[vertex][pos++];
        }
    }

}
