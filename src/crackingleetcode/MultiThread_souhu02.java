package crackingleetcode;

/**
 * 创建两个线程，其中一个输出1-52，另外一个输出A-Z。输出格式要求：12A 34B 56C 78D ...
 *
 * @author Haoming Chen
 * Created on 2020/1/7
 */
public class MultiThread_souhu02 {

    public static void main(String[] args) {
    }

//    public class Main {
//
//        public static volatile  boolean flag = false;
//        public static AtomicInteger time =new AtomicInteger(1);
//        public static void main(String[] args) {
//
//            new Thread(() -> {
//                for (int i = 1; i < 53; i=i+2) {
//                    if (!flag&&(time.get()==0||time.incrementAndGet()%2==0)) {
//
//                        System.out.print(i);
//                        System.out.print(i+1);
//                        flag=true;
//
//
//                    }
//                    else {
//                        i=i-2;
//                    }
//
//                }
//            }).start();
//
//            new Thread(() -> {
//                for (int i = 0; i < 26; i++) {
//                    if (flag&&(time.get()==1||time.incrementAndGet()%2==1)){
//
//                        System.out.print((char) (i + 'A'));
//                        System.out.print(' ');
//                        flag=false;
//
//
//                    }else {
//                        i--;
//                    }
//                }
//            }).start();
//        }
//    }


}
