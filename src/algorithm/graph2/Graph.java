package algorithm.graph2;

/**
 * @author Haoming Chen
 * Created on 2019/11/19
 */
public interface Graph {

    int V();

    int E();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Integer> adj(int v);

}
