package algorithm.graph2;

import java.util.Stack;
import java.util.Vector;

/**
 * 寻找路径
 *
 * @author Haoming Chen
 * Created on 2019/11/20
 */
public class Path {

    Graph g;
    boolean[] visited;
    int[] from;
    boolean finded = false;

    private void dfs(int v) {
        visited[v] = true;
        for (int i : g.adj(v)) {
            if (!visited[i]) {
                //从顶点v访问至顶点i
                from[i] = v;
                dfs(i);
            }
        }
    }

    public Path(Graph graph) {
        g = graph;
        visited = new boolean[g.V()];
        from = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    //寻找顶点n到m的path
    public Vector<Integer> findPath(int n, int m) {
        Vector<Integer> path = new Vector<>();
        if (n < 0 || n >= g.V()) {
            return path;
        }
        if (m < 0 || m >= g.V()) {
            return path;
        }
        int pointer = m;
        Stack<Integer> pathStack = new Stack<>();
        do {
            pathStack.push(pointer);
            if (n == from[pointer]) {
                finded = true;
                break;
            }
            pointer = from[pointer];
        }
        while (pointer != m && pointer != -1);

        while (finded && !pathStack.isEmpty()) {
            path.add(pathStack.pop());
        }
        return path;
    }

    public boolean hasPath() {
        return finded;
    }

    //展示路径
    public void showPath(int n, int m) {
        Vector<Integer> path = findPath(n, m);
        System.out.print(n + " -> ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) {
                System.out.print(" -> ");
            }
        }
    }
}
