package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> strategyOne = getRoundOne();
        Map<String, Integer> strategyTwo = getRoundTwo();
        readFile(strategyOne);
        readFile(strategyTwo);
    }

    private static void readFile(Map<String, Integer> strategy) {
        try (Stream<String> stream = Files.lines(Paths.get("src/day2/guide.txt"))) {
            final int result = stream
                    .map(strategy::get)
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> getRoundOne() {
        Map<String, Integer> strategy = new HashMap<>();
        strategy.put("A X", 4);
        strategy.put("A Y", 8);
        strategy.put("A Z", 3);
        strategy.put("B X", 1);
        strategy.put("B Y", 5);
        strategy.put("B Z", 9);
        strategy.put("C X", 7);
        strategy.put("C Y", 2);
        strategy.put("C Z", 6);

        return strategy;
    }

    private static Map<String, Integer> getRoundTwo() {
        Map<String, Integer> strategy = new HashMap<>();
        strategy.put("A X", 3);
        strategy.put("A Y", 4);
        strategy.put("A Z", 8);
        strategy.put("B X", 1);
        strategy.put("B Y", 5);
        strategy.put("B Z", 9);
        strategy.put("C X", 2);
        strategy.put("C Y", 6);
        strategy.put("C Z", 7);

        return strategy;
    }
}