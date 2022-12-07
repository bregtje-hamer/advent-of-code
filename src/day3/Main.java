package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        readFilePartOne();
        readFilePartTwo();
    }

    private static void readFilePartOne() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day3/items.txt"));
        Character[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String line;
        List<Character> duplicatedItems = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            int compartmentCount = line.length() / 2;

            String firstCompartment = line.substring(0, compartmentCount);
            String secondCompartment = line.substring(compartmentCount);
            findItemInGroup(firstCompartment, secondCompartment, null, duplicatedItems);

        }
        int prioritySum = 0;
        for (Character c : duplicatedItems) {
            prioritySum += Arrays.asList(characters).indexOf(c) + 1;
        }
        System.out.println(prioritySum);
    }


    private static void readFilePartTwo() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day3/items.txt"));
        Character[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String line;
        int lineCount = 0;
        List<Character> duplicatedItems = new ArrayList<>();
        List<String> group = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            lineCount += 1;
            group.add(line);
            if (lineCount == 3) {
                lineCount = 0;
                findItemInGroup(group.get(0), group.get(1), group.get(2), duplicatedItems);
                group = new ArrayList<>();
            }
        }
        int prioritySum = 0;
        for (Character c : duplicatedItems) {
            prioritySum += Arrays.asList(characters).indexOf(c) + 1;
        }
        System.out.println(prioritySum);
    }

    private static List<Character> findItemInGroup(String line1, String line2, String line3, List<Character> duplicatedItems) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : line1.toCharArray()) {
            set1.add(c);
        }
        for (char c : line2.toCharArray()) {
            set2.add(c);
        }

        set1.retainAll(set2);
        if (line3 != null) {
            Set<Character> set3 = new HashSet<>();

            for (char c : line3.toCharArray()) {
                set3.add(c);
            }
            set1.retainAll(set3);
        }

        duplicatedItems.addAll(set1);
        return duplicatedItems;
    }
}