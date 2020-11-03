
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class 스트림2 {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{15,20,20, 19, 40};
        //Stream<Integer> intStream= Arrays.stream(arr);
        List<Integer> list=  Arrays.asList(arr);
        //intStream.sorted(reverseOrder());
        //System.out.println(intStream.);
        System.out.println(list);
        System.out.println(Arrays.asList(list.stream().distinct().toArray()));
        System.out.println(list);



        //문자열 스트림 연습

        Stream<String> stream=Stream.of("abc", "abd", "de1f");
        IntStream intStream=stream.mapToInt(s -> s.length());
        System.out.println(intStream.boxed().collect(Collectors.toList()));
    }
}
