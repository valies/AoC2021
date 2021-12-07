package Day05;

import Support.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {

    private static int highest;

    public static int getResultOfPart1(File txtFile) {
        ArrayList<String[]> ranges = getRanges(txtFile);
        int[][] allPoints = getAllPoints(ranges);
        int[][] grid = setUpGrid(highest + 1, highest + 1); //TODO: get this info from the data
        grid = fillGrid(grid, allPoints);
        int counter = 0;
        for (int i = 0; i < grid[0].length; i++) {
            counter += Arrays.stream(grid[i]).filter(x -> x >= 2).count();
        }
        return counter;
    }

    private static int[][] fillGrid(int[][] grid, int[][] allPoints) {
        for (int i = 0; i < allPoints.length; i++) {
            int[] range = allPoints[i];
            grid[range[1]][range[0]] += 1;
        }
        return grid;
    }

    private static int[][] setUpGrid(int width, int length) {
        int[][] grid = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = 0;
            }
        }
        return grid;
    }

    private static int[][] getAllPoints(ArrayList<String[]> ranges) {
        ArrayList<int[]> fullRanges = new ArrayList<>();
        highest = 0;
        for (String[] range : ranges) {
            try {
                int x1 = Integer.parseInt(range[0].split(":")[0]);
                int y1 = Integer.parseInt(range[0].split(":")[1]);
                int x2 = Integer.parseInt(range[1].split(":")[0]);
                int y2 = Integer.parseInt(range[1].split(":")[1]);
                if (x1 == x2 || y1 == y2) {
                    int minStart = x1;
                    int maxStart = x2;
                    if (x1 > x2) {
                        minStart = x2;
                        maxStart = x1;
                    }
                    for (int i = minStart; i <= maxStart; i++) {
                        int minStop = Integer.parseInt(range[0].split(":")[1]);
                        int maxStop = Integer.parseInt(range[1].split(":")[1]);
                        if (maxStop > highest) {
                            highest = maxStop;
                        }
                        if (maxStart > highest) {
                            highest = maxStart;
                        }
                        if (minStop > maxStop) {
                            minStop = Integer.parseInt(range[1].split(":")[0]);
                            maxStop = Integer.parseInt(range[0].split(":")[0]);
                        }
                        for (int j = minStop; j <= maxStop; j++) {
                            fullRanges.add(new int[]{i, j});
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        int[][] points = new int[fullRanges.size()][2];
        return fullRanges.toArray(points);
    }

    private static ArrayList<String[]> getRanges(File txtFile)
    {
        Scanner scan = FileReader.scanFile(txtFile);
        ArrayList<String[]> data = new ArrayList<>();
        while(scan.hasNextLine()){
            String line = scan.nextLine().replace(",", ":");
            String[] range = line.split(" -> ");
            Arrays.sort(range);
            data.add(range);
        }
        return data;
    }

    public static int getResultOfPart2(File txtFile) {
        return 0;
    }

    public static void main(String[] args) {
        File txtFile = new File("src/main/java/Day05/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile)); //7003 is too low
        //System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
