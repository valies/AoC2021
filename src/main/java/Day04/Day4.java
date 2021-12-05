package Day04;

import Support.FileReader;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {

    private static int sumOfUnmarkedNumbers = 0;

    public static int getResultOfPart1(File txtFile) {
        String[] numbers = getNumbers(txtFile);
        ArrayList<String[]> boards = getBoards(txtFile);
        for (String number : numbers) {
            boards = markNumber(boards, number);
            if(sumOfUnmarkedNumbers > 0) {
                return sumOfUnmarkedNumbers * Integer.parseInt(number);
            }
        }
        return 0;
    }

    private static String[] getNumbers(File txtFile) {
        Scanner scan = FileReader.scanFile(txtFile);
        return scan.nextLine().split(",");
    }

    private static ArrayList<String[]> getBoards(File txtFile) {
        Scanner scan = FileReader.scanFile(txtFile);
        scan.nextLine();
        scan.nextLine();
        ArrayList<String[]> boards = new ArrayList<>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine().trim() + " ";
            if (!line.equals(" ")) {
                boards.add(line
                        .replace("  ", " ")
                        .replace(" ", ":0 ")
                        .split(" "));
            }
        }
        return boards;
    }

    private static ArrayList<String[]> markNumber(ArrayList<String[]> boards, String number) {
        int boardSize = 5;
        ArrayList<String[]> newBoards = (ArrayList<String[]>) boards.clone();
        String hitPoint = number + ":0";
        for (int i = 0; i < boards.size(); i++) {
            if(sumOfUnmarkedNumbers == 0) {
                String[] markers = boards.get(i);
                for (int j = 0; j < markers.length; j++) {
                    if (Objects.equals(markers[j], hitPoint)) {
                        markers[j] = hitPoint.replace(":0", ":1");
                        newBoards.set(i, markers);
                        int start = (i / boardSize) * boardSize;
                        int end = start + boardSize;
                        List<String[]> markedBoard = boards.subList(start, end);
                        checkIsBingo(markedBoard, number);
                    }
                }
            } else {
                break;
            }
        }
        return newBoards;
    }

    private static void checkIsBingo(List<String[]> board, String lastNumber) {
        List<String[]> rowMatches = board.stream()
                .filter(x -> Arrays.stream(x)
                        .allMatch(y -> y.endsWith(":1")))
                .collect(Collectors.toList());
        List<String[]> transposedBoard = transpose(board);
        List<String[]> columnMatches = transposedBoard.stream()
                .filter(x -> Arrays.stream(x)
                        .allMatch(y -> y.endsWith(":1")))
                .collect(Collectors.toList());
        if (rowMatches.size() > 0 || columnMatches.size() > 0) {
            for (String[] strings : board) {
                for (String string : strings) {
                    if (string.endsWith(":0")) {
                        sumOfUnmarkedNumbers += Integer.parseInt(string.replace(":0", ""));
                    }
                }
            }
        }
    }

    public static List<String[]> transpose(List<String[]> board) {
        List<String[]> transposedBoard = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            StringBuilder column = new StringBuilder();
            column.append(board.get(0)[i]);
            for (int j = 1; j < board.size(); j++) {
                column.append(" " + board.get(j)[i]);
            }
            transposedBoard.add(column.toString().split(" "));
        }
        return transposedBoard;
    }

    public static int getResultOfPart2(File txtFile) {
        return 0;
    }

    public static void main(String[] args) {
        File txtFile = new File("src/main/java/Day04/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
