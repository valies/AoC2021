package Day03;

import Support.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day3 {

    public static int getResultOfPart1(File txtFile) {
        String[] input = FileReader.transformToStringArray(txtFile);
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        ArrayList<Integer> mostCommonDigits = getMostCommonDigits(input);
        ArrayList<Integer> leastCommonDigits = getLeastCommonDigits(input);
        for (int i = 0; i < mostCommonDigits.size(); i++) {
            gamma.append(mostCommonDigits.get(i));
            epsilon.append(leastCommonDigits.get(i));
        }
        return Integer.parseInt(gamma.toString(),2) * Integer.parseInt(epsilon.toString(), 2);
    }

    public static int getResultOfPart2(File txtFile) {
        String[] input = FileReader.transformToStringArray(txtFile);
        String[] oxygenMatches = input.clone();
        String[] co2Matches = input.clone();
        StringBuilder oxygen = new StringBuilder();
        StringBuilder co2 = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (oxygenMatches.length > 1) {
                ArrayList<Integer> mostCommonDigits = getMostCommonDigits(oxygenMatches);
                oxygen.append(mostCommonDigits.get(i));
                oxygenMatches = getMatches(oxygenMatches, oxygen.toString());
            }
            if (co2Matches.length > 1) {
                ArrayList<Integer> leastCommonDigits = getLeastCommonDigits(co2Matches);
                co2.append(leastCommonDigits.get(i));
                co2Matches = getMatches(co2Matches, co2.toString());
            }
            if (oxygenMatches.length == 1 && co2Matches.length == 1) {
                break;
            }
        }
        return Integer.parseInt(oxygenMatches[0],2) * Integer.parseInt(co2Matches[0], 2);
    }

    private static String[] getMatches(String[] input, String startsWith) {
        List<String> matches = Arrays.stream(input)
                .distinct()
                .filter(x -> x.startsWith(startsWith.toString()))
                .collect(Collectors.toList());
        return matches.toArray(new String[0]);
    }

    private static ArrayList<Integer> getCountOfOnesPerColumn(String[] input) {
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
        return ones;
    }

    private static ArrayList<Integer> getMostCommonDigits(String[] input) {
        ArrayList<Integer> ones = getCountOfOnesPerColumn(input);
        ArrayList<Integer> mostCommonDigits = new ArrayList<>();
        int half = (int) Math.ceil((double) input.length / 2);
        for (Integer one : ones) {
            if (one >= half) {
                mostCommonDigits.add(1);
            } else {
                mostCommonDigits.add(0);
            }
        }
        return mostCommonDigits;
    }

    private static ArrayList<Integer> getLeastCommonDigits(String[] input) {
        ArrayList<Integer> ones = getCountOfOnesPerColumn(input);
        ArrayList<Integer> leastCommonDigits = new ArrayList<>();
        int half = (int) Math.ceil((double) input.length / 2);
        for (Integer one : ones) {
            if (one >= half) {
                leastCommonDigits.add(0);
            } else {
                leastCommonDigits.add(1);
            }
        }
        return leastCommonDigits;
    }

    public static void main(String[] args) {
        File txtFile = new File("src/main/java/Day03/input.txt");
        System.out.println("Part 1: " + getResultOfPart1(txtFile));
        System.out.println("Part 2: " + getResultOfPart2(txtFile));
    }
}
