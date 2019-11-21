package algorithm.minimumspantrees.weightedgraph;

import java.util.Vector;

/**
 * 稠密图 - 邻接矩阵
 *
 * @author Haoming Chen
 * Created on 2019/11/21
 */
public class DenseWeightedGraph<Weight extends Number & Comparable> implements  WeightedGraph{
    private int n; //节点数
    private int m; //边数
    private boolean directed; //是否为有向图
    private Edge<Weight>[][] g;//图(带有权边)

    public DenseWeightedGraph(int n, boolean directed) {
        this.n = n;
        m = 0;
        this.directed = directed;
        g = new Edge[n][n];
        //显式的初始化局部变量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    //返回节点的个数
    public int V() {
        return n;
    }

    //返回边的个数
    public int E() {
        return m;
    }

    //向图中添加一个边
    @Override
    public void addEdge(Edge e) {
        if (e.v() < 0 || e.v() >= n) {
            return;
        }
        if (e.w() < 0 || e.w() >= n) {
            return;
        }
        if (hasEdge(e.v(), e.w())) {
            return;
        }
        g[e.v()][e.w()] = new Edge(e);
        if (e.v() != e.w() && !directed) {
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());
        }
        m++;
    }

    //验证图中是否有v到w的边
    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || w < 0) {
            return false;
        }
        if (v >= n || w >= n) {
            return false;
        }
        return g[v][w] != null;
    }

    //显示图的信息
    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {
                    System.out.println(g[i][j].wt() + "\t");
                } else {
                    System.out.println("NULL\t");
                }
            }
            System.out.println();
        }
    }

    //返回图中一个顶点的所有邻边
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        if (v < 0 || v >= n) {
            return null;
        }
        Vector<Edge<Weight>> adjV = new Vector<Edge<Weight>>();
        for (int i = 0; i < n; i++) {
            if (g[v][i] != null) {
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }
}
