package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CCollectors {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Integer max = numbers
                .stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .get();
        System.out.println(max);

        List<Integer> numList = Arrays.asList(1, 2, 3, 4);
        Map<Boolean, List<Integer>> mapIsEvenIntegers = numList
                .stream()
                .collect(
                        Collectors.partitioningBy(number -> number % 2 == 0)
                );
        System.out.println(mapIsEvenIntegers);
    }
}
