package algorithm.minimumspantrees.weightedgraph;

import java.util.Vector;

/**
 * 稀疏图 - 邻接表实现
 *
 * @author Haoming Chen
 * Created on 2019/11/21
 */
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private Vector<Edge<Weight>>[] g;
    //顶点数
    private int n;
    //边数
    private int m;
    //是否有向
    private boolean isDirected;

    public SparseWeightedGraph(int n, boolean isDirected) {
        this.n = n;
        this.isDirected = isDirected;
        m = 0;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Edge<Weight>>[]) new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    //向图中添加一个边, 权值为weight
    @Override
    public void addEdge(Edge e) {
        if (e.v() < 0 || e.w() < 0) {
            return;
        }
        if (e.v() >= n || e.w() >= m) {
            return;
        }
        //查询重边需要遍历链表which costs O(v)
        g[e.v()].add(new Edge(e));
        if (e.v() != e.w() && !isDirected) {
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));
        }
        m++;
    }

    //验证图中是否有v到w的边
    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || w < 0) {
            return false;
        }
        if (v >= n || v >= m) {
            return false;
        }
        for (Edge e : g[v]) {
            if (e.w() == w) {
                return true;
            }
        }
        return false;
    }

    //显示图的信息
    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                Edge e = g[i].elementAt(j);
                System.out.print("( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
