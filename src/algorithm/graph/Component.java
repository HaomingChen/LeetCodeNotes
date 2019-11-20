package algorithm.graph;

/**
 * 深度优先遍历和联通分量
 *
 * @author Haoming Chen
 * Created on 2019/11/19
 */
public class Component<E extends Graph> {

    Graph graph;

    public Component(Graph graph) {
        this.graph = graph;
    }
    //无法使用迭代器泛型 设计缺陷........
    //思路, 对顶点作遍历所有邻接节点操作, 对邻接节点做递归
    public void dfs(Graph graph) {
        graph.iterator();
    }
}
