package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    private static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day4/assignment.txt"));
        String line;
        int counterOne = 0;
        int counterTwo = 0;
        while ((line = reader.readLine()) != null) {


            String pairOne = line.split(",")[0];
            String pairTwo = line.split(",")[1];

            int first = Integer.parseInt(pairOne.split("-")[0]);
            int second = Integer.parseInt(pairOne.split("-")[1]);
            int third = Integer.parseInt(pairTwo.split("-")[0]);
            int fourth = Integer.parseInt(pairTwo.split("-")[1]);

            counterOne = part1(first, second, third, fourth, counterOne);
            counterTwo = part2(first, second, third, fourth, counterTwo);


        }
        System.out.println("Pairs part1 : " + counterOne);
        System.out.println("Pairs part2 : " + counterTwo);

    }

    private static int part1(int first, int second, int third, int fourth, int counter) {
        if (first >= third && second <= fourth) {
            counter++;
        } else if (third >= first && fourth <= second) {
            counter++;
        }
        return counter;
    }

    private static int part2(int first, int second, int third, int fourth, int counter) {
        if (first >= third && second <= fourth) {
            counter++;
        } else if (third >= first && fourth <= second) {
            counter++;
        } else if (second == third || first == fourth) {
            counter++;
        } else if (second <= fourth && second >= third) {

            counter++;
        } else if (first >= third && first <= fourth) {
            counter++;
        }
        return counter;
    }
}

