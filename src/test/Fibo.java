package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Haoming Chen
 * @date 2020/7/23 11:29
 */
public class Fibo {

    static int num = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    public static int fibo(int i){

        if(i == 0){
            return 1;
        }
        if(i == 1){
            return 1;
        }
        if(!map.containsKey(i)){
            map.put(i, fibo(i - 1) + fibo(i - 2));
        }
        return map.get(i);

    }

    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        int num = 39;
        System.out.println(Fibo.fibo(num));
        System.out.println(num);
    }

}
