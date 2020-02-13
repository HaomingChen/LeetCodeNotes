package interview.changing;

/**
 * @author Haoming Chen
 * Created on 2020/2/11
 */
public class Deadlock {

    static Object lockA = new Object();
    static Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(new TaskA()).start();
        new Thread(new TaskB()).start();
    }

    static class TaskA implements Runnable {
        @Override
        public void run() {
            synchronized (lockA) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {

                }
            }
        }
    }

    static class TaskB implements Runnable {
        @Override
        public void run() {
            synchronized (lockB) {
                synchronized (lockA) {

                }
            }
        }
    }

}
