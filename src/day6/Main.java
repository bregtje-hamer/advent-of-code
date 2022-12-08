package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile(3);
        readFile(14);
    }

    private static void readFile(int counter) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day6/buffer.txt"));
        String line;
        LinkedList<Character> fourCharacters = new LinkedList<>();

        while ((line = reader.readLine()) != null) {
            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                fourCharacters.add(charArray[i]);

                if (i == counter) {
                    if (counter > 3) {
                        fourCharacters.removeFirst();
                    }

                    if (checkMarker(fourCharacters)) {
                        System.out.println("NUMBER " + (i + 1));
                        return;
                    }
                    counter += 1;
                }
            }
        }
    }

    private static boolean checkMarker(LinkedList<Character> characters) {
        Set<Character> set = new HashSet<>();
        for (Character c : characters) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}

