package algorithm.minimumspantrees.weightedgraph;

import java.util.Vector;

/**
 * 使用prim算法求图的最小生成树
 *
 * @author Haoming Chen
 * Created on 2019/11/21
 */
public class LazyPrimMst<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> G;    // 图的引用
    private MinHeap<Edge<Weight>> pq;   // 最小堆, 算法辅助数据结构
    private boolean[] marked;           // 标记数组, 在算法运行过程中标记节点i是否被访问
    private Vector<Edge<Weight>> mst;   // 最小生成树所包含的所有边
    private Number mstWeight;           // 最小生成树的权值

    //构造函数,使用Prim算法求图的最小生成树
    public LazyPrimMst(WeightedGraph<Weight> graph) {

        G = graph;
        pq = new MinHeap<>(G.E());
        marked = new boolean[G.V()];
        mst = new Vector<>();
        mstWeight = 0;

        visit(0);
        while (!pq.isEmpty()) {
            Edge<Weight> edge = pq.extractMin();
            //该边为内部边 -> 舍弃
            if (marked[edge.v()] && marked[edge.w()]) {
                continue;
            }
            mst.add(edge);
            mstWeight = mstWeight.doubleValue() + edge.wt().doubleValue();
            visit(marked[edge.v()] ? edge.w() : edge.v());
        }
    }

    // 访问节点v
    private void visit(int v) {
        if (marked[v]) {
            return;
        }
        marked[v] = true;
        for (Edge<Weight> e : G.adj(v)) {
            //该边的两个顶点未均被访问过 -> 该边不为树内部的边
            if (!marked[e.w()] || !marked[e.v()]) {
                pq.insert(e);
            }
        }
    }

    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges() {
        return mst;
    }

    // 返回最小生成树的权值
    Number result() {
        return mstWeight;
    }

}
