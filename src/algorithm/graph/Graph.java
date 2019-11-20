package algorithm.graph;

import java.util.Iterator;

/**
 * @author Haoming Chen
 * Created on 2019/11/18
 */
public interface Graph {

    boolean addEdge(int n, int m);

    int V();

    int E();

    void show();

    Iterator iterator();

}
