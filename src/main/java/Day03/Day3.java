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
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int i = 0; i < ones.size(); i++) {
            if (ones.get(i) > input.length/2) {
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
        return Integer.parseInt(gamma.toString(),2) * Integer.parseInt(epsilon.toString(), 2);
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
