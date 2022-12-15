//package day5;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        readFile();
//    }
//
//
//    private static void readFile() throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src/day5/drawing.txt"));
//        String line;
//        boolean addStack = true;
//        List<String> lines = new ArrayList<>();
//        List<String> stack = new ArrayList<>();
//        List<String> procedures = new ArrayList<>();
//        while ((line = reader.readLine()) != null) {
//            if (addStack) {
//                if (line.equals("")) {
//                    addStack = false;
//                    continue;
//                }
//                stack.add(line);
//            } else {
//                procedures.add(line);
//            }
//
//        }
//        createStack(stack);
//        readProcedures(procedures);
//    }
//
//    private static void readProcedures(List<String> procedures) {
////        for (String procedure : procedures) {
////            System.out.println(procedure);
////            String noWhitespace = procedure.replaceAll("\\s", "");
////            System.out.println(noWhitespace);
////
////        }
//    }
//
//
//    //
//    private static void createStack(List<String> stack) {
//
//        int creates = 0;
//        List<List> stacks = new ArrayList<>();
//        for (int i = stack.size() - 1; i >= 0; i--) {
//            char[] test = stack.get(i).toCharArray();
//            List<Character> result = new ArrayList<>();
//            for (int j = 1; j < test.length; j = j + 4) {
//                if (Character.isDigit(test[j])) {
//                    continue;
//                }
//                result.add(test[j]);
//            }
//            if (!result.isEmpty()) {
//                stacks.add(result);
//            }
////        }
//        System.out.println(stacks);
//        transpose(stacks);
////
//    }
//
//    static <T> List<List<String>> transpose(List<List<String>> table) {
//        List<List<String>> ret = new ArrayList<List>();
//        final int N = table.get(0).size();
//        for (int i = 0; i < N; i++) {
//            List<String> col = new ArrayList<T>();
//            for (List<String> row : table) {
//                col.add(row.get(i));
//            }
//            ret.add(col);
//        }
//        return ret;
//    }
//}
////    private static int getNumberOfStacks( char[] chars) {
////        int  creates = 0;
////        for (int j = 1; j < chars.length; j = j + 4) {
////            char s = chars[j];
////
////            if (Character.isDigit(s)) {
////                creates++;
////
////            }
////        }
////        return creates;
////    }
////
////    private static void createMoves() {
////
////    }
//
//
