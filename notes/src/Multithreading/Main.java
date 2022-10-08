package Multithreading;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO Реализовать пример с использованием Thread
public class Main {
    public static String[] readFile(String filename) throws URISyntaxException, IOException {
        Path path = Paths.get(Main.class.getClassLoader()
                .getResource(filename).toURI());

        try (Stream<String> lines = Files.lines(path)) {
            return lines.toArray(String[]::new);
        }
    }

    public static ArrayList<String> readFileToArrayList(String filename) throws URISyntaxException, IOException {
        Path path = Paths.get(Main.class.getClassLoader()
                .getResource(filename).toURI());

        try (Stream<String> lines = Files.lines(path)) {
            return (ArrayList<String>) lines.collect(Collectors.toList());
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//        String[] orders = readFile("orders1000000.txt"); // 7495536665
        //TODO перевести в ArrayList<String> и проверить скорость работы parallelStream
        String[] orders = readFile("orders1000000_2.txt"); // 7499926559
//        String[] orders = readFile("orders10000.txt"); // 75417742
        ArrayList<String> ordersAL = readFileToArrayList("orders1000000.txt");
        Stream<String> stream = ordersAL.parallelStream();
        long time = System.currentTimeMillis();
        long totalSumAL = stream.mapToLong(Main::parseTotal).sum();
//        long totalSum = Arrays.stream(orders).mapToLong(Main::parseTotal).sum();
        System.out.println(System.currentTimeMillis() - time);
//        System.out.println("Total sum: " + totalSum);
        System.out.println(totalSumAL);
    }


    private static int parseTotal(String orderInfo) {
        // <name>, <total>
        String orderTotal = orderInfo.split(", ")[1];
        return Integer.parseInt(orderTotal);
    }
}
