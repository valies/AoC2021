package Day03;

import Support.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Day3 {

    public static int getResultOfPart1(File txtFile) {
        String[] input = FileReader.transformToStringArray(txtFile);
        ArrayList<Integer> ones = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String[] bits = input[i].split("(?!^)");
            for (int j = 0; j < bits.length; j++) {
                if (i == 0) {
                    ones.add(Integer.parseInt(bits[j]));
                } else {
                    if (Objects.equals(bits[j], "1")) {
                        ones.set(j, ones.get(j) + 1);
                    }
                }
            }
        }
        int possibilities = input.length;
        String gamma = "";
        String epsilon = "";
        for (Integer one: ones) {
            if (one > possibilities/2) {
                gamma = gamma + "1";
                epsilon = epsilon + "0";
            } else {
                gamma = gamma + "0";
                epsilon = epsilon + "1";
            }
        }
        return Integer.parseInt(gamma,2) * Integer.parseInt(epsilon, 2);
    }

    public static int getResultOfPart2(File txtFile) {
        return 0;
    }

    public static void main(String[] args) {
        File txtFile = new File("src/main/java/Day03/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
