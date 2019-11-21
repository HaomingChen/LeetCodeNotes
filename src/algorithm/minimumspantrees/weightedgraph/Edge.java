package algorithm.minimumspantrees.weightedgraph;

/**
 * @author Haoming Chen
 * Created on 2019/11/21
 */
//边
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {

    private int a, b;
    private Weight weight;

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    public int v() {
        return a;
    }//返回第一个顶点

    public int w() {
        return b;
    }//返回第二个顶点

    public Weight wt() {
        return weight;
    }

    //给定一个顶点,返回另一个顶点
    public int other(int x) {
        if (x != a && x != b) {
            return -1;
        }
        return x == a ? a : b;
    }

    //输出边的信息
    @Override
    public String toString() {
        return "" + a + "-" + b + ": " + weight;
    }

    //边之间的比较
    @Override
    public int compareTo(Edge that) {
        if (weight.compareTo(that.wt()) < 0) {
            return -1;
        }
        if (weight.compareTo(that.wt()) > 0) {
            return 1;
        }
        return 0;
    }
}
