package algorithm.graph;

import java.util.Random;

/**
 * @author Haoming Chen
 * Created on 2019/11/18
 */
public class Main {

    //20个顶点
    static int n = 20;
    //100条边
    static int m = 100;

    public static void main(String[] args) {
        //拥有20个顶点的稀疏图
        SparseGraph sparseGraph = new SparseGraph(n, false);
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
            int n = rand.nextInt(20);
            int m = rand.nextInt(20);
            sparseGraph.addEdge(n, m);
        }
        //迭代稀疏图寻找相邻节点
        //邻接表O[E]
        System.out.println("\nSparse Graph Iteration\n");
        int count = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            SparseGraph.adjIterator adjIterator = new SparseGraph.adjIterator(sparseGraph.graph, i);
            while (adjIterator.hasNext()) {
                System.out.print(adjIterator.next() + " ");
                count++;
            }
            System.out.println();
        }
        System.out.println("count:" + count);
        //稠密图
        System.out.println("\nDense Graph Iteration\n");
        DenseGraph denseGraph = new DenseGraph(n, false);
        for (int i = 0; i < m; i++) {
            int n = rand.nextInt(20);
            int m = rand.nextInt(20);
            denseGraph.addEdge(n, m);
        }

        //迭代稠密图寻找相邻节点
        //邻接矩阵O[V^2]
        count = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            DenseGraph.adjIterator adjIterator = new DenseGraph.adjIterator(denseGraph.graph, i);
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
}
