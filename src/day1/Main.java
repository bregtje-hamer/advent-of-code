package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile();
    }
    private static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day1/calories.txt"));

        String Int_line;
        int countCalories = 0;
        List<Integer> totalCalories = new ArrayList<Integer>();
        while ((Int_line = reader.readLine()) != null) {
            if (Int_line.isBlank()) {
                totalCalories.add(countCalories);
                countCalories = 0;
            }
            if (!Int_line.isBlank()) {
                int In_Value = Integer.parseInt(Int_line);
                countCalories += In_Value;
            }
        }
        totalCalories.add(countCalories);
        findMax(totalCalories);
    }

    private static void findMax( List<Integer> totalCalories ) {
        int top3 = 0;
        for (int i = 1; i < 4; i++) {
            System.out.println("Maximum element " + i + ": " + Collections.max(totalCalories));
            top3 += Collections.max(totalCalories);
            totalCalories.remove(totalCalories.indexOf(Collections.max(totalCalories)));
        }
        System.out.println("Total top 3: " + top3);
    }
}