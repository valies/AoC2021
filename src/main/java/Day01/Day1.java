package Day01;

import Support.FileReader;

import java.io.File;

public class Day1 {
    public static int getResultOfPart1(File txtFile) {
        Integer[] input = FileReader.transformToIntArray(txtFile);
        int count = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i-1]) {
                count++;
            }
        }
        return count;
    }

    public static int getResultOfPart2(File txtFile) {
        Integer[] input = FileReader.transformToIntArray(txtFile);
        int count = 0;
        int previousSum = input[0];
        for (int i = 1; i < input.length - 2; i++) {
            int sum = input[i] + input[i+1] + input[i+2];
            if (sum > previousSum) {
                count++;
            }
            previousSum = sum;
        }
        return count;
    }

    public static void main(String[] args) {
        File txtFile = new File("src/main/java/Day01/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}