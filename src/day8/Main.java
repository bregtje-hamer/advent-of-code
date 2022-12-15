package day8;

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
        BufferedReader reader = new BufferedReader(new FileReader("src/day8/map.txt"));
        String line;
        List<String> lines = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        int[][] map = new int[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String s = lines.get(i);
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
//        System.out.println(map[0][0]);
        checkVisibility(map);

    }

    private static void checkVisibility(int[][] map) {

        int counter = 0;
//        counter += map.length * 2;
//        counter += (map[0].length - 2) * 2;
//        int test = 0;
        List<Integer> high = new ArrayList<>();
        for (int i = 1; i < map.length - 1; i++) {

            for (int j = 1; j < map[i].length - 1; j++) {

                //check right
                boolean visible;
            int   test =   checkMax(map[i][j], map[i], j) *

                        //check left
                        checkMin(map[i][j], map[i], j) *
//                    visible = true;

//                check top
                        checkBottom(map[i][j], map, i, j) *
//                        visible = true;
//            }
//                check bottom
                        checkTop(map[i][j], map, i, j);
//                    visible = true;

//                if (visible) {
//                    counter++;
//                }
                high.add(test);
            }
        }
        System.out.println("counter " + Collections.max(high));
    }

    private static int checkMax(int number, int[] map, int index) {
        index++;
        int treeCount = 0;
        boolean visible = true;
        for (int j = index; j < map.length; j++) {
            treeCount++;
            if (number <= map[j]) {
                return treeCount;
            }

        }
        return treeCount;

    }

    private static int checkMin(int number, int[] map, int index) {
        index--;
        int treeCount = 0;
        boolean visible = true;
        for (int j = index; j > -1; j--) {
            treeCount++;
            if (number <= map[j]) {
                return treeCount;
            }
        }
        return treeCount;

    }

    private static int checkBottom(int number, int[][] map, int currentRow, int index) {
        int treeCount = 0;
        boolean visible = true;
        for (int i = currentRow + 1; i < map.length; i++) {
            treeCount++;
            if (number <= map[i][index]) {
                return treeCount;
            }
        }
        return treeCount;
    }

    private static int checkTop(int number, int[][] map, int currentRow, int index) {
        int treeCount = 0;
        boolean visible = true;
        for (int i = currentRow - 1; i > -1; i--) {
            treeCount++;
            if (number <= map[i][index]) {
                return treeCount;
            }
        }
        return treeCount;
    }
}