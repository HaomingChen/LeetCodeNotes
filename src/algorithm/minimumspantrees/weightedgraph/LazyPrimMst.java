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
        // 算法初始化
        G = graph;
        pq = new MinHeap<>(G.E());
        marked = new boolean[G.V()];
        mst = new Vector<>();
        // Lazy Prim
        visit(0);
        while (!pq.isEmpty()) {
            pq.extractMin();

        }
        // 计算最小生成树的权值
        for (int i = 0; i < mst.size(); i++)
            mstWeight = mstWeight.doubleValue() + mst.get(i).wt().doubleValue();
    }

    // 访问节点v
    private void visit(int v) {
        //该节点已被访问
        if (marked[v] == true) {
            return;
        }
        marked[v] = true;
        // 将和节点v相连接的所有未访问的边放入最小堆中
        for (Edge e : G.adj(v)) {
            if (!marked[e.w()]) {
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
