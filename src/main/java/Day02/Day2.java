package Day02;

import Support.FileReader;

import java.io.File;
import java.util.ArrayList;

public class Day2 {

    public static int getResultOfPart1(File txtFile) {
        ArrayList<String[]> input = FileReader.transformToList(txtFile, " ");
        int x = 0;
        int y = 0;
        for (int i = 0; i < input.size(); i++) {
            int units = Integer.parseInt(input.get(i)[1]);
            switch(input.get(i)[0]) {
                case "forward":
                    x += units;
                    break;
                case "down":
                    y += units;
                    break;
                case "up":
                    y -= units;
                    break;
            }
        }
        return x * y;
    }

    public static int getResultOfPart2(File txtFile) {
        ArrayList<String[]> input = FileReader.transformToList(txtFile, " ");
        int a = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < input.size(); i++) {
            int units = Integer.parseInt(input.get(i)[1]);
            switch(input.get(i)[0]) {
                case "forward":
                    x += units;
                    y += a * units;
                    break;
                case "down":
                    a += units;
                    break;
                case "up":
                    a -= units;
                    break;
            }
        }
        return x * y;
    }

    public static void main(String[] args) {
        File txtFile = new File("src/main/java/Day02/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
