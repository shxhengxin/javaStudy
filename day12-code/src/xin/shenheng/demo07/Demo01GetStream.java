package xin.shenheng.demo07;

import java.util.*;
import java.util.stream.Stream;

public class Demo01GetStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();


        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String,String> map = new HashMap<>();
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();
        
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();


        Stream<Integer> stream6 = Stream.of(1, 2, 34, 5);

    }
}
