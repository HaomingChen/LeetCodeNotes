package algorithm.graph2;

// 求无权图的联通分量
public class Components {

    Graph G;
    private boolean[] visited;
    //联通分量数
    private int ccount;
    //联通分量id
    private int[] id;

    //从根节点开始遍历该图的单个联通分量
    void dfs(int v) {
        id[v] = ccount;
        visited[v] = true;
        //遍历该节点所有的邻接节点
        for (int i : G.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    //构造函数
    public Components(Graph graph) {
        //算法初始化
        G = graph;
        ccount = 0;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }
        //通过图的深度遍历求图的联通分量
        //对每一个节点都做深度优先遍历
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                //对当前vertex做深度优先搜索
                dfs(i);
                //联通分量increase by 1
                ccount++;
            }
        }
    }

    //返回图的联通分量个数
    int count() {
        return ccount;
    }

    //查询点v和点w是否联通
    boolean isConnected(int v, int w) {
        if (v < 0 || v >= G.V()) {
            return false;
        }
        if (w < 0 || w >= G.V()) {
            return false;
        }
        return id[w] == id[v];
    }

}