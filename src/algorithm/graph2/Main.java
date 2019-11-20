package algorithm.graph2;

/**
 * @author Haoming Chen
 * Created on 2019/11/19
 */
public class Main {
    // 测试图的联通分量算法
    public static void main(String[] args) {

//        // TestG1.txt
//        String filename1 = "testG1.txt";
//        SparseGraph g1 = new SparseGraph(13, false);
//        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
//        Components component1 = new Components(g1);
//        System.out.println("TestG1.txt, Component Count: " + component1.count());
//        System.out.println();
//
//        // TestG2.txt
//        String filename2 = "testG2.txt";
//        SparseGraph g2 = new SparseGraph(6, false);
//        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
//        Components component2 = new Components(g2);
//        System.out.println("TestG2.txt, Component Count: " + component2.count());
        String filename = "testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();
        Path path = new Path(g);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(0, 6);
    }
}
