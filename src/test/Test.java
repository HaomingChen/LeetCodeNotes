package test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final Integer JJ = 5;
    public static void main(String[] args) {

        List<Long> shitty = new ArrayList<>();
        shitty.add(1L);
        shitty.add(2L);
        shitty.add(3L);
        shitty.add(4L);
        shitty.add(5L);

        Integer startIndex = 0;
        Integer listSize = shitty.size();
        while(startIndex < listSize){
            Integer endIndex = startIndex + JJ < listSize? startIndex + JJ : listSize;
            List<Long> arrayList = shitty.subList(startIndex, endIndex);
            arrayList.stream().forEach(s ->{
                System.out.println(s + " ");
            });
            startIndex = endIndex;
        }
    }

}
