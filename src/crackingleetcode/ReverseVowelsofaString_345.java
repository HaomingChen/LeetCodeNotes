package crackingleetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * @author Haoming Chen
 * Created on 2019/12/14
 */
public class ReverseVowelsofaString_345 {

    public static void main(String[] args) {
        ReverseVowelsofaString_345 reverseVowelsofaString_345 = new ReverseVowelsofaString_345();
        reverseVowelsofaString_345.reverseVowels("hello");
        HashSet<String> set = new HashSet<>();

        List<IJS> list = new ArrayList<>();
        list.add(new IJS("SS"));
        list.add(new IJS("eee"));
        System.out.println(list.toString());
    }


    public static class IJS{

        public IJS(){

        }
        public IJS(String ks){
            this.ks = ks;
        }
        String ks = "true";
    }

    public String reverseVowels(String s) {
        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');
        vowelsSet.add('A');
        vowelsSet.add('E');
        vowelsSet.add('I');
        vowelsSet.add('O');
        vowelsSet.add('U');

        char[] str = s.toCharArray();
        int head = 0;
        int tail = str.length - 1;
        while(head < tail){
            if(vowelsSet.contains(str[head]) && vowelsSet.contains(str[tail])){
                swap(str, head, tail);
                head ++;
                tail --;
            }else if(vowelsSet.contains(str[head])){
                tail --;
            }else if(vowelsSet.contains(str[tail])){
                head ++;
            }else{
                head ++;
                tail --;
            }
        }
        return new String(str);

    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
