package algorithm.minimumspantrees.weightedgraph;

/**
 * @author Haoming Chen
 * Created on 2019/11/21
 */
public interface WeightedGraph<Weight extends Number & Comparable> {
    int V();

    int E();

    void addEdge(Edge<Weight> e);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Edge<Weight>> adj(int v);

}
